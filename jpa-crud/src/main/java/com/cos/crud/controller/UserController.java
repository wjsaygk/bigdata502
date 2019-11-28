package com.cos.crud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.User;
import com.cos.crud.repository.UserRepository;
import com.cos.crud.service.UserService;
import com.cos.crud.util.Script;

import ch.qos.logback.core.db.dialect.MsSQLDialect;

@Controller
public class UserController {
	@Autowired
	private UserService mService;
	
	@GetMapping("/user/{id}")
	public @ResponseBody List<User> getUser(@PathVariable int id){
		
		return mService.getUser(id);
	}
		
	
	@PostMapping("/user/login")
	public @ResponseBody String userLogin(User user, HttpSession session, HttpServletResponse response) {
		User u =mService.userLogin(user);
		if(u != null) {
			session.setAttribute("user", u);
			return Script.href("/");
		}else {
			return Script.Back("fail");
		}
		
	}
	@GetMapping("/user/loginForm")
	public String userLoginForm() {
		return "user/loginForm";
	}
	
	@PostMapping("/user/join")
	public String userJoin(User user) {
	int result =	mService.userJoin(user);
	if(result == 1) {
		return "redirect:/board/list";
	}else {
		return "redirect:/user/joinForm";
	}
		
	}
	@GetMapping("/user/joinForm")
	public String userJoinForm() {
		return "user/joinForm";
	}
	@GetMapping("/user/logout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
