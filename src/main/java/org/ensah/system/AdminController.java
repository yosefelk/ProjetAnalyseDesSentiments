package org.ensah.system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.ensah.system.beans.Admin;
import org.ensah.system.beans.Comment;
import org.ensah.system.beans.Post;
import org.ensah.system.beans.User;
import org.ensah.system.service.AdminService;
import org.ensah.system.service.PostService;
import org.ensah.system.service.UserService;
import org.ensah.system.validation.UserValidation;
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
@RequestMapping(value="/admin")
public class AdminController {
	
	
	@Autowired
	private UserService userService;
	@Autowired 
	private PostService postService;
	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeAdmin(Locale locale, ModelMap model, HttpSession session) {
		if(session.getAttribute("admin") != null) {
			List<Post>posts=postService.getAllPosts(-1);
			model.put("listePost", posts);
			return "admin/home";
		}else {
			return "redirect:../admin/adminlogin";
		}
	}
		
	//this mothod return only register page request comes to /user/register
	@RequestMapping(value = "/listpost", method = RequestMethod.GET)
	public String showForm(Locale locale, ModelMap model, HttpSession session) {
		if(session.getAttribute("admin") != null) {
			List<Post>posts=postService.getAllPosts(-1);
			model.put("listePost", posts);
			return "admin/admin";
		}else {
			return "redirect:../admin/adminlogin";
		}
	}
	
	//this mothod return only register page request comes to /user/register
		@RequestMapping(value = "/listuser", method = RequestMethod.GET)
		public String listUser(Locale locale, ModelMap model, HttpSession session) {
			if(session.getAttribute("admin") != null) {
				List<User>users=userService.getAllUser();
				model.put("listeUser", users);
				return "admin/adminUser";
			}else {
				return "redirect:../admin/adminlogin";
			}
		}
		
	
		
	//this mothod return only login page request comes to /user/login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(ModelMap model, HttpSession session) {
		if(session.getAttribute("admin") == null) {
			model.put("adminData", new Admin());
			return "admin/adminlogin";
		}else {
			return "redirect:../admin/admin";
		}
	}
	
	//this method process the login form and authenticate user if login is valid
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(Locale locale, ModelMap model, @ModelAttribute("adminData") @Valid Admin admin, BindingResult br, HttpSession session) {
		if(session.getAttribute("admin")==null)
		{
			if(admin.getA_email()!=null && admin.getA_password()!=null ) {

				admin = adminService.loginAdmin(admin);

				if(admin!=null) {
					session.setAttribute("admin", admin);
					return "redirect:../admin/home";
				}else{
					model.put("failed", "Login failed.");
					return "admin/adminlogin";

				}

			}else {

			}
			model.put("failed", "Login failed.");
			return "admin/adminlogin";
		}else{
			return "redirect:../admin/home";
		}

	}

	@RequestMapping(value="/deletepost", method=RequestMethod.GET)
	public String deletepost(@RequestParam int postId, ModelMap model, HttpSession session){
		
		List<Post>posts = postService.getAllPosts(-1);
		adminService.removePost(postId);

		return "redirect: admin/admin";
		
		
	}
	
	@RequestMapping(value="/deleteuser", method=RequestMethod.GET)
	public String deleteuser(@RequestParam int userId, ModelMap model, HttpSession session){
		
			adminService.removeUser(userId);

		return "admin/adminUser";
		
	}
	
	//this method used to logout
	@RequestMapping(value ="/logout", method = RequestMethod.GET)
	public String logOut(ModelMap model, HttpSession session) {
		session.removeAttribute("admin");
		return "redirect:../adminlogin";
	}
	

}
