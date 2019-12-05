package com.cos.crud.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.Post;
import com.cos.crud.repository.PostRepository;
import com.cos.crud.service.PostService;

@Controller
@RequestMapping("/home")
public class PostController {

	@Autowired
	private PostService pService;
	/*
	 * @Autowired private PostRepository pRepo;
	 */

	// http://localhost:8080/post
	// http://localhost:8080/post/
	// Model은 데이터를 Controller에서 Presentation 계층까지
	// 들고간다.

	// GET => http://localhost:8080/post
	// GET => http://localhost:8080/post/
	/*
	 * @Autowired private PostRepository pRepo;
	 */

	/*
	 * @GetMapping("") public String home() { return "/post/home"; }
	 */

	@GetMapping("/list")
	public String postList(Model model) {
		List<Post> posts = pService.postList();
		model.addAttribute("posts", posts);
		return "/post/list";
	}

	// webapp/WEB-INF/views/post/list.jsp }

	@GetMapping("/index")
	public String index() {
		return "/post/index";
	}

	@GetMapping("/post")
	public String writeForm() {
		return "/post/writeForm";
	}

	@PostMapping("/write")
	public String boardWrite(Post post, HttpSession session) {

		int result = pService.save(post);
		if (result == 1) {
			return "redirect:/home/list";
		} else {
			return "redirect:/home/post";
		}

	}

	// post/4
	// POST => //http://localhost:8080/post/update

	@PostMapping("/update")
	public String update(Post post) {
		try {
			pService.update(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/home/list";
	}// redirect 함수를 다시실행(호출) 시킬수 있다. }

	// delete - form, get 방식 id=1 @RequestParam("id")
	// @RequestBody => JSON
	// POST => //http://localhost:8080/post/delete/1

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		try {
			pService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/home/list"; // 함수를 호출한다. }
	}

	// http://localhost:8080/post/save

	@GetMapping("/detail/{id}")
	public String post(@PathVariable int id, Model model) {
		System.out.println("detail 진입");
		Post post = pService.post(id);
		model.addAttribute("post", post);
		return "post/detail";
	}

	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		Post post = pService.updateForm(id);
		model.addAttribute("post", post);
		return "post/updateForm";
	}

}
