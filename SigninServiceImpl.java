package com.training.test.service;

import java.util.List;

import com.training.test.dao.SigninDao;
import com.training.test.dao.SigninDaoImpl;
import com.training.test.model.Product;



public class SigninServiceImpl implements SigninService {
	
	SigninDao dao = new SigninDaoImpl();

	@Override
    public boolean isValidUser(String username, String password) {
		
		boolean isValid = false;
		List<Product> prodList = dao.getUsers();
		for (Product user : prodList) {
			if (user.getName().equals(username) && user.getDesc().equals(password)) {
				isValid = true;
			}
		}
		return isValid;
	}
	
	@Override
	public List<Product> getUsers() {
		List<Product> prodList = dao.getUsers();
		return prodList;
	}

}
