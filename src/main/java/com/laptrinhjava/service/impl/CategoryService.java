package com.laptrinhjava.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjava.dao.ICategoryDAO;
import com.laptrinhjava.model.CategoryModel;
import com.laptrinhjava.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {

		return categoryDao.findAll();
	}

}
