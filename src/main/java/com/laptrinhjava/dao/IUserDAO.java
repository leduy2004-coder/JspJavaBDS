package com.laptrinhjava.dao;

import com.laptrinhjava.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status,
			Integer statusAuthen);

	Long save(UserModel userModel);

	UserModel findOne(Long id);

	UserModel findEmail(String email);

	void updateAuthen(UserModel authen);
}
