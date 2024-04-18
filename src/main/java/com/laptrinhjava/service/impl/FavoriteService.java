package com.laptrinhjava.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjava.dao.IFavoriteDAO;
import com.laptrinhjava.model.FavoriteModel;
import com.laptrinhjava.model.NewModel;
import com.laptrinhjava.paging.Pageble;
import com.laptrinhjava.service.IFavoriteService;

public class FavoriteService implements IFavoriteService {

	@Inject
	private IFavoriteDAO favoriteDAO;

	@Override
	public Long save(FavoriteModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		return favoriteDAO.save(newModel);
	}

	@Override
	public FavoriteModel update(FavoriteModel updateNew) {
		FavoriteModel oldNew = favoriteDAO.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		favoriteDAO.update(updateNew);
		return favoriteDAO.findOne(updateNew.getId());
	}

	@Override
	public void updateImg(FavoriteModel updateNew) {
		favoriteDAO.update(updateNew);
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			// delete before comment
			favoriteDAO.delete(id);
		}
	}

	@Override
	public List<FavoriteModel> findAll(Pageble pageble) {
		return favoriteDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return favoriteDAO.getTotalItem();
	}

	@Override
	public FavoriteModel findOne(long id) {
		return favoriteDAO.findOne(id);
	}

	@Override
	public List<FavoriteModel> findAllItem() {
		return favoriteDAO.findAllItem();
	}

	@Override
	public void delete(long id) {
		favoriteDAO.delete(id);
	}

	@Override
	public void deleteAll() {
		favoriteDAO.deleteAll();
	}

	@Override
	public List<FavoriteModel> findAllByUserId(long user_id) {
		return favoriteDAO.findAllByUserId(user_id);
	}

	@Override
	public List<NewModel> findAllNone() {
		return favoriteDAO.findAllNone();
	}

}
