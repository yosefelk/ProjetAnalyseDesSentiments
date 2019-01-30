package org.ensah.system;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.ensah.system.beans.Comment;
import org.ensah.system.beans.Notification;
import org.ensah.system.beans.Post;
import org.ensah.system.beans.User;
import org.ensah.system.service.CommentService;
import org.ensah.system.service.NotificationService;
import org.ensah.system.service.PostService;
import org.ensah.system.service.UserService;
import org.ensah.system.service.WordpolarityService;
import org.ensah.system.validation.CommentValidation;
import org.ensah.system.validation.PostValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/post")
public class PostController {


	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private WordpolarityService wordpolarityService;

	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public String getProfil(@RequestParam int userId, Locale locale, ModelMap model, HttpSession session) {
		//Test d'authentification:
		if(session.getAttribute("user")==null){
			return "redirect:../user/login";
		}
		else{
			List<Post> posts = postService.getAllPosts(userId);
			User profilUser= userService.getUser(userId);
			List<Integer> commentsNum=new ArrayList<Integer>();
			for (int j = 0; j < posts.size(); j++) {
				commentsNum.add(commentService.getAllComments(posts.get(j).getP_id()).size());
			}
			model.put("commentsNum", commentsNum);
			model.addAttribute("postsById", posts);
			session.setAttribute("currentProfil", profilUser);
			return "post/profil";
		}
	}
	
	@RequestMapping(value = "/removepost", method = RequestMethod.GET)
	public String removePost(@RequestParam int postId, Locale locale, ModelMap model, HttpSession session) {
		//Test d'authentification:
		if(session.getAttribute("user")==null){
			return "redirect:../user/login";
		}
		else{
			if(session.getAttribute("currentProfil")==null || session.getAttribute("currentProfil")!=session.getAttribute("user")){
				return "redirect:post/poster";
			}
			else{
				List<Post> posts = postService.getAllPosts(((User) (session.getAttribute("currentProfil"))).getU_id());
				List<Integer> commentsNum=new ArrayList<Integer>();
				for (int j = 0; j < posts.size(); j++) {
					commentsNum.add(commentService.getAllComments(posts.get(j).getP_id()).size());
				}
				model.put("commentsNum", commentsNum);
				model.addAttribute("postsById", posts);
				return "post/profil";
			}
		}
	}

	@RequestMapping(value="/showalone", method=RequestMethod.GET)
	public String showAlone(@RequestParam int postId, ModelMap model, HttpSession session){
		if(session.getAttribute("user")==null){
			return "redirect:../user/login";
		}
		else{
			Post currentPost = postService.getPost(postId);
			List<Comment> comments = commentService.getAllComments(postId);
			List<User> users=new ArrayList<User>();
			for (int i = 0; i < comments.size(); i++) {
				users.add(userService.getUser(comments.get(i).getC_user()));
			}
			User publier= userService.getUser(currentPost.getP_user());
			model.addAttribute("publier", publier);
			model.put("users",users);
			model.addAttribute("comments", comments);
			model.addAttribute("currentPost", currentPost);
			model.addAttribute("commentData", new Comment());
			session.setAttribute("currentPost", currentPost);
			return "post/showalone";
		}

	}

	@RequestMapping(value = "/showalone", method = RequestMethod.POST)
	public String commenter(Locale locale, ModelMap model, @ModelAttribute("commentData") @Valid Comment comment, BindingResult br, HttpSession session) {
		CommentValidation commentValidation = new CommentValidation();
		commentValidation.validate(commentValidation, br);
		//Test d'authentification:
		if(session.getAttribute("user")==null){
			return "redirect:../user/login";
		}
		else{
			if(session.getAttribute("currentPost")==null){
				return "redirect:post/poster";
			}
			else if (br.hasErrors()) {
				return "post/showalone";
			} else {
				Post cupost=(Post)session.getAttribute("currentPost");
				model.addAttribute("commentData", new Comment());
				Date d=new Date();
				comment.setC_date(d);
				comment.setC_rating(wordpolarityService.getTextPolarity(comment.getC_text()));
				comment.setC_user(((User) session.getAttribute("user")).getU_id());
				comment.setC_post(cupost.getP_id());
				commentService.saveComment(comment);
				
				//redefine Polarity:
				System.out.println("post. " + cupost);

				double note = 0.0;
				// On récupère les commentaires de la destination
				List<Comment> comments = commentService.getAllComments(cupost.getP_id());
				
				// On clacule la polarité de chaque commentaire
				for (Comment itc : comments) {
					System.err.println("comment ==> "+itc.getC_text()+" ==> "+itc.getC_rating());
					note += itc.getC_rating();
				}
				System.err.println("note: "+note);
				note=(double) (note / comments.size());
				int polarity=(((int) (note*100)));
				System.err.println("Rating: "+note);
				if (comments.size() != 0) {
					cupost.setP_polarity(polarity);
				}
				postService.setPostPolarity(cupost.getP_id(), polarity);

				List<User> users=new ArrayList<User>();
				for (int i = 0; i < comments.size(); i++) {
					users.add(userService.getUser(comments.get(i).getC_user()));
				}
				User publier= userService.getUser(cupost.getP_user());
				model.addAttribute("publier", publier);
				model.put("users",users);
				model.addAttribute("comments", comments);
				
				//Ajouter une notification:
				Notification notification=new Notification();
				notification.setN_date(d);
				notification.setN_post(((Post) session.getAttribute("currentPost")).getP_id());
				notification.setN_user(((User) session.getAttribute("user")).getU_id());
				notification.setN_situation(false);
				notificationService.saveNotification(notification);
				return "post/showalone";
			}
		}
	}
	//this mothod return only register page request comes to /post/poster
	@RequestMapping(value = "/poster", method = RequestMethod.GET)
	public String showForm(Locale locale, ModelMap model, HttpSession session) {
		//Test d'authentification:
		if(session.getAttribute("user")==null){
			return "redirect:../user/login";
		}
		else{
			List<Post> posts = postService.getAllPosts(-1);
			List<User> users=new ArrayList<User>();
			List<Integer> commentsNum=new ArrayList<Integer>();
			for (int j = 0; j < posts.size(); j++) {
				commentsNum.add(commentService.getAllComments(posts.get(j).getP_id()).size());
			}
			for (int i = 0; i < posts.size(); i++) {
				users.add(userService.getUser(posts.get(i).getP_user()));
			}
			model.put("commentsNum", commentsNum);
			model.put("users",users);
			model.addAttribute("posts", posts);

			model.put("postData", new Post());
			session.removeAttribute("currentPost");
			session.removeAttribute("currentProfil");
			return "post/poster";
		}
	}

	@RequestMapping(value = "/poster", method = RequestMethod.POST)
	public String saveForm(Locale locale, ModelMap model, @ModelAttribute("postData") @Valid Post post, BindingResult br, HttpSession session,
			@RequestParam("fileUpload") MultipartFile file) throws Exception {
		//Test d'authentification:
		if(session.getAttribute("user")==null){
			return "redirect:../user/login";
		}
		else{
			PostValidation postValidation = new PostValidation();
			postValidation.validate(postValidation, br);
			if(session.getAttribute("user")==null){
				return "redirect:../user/login";
			}
			else{
				if (br.hasErrors()) {
					return "post/poster";
				} else {
					Date d=new Date();
					post.setP_date(d);
					post.setP_polarity(0);
					post.setP_user(((User) session.getAttribute("user")).getU_id()) ;
					byte[] bytes = file.getBytes();
					byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
					String base64Encoded = new String(encodeBase64, "UTF-8");
					post.setP_image(bytes);
					post.setBase64image(base64Encoded);
					postService.savePost(post);
					return "redirect:/post/showalone?postId="+post.getP_id();
				}
			}
		}
	}
}
