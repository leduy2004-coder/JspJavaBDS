package com.laptrinhjava.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjava.model.RoleModel;
import com.laptrinhjava.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("username"));
			user.setFullName(resultSet.getString("fullname"));
			user.setPassword(resultSet.getString("password"));
			user.setThumbnail(resultSet.getString("thumbnail"));
			user.setStatus(resultSet.getInt("status"));
			user.setCreatedDate(resultSet.getTimestamp("createddate"));
			user.setEmail(resultSet.getString("email"));
			user.setStatusAuthen(resultSet.getInt("statusauthen"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				user.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				user.setModifiedBy(resultSet.getString("modifiedby"));
			}
			if (resultSet.getString("authentication") != null) {
				user.setAuthentication(resultSet.getString("authentication"));
			}

			try {
				user.setRoleid(resultSet.getLong("roleid"));
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				user.setRole(role);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
			return user;
		} catch (SQLException e) {
			return null;
		}
	}

}
