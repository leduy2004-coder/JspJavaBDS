package com.laptrinhjava.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjava.dao.ICategoryDAO;
import com.laptrinhjava.dao.INewDAO;
import com.laptrinhjava.dao.IStatusDAO;
import com.laptrinhjava.model.CategoryModel;
import com.laptrinhjava.model.NewModel;
import com.laptrinhjava.model.StatusModel;
import com.laptrinhjava.paging.Pageble;
import com.laptrinhjava.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDao;
	@Inject
	private ICategoryDAO categoryDAO;
	@Inject
	private IStatusDAO statusDAO;

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(newModel.getCategoryCode());
		StatusModel statusModel = statusDAO.findOneByCode(newModel.getStatusCode());
		newModel.setCategoryId(category.getId());
		newModel.setStatusId(statusModel.getId());
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}

	@Override
	public Long saveImg(NewModel newModel) {

		return newDao.save(newModel);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(updateNew.getCategoryCode());
		updateNew.setCategoryId(category.getId());
		StatusModel status = statusDAO.findOneByCode(updateNew.getStatusCode());
		updateNew.setStatusId(status.getId());
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void updateImg(NewModel updateNew) {
		newDao.update(updateNew);
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			// delete before comment
			newDao.delete(id);
		}
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		return newDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDao.getTotalItem();
	}

	@Override
	public NewModel findOne(long id) {
		NewModel newModel = newDao.findOne(id);
		CategoryModel categoryModel = categoryDAO.findOne(newModel.getCategoryId());
		StatusModel statusModel = statusDAO.findOne(newModel.getStatusId());
		newModel.setCategoryCode(categoryModel.getCode());
		newModel.setStatusCode(statusModel.getCode());
		return newModel;
	}

	@Override
	public NewModel findOneImg(long id) {
		return newDao.findOne(id);
	}

	@Override
	public List<NewModel> findAllItem() {
		return newDao.findAllItem();
	}

	@Override
	public void delete(long id) {
		newDao.delete(id);

	}

	@Override
	public List<NewModel> findSearch(String s) {
		return newDao.findSeach(s);
	}

}
