package com.laptrinhjava.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjava.dao.ICategoryDAO;
import com.laptrinhjava.dao.IHotNewDAO;
import com.laptrinhjava.model.CategoryModel;
import com.laptrinhjava.model.HotNewModel;
import com.laptrinhjava.paging.Pageble;
import com.laptrinhjava.service.IHotNewService;

public class HotNewService implements IHotNewService {

	@Inject
	private IHotNewDAO hotNewDAO;
	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<HotNewModel> findByCategoryId(Long categoryId) {
		return hotNewDAO.findByCategoryId(categoryId);
	}

	@Override
	public HotNewModel save(HotNewModel hotNewModel) {
		hotNewModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(hotNewModel.getCategoryCode());
		hotNewModel.setCategoryId(category.getId());
		Long newId = hotNewDAO.save(hotNewModel);
		return hotNewDAO.findOne(newId);
	}

	@Override
	public Long saveImg(HotNewModel hotNewModel) {

		return hotNewDAO.save(hotNewModel);
	}

	@Override
	public HotNewModel update(HotNewModel updateNew) {
		HotNewModel oldNew = hotNewDAO.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(updateNew.getCategoryCode());
		updateNew.setCategoryId(category.getId());
		hotNewDAO.update(updateNew);
		return hotNewDAO.findOne(updateNew.getId());
	}

	@Override
	public void updateImg(HotNewModel updateNew) {
		hotNewDAO.update(updateNew);
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			// delete before comment
			hotNewDAO.delete(id);
		}
	}

	@Override
	public List<HotNewModel> findAll(Pageble pageble) {
		return hotNewDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return hotNewDAO.getTotalItem();
	}

	@Override
	public HotNewModel findOne(long id) {
		HotNewModel hotNewModel = hotNewDAO.findOne(id);
		CategoryModel categoryModel = categoryDAO.findOne(hotNewModel.getCategoryId());
		hotNewModel.setCategoryCode(categoryModel.getCode());
		return hotNewModel;
	}

	@Override
	public HotNewModel findOneImg(long id) {
		return hotNewDAO.findOne(id);
	}

	@Override
	public List<HotNewModel> findAllItem() {
		return hotNewDAO.findAllItem();
	}

	@Override
	public void delete(long id) {
		hotNewDAO.delete(id);

	}

}
