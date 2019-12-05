package com.cos.crud.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.User;
import com.cos.crud.repository.UserRepository;
import com.cos.crud.utils.Script;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository uRepo;
	
	
	
	@PostMapping("/join")
	public String join(User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		uRepo.insert(user);
		return "redirect:/user/loginForm";
	}
	
	
	@GetMapping ("/joinForm")
	public String joinForm() {		
		return "/user/joinForm";
	}
	
	@PostMapping("/login")
	public @ResponseBody String userLogin(User user, HttpSession session, HttpServletResponse response) {
		System.out.println("userLogin : 진입");
		User u =uRepo.login(user);
		System.out.println("userLogin : DATA ACCESS 완료");
		if(u != null) {
			session.setAttribute("user", u);
			return Script.href("/home/list");
		}else {
			return Script.Back("fail");
		}	
	}
	
	@GetMapping("/logout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/home/list";
	}
	
	@GetMapping("/loginForm")
	public String userLoginForm() {
		return "/user/loginForm";
	}
	
	

	
}
