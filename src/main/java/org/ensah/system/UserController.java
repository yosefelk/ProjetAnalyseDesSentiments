package org.ensah.system;

import java.io.IOException;
import java.util.Base64;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.ensah.system.beans.User;
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
@RequestMapping(value="/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
		
	//this mothod return only register page request comes to /user/register
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showForm(Locale locale, ModelMap model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			model.put("userData", new User());
			return "register/register";
		}else {
			return "redirect:../post/poster";
		}
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveForm(Locale locale, @ModelAttribute("userData") @Valid User user, BindingResult br, HttpSession session,
					@RequestParam("fileUpload") MultipartFile file) throws IOException {
		UserValidation userValidation = new UserValidation();
		userValidation.validate(userValidation, br);
		if (br.hasErrors()) {
			return "register/register";
		} else {
			byte[] bytes = file.getBytes();
			byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
            String base64Encoded = new String(encodeBase64, "UTF-8");
            user.setU_image(bytes);
            user.setBase64image(base64Encoded);
			userService.saveUser(user);
			session.setAttribute("user", user);
			return "redirect:../post/poster";
		}
		
	}
	
	//following 2 methods are used for login processing
	
	//this mothod return only login page request comes to /user/login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(ModelMap model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			model.put("userData", new User());
			return "login/login";
		}else {
			return "redirect:../post/poster";
		}
	}
	
	//this method process the login form and authenticate user if login is valid
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(Locale locale, ModelMap model, @ModelAttribute("userData") @Valid User user, BindingResult br, HttpSession session) {
		if(user.getU_email()!=null && user.getU_password()!=null && session.getAttribute("user")==null) {
			user = userService.loginUser(user);
			if(user!=null) {
				session.setAttribute("user", user);
				return "redirect:../post/poster";
			}else {
				model.put("failed", "Login failed.");
				return "login/login";
			}
		}else {
			return "redirect:../post/poster";
		}
		
	}
	
	//this method used to logout
	@RequestMapping(value ="/logout", method = RequestMethod.GET)
	public String logOut(ModelMap model, HttpSession session) {
		session.removeAttribute("user");
		return "redirect:login";
	}
	

}
