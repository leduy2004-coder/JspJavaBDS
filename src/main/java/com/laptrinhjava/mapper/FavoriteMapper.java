package com.laptrinhjava.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjava.model.FavoriteModel;

public class FavoriteMapper implements RowMapper<FavoriteModel> {

	@Override
	public FavoriteModel mapRow(ResultSet resultSet) {
		try {
			FavoriteModel news = new FavoriteModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setUser_id(resultSet.getLong("user_id"));
			news.setNew_id(resultSet.getLong("new_id"));
			news.setPrice(resultSet.getString("price"));
			news.setCreatedDate(resultSet.getTimestamp("createddate"));
			news.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				news.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			return null;
		}
	}

}
