package com.laptrinhjava.dao;

import java.util.List;

import com.laptrinhjava.model.StatusModel;

public interface IStatusDAO extends GenericDAO<StatusModel> {
	List<StatusModel> findAll();

	StatusModel findOne(long id);

	StatusModel findOneByCode(String code);
}
