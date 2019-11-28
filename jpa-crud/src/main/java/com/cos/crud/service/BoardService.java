package com.cos.crud.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.Board;
import com.cos.crud.model.User;
import com.cos.crud.repository.BoardRepository;
import com.cos.crud.util.Script;

@Service
public class BoardService {
	@Autowired
	private BoardRepository mRepo;

	// try - catch (check, uncheck)

	@Transactional //같은 트랜잭션으로 묶여있으니 하나라도 안되면 x 다같이 되야함
	public void increaseCountAndTimeUpdate(int id) {
		try {
			mRepo.increaseCount(id);
			mRepo.timeUpdate(id);
		} catch (Exception e) {
			throw new RuntimeException();
		
		}

	}

	// DB관련로직만 서비스에 필요하다.
	public List<Board> boardList() {
		List<Board> boards = mRepo.findAll();

		return boards;
	}

	public Board boardDetail(int id) {
		Optional<Board> board = mRepo.findById(id);
		return board.get();
	}

	public int boardWrite(Board board, HttpSession session) {
		try {
			User user = (User) session.getAttribute("user");
			board.setUser(user);
			mRepo.save(board);
		} catch (Exception e) {
			System.out.println("boardwrite : 오류");
		}
		return -1;
	}

	public int boardDelete(int id) {
		try {
			mRepo.deleteById(id);
			return 1;
		} catch (Exception e) {
			System.out.println("board delete : 오류");
		}
		return -1;
	}

	public Board boardUpdateForm(int id) {
		Optional<Board> board = mRepo.findById(id);
		return board.get();

	}

	public int boardUpdate(Board board) {
		try {
			mRepo.save(board);
			return 1;
		} catch (Exception e) {
			System.out.println("업데이트 오류");
		}
		return -1;
	}
}
