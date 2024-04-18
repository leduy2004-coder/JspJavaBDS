package com.laptrinhjava.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import com.laptrinhjava.dao.IUserDAO;
import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.service.IUserService;
import com.laptrinhjava.utils.RandomNumber;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status,
			Integer statusAthen) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status, statusAthen);
	}

	@Override
	public UserModel findOne(long id) {
		return userDAO.findOne(id);
	}

	@Override
	public UserModel save(UserModel userModel) {
		userModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		userModel.setThumbnail("anhdaidien");
		Long newId = userDAO.save(userModel);
		return userDAO.findOne(newId);
	}

	@Override
	public void updateAuthen(UserModel authen) {
		String numberRandom = RandomNumber.getSoNgauNhien();

		Date todaysDate = new Date(new java.util.Date().getTime());
		Calendar c = Calendar.getInstance();
		c.setTime(todaysDate);
		c.add(Calendar.DATE, 1);

		Date time = new Date(c.getTimeInMillis());
		authen.setAuthentication(numberRandom);
		authen.setTime(time);
		userDAO.updateAuthen(authen);
	}

	@Override
	public UserModel findEmail(String email) {
		return userDAO.findEmail(email);
	}

}
