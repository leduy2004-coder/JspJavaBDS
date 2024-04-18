package com.laptrinhjava.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjava.dao.IStatusDAO;
import com.laptrinhjava.model.StatusModel;
import com.laptrinhjava.service.IStatusService;

public class StatusService implements IStatusService {

	@Inject
	private IStatusDAO statusDAO;

	@Override
	public List<StatusModel> findAll() {

		return statusDAO.findAll();
	}

}
