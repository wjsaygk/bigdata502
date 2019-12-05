package com.cos.crud.repository;

import java.util.List;

import com.cos.crud.model.User;

public interface UserRepository {
	User login(User user);
	void insert(User user);
}
