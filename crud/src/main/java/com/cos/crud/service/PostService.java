package com.cos.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.crud.model.Post;
import com.cos.crud.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
    private PostRepository pRepo;


	public List<Post>  postList() {
	
		List<Post> posts = pRepo.findAll();
		
		//webapp/WEB-INF/views/post/list.jsp
		return posts;
	}
	
	/*
	 * @GetMapping("/writeForm") public String writeForm() { return
	 * "post/writeForm"; }
	 */

	public int update(Post post) { //param, form
		try {
			pRepo.update(post);
			return 1;
		} catch (Exception e) {
			System.out.println("업데이트 오류 ");
		}
		return -1;    //redirect 함수를 다시실행(호출) 시킬수 있다.
	}

	public int delete( int id) {
		try {
			pRepo.delete(id);
			return 1;
		} catch (Exception e) {
			System.out.println("딜리트 오류");
		}
		return -1; // 함수를 호출한다.
	}
	
	public int save(Post post) { //id =0 , createDate = null, userId =0
		try {
			pRepo.save(post);
			return 1;
		} catch (Exception e) {
			System.out.println("세이브 오류");
		}
		return  -1; 
	}
	
	
	public Post post(int id) {
		
			Post post = pRepo.findById(id);
			System.out.println("detail 서비스 진입");
			return post;
	}
	   public Post updateForm(int id) {
		      Post post = pRepo.findById(id);
		      return post;
		      
		   }
}
