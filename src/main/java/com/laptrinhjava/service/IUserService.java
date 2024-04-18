package com.laptrinhjava.service;

import com.laptrinhjava.model.UserModel;

public interface IUserService {
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status,
			Integer statusAuthen);

	UserModel save(UserModel userModel);

	UserModel findOne(long id);

	UserModel findEmail(String email);

	void updateAuthen(UserModel authen);
}
