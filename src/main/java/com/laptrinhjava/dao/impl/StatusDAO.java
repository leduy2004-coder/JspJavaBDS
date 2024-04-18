package com.laptrinhjava.dao.impl;

import java.util.List;

import com.laptrinhjava.dao.IStatusDAO;
import com.laptrinhjava.mapper.StatusMapper;
import com.laptrinhjava.model.StatusModel;

public class StatusDAO extends AbstractDAO<StatusModel> implements IStatusDAO {

	@Override
	public List<StatusModel> findAll() {
		String sql = "SELECT * FROM status";
		return query(sql, new StatusMapper());
	}

	@Override
	public StatusModel findOne(long id) {
		String sql = "SELECT * FROM status WHERE id = ?";
		List<StatusModel> status = query(sql, new StatusMapper(), id);
		return status.isEmpty() ? null : status.get(0);
	}

	@Override
	public StatusModel findOneByCode(String code) {
		String sql = "SELECT * FROM status WHERE code = ?";
		List<StatusModel> status = query(sql, new StatusMapper(), code);
		return status.isEmpty() ? null : status.get(0);
	}

}
