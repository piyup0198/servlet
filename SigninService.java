package com.training.test.service;

import java.util.List;

import com.training.test.model.Product;

public interface SigninService {
	
	boolean isValidUser(String username, String password);
	
	List<Product> getUsers();
	
}