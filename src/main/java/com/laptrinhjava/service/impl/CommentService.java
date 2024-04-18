package com.laptrinhjava.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjava.dao.ICommentDAO;
import com.laptrinhjava.model.CommentModel;
import com.laptrinhjava.paging.Pageble;
import com.laptrinhjava.service.ICommentService;

public class CommentService implements ICommentService {

	@Inject
	private ICommentDAO newDao;

	@Override
	public Long save(CommentModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		return newDao.save(newModel);

	}

	@Override
	public CommentModel update(CommentModel updateNew) {
		CommentModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			// delete before comment
			newDao.delete(id);
		}
	}

	@Override
	public List<CommentModel> findAll(Pageble pageble) {
		return newDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDao.getTotalItem();
	}

	@Override
	public CommentModel findOne(long id) {
		return newDao.findOne(id);
	}

	@Override
	public List<CommentModel> findAllItem() {
		return newDao.findAllItem();
	}

	@Override
	public List<CommentModel> findAllNewId(Long id) {
		return newDao.findAllNewId(id);
	}

	@Override
	public void delete(long id) {
		newDao.delete(id);

	}

}
