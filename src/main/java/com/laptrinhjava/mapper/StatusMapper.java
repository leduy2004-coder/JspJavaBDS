package com.laptrinhjava.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjava.model.StatusModel;

public class StatusMapper implements RowMapper<StatusModel> {

	@Override
	public StatusModel mapRow(ResultSet resultSet) {
		try {
			StatusModel status = new StatusModel();
			status.setId(resultSet.getLong("id"));
			status.setCode(resultSet.getString("code"));
			status.setName(resultSet.getString("name"));
			return status;
		} catch (SQLException e) {
			return null;
		}

	}

}
