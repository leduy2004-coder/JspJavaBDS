package com.laptrinhjava.dao.impl;

import java.util.List;

import com.laptrinhjava.dao.IUserDAO;
import com.laptrinhjava.mapper.UserMapper;
import com.laptrinhjava.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status,
			Integer statusAuthen) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username = ? AND password = ? AND status = ? AND statusauthen=?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status, statusAuthen);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Long save(UserModel userModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO user(username, password, fullname,");
		sql.append("  status, roleid,thumbnail, createddate, email, statusauthen)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?,?)");
		return insert(sql.toString(), userModel.getUserName(), userModel.getPassword(), userModel.getFullName(),
				userModel.getStatus(), userModel.getRoleid(), userModel.getThumbnail(), userModel.getCreatedDate(),
				userModel.getEmail(), userModel.getStatusAuthen());
	}

	@Override
	public UserModel findOne(Long id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		List<UserModel> user = query(sql, new UserMapper(), id);

		return user.isEmpty() ? null : user.get(0);
	}

	@Override
	public void updateAuthen(UserModel authen) {
		String sql = "UPDATE user SET authentication=? , time=?, statusauthen=? WHERE id=?";
		update(sql, authen.getAuthentication(), authen.getTime(), authen.getStatusAuthen(), authen.getId());
	}

	@Override
	public UserModel findEmail(String email) {
		String sql = "SELECT * FROM user WHERE email = ?";
		List<UserModel> user = query(sql, new UserMapper(), email);

		return user.isEmpty() ? null : user.get(0);
	}

}