package com.laptrinhjava.service;

import java.util.List;

import com.laptrinhjava.model.FavoriteModel;
import com.laptrinhjava.model.NewModel;
import com.laptrinhjava.paging.Pageble;

public interface IFavoriteService {
	FavoriteModel findOne(long id);

	List<FavoriteModel> findAllItem();

	List<NewModel> findAllNone();

	List<FavoriteModel> findAllByUserId(long user_id);

	Long save(FavoriteModel newModel);

	FavoriteModel update(FavoriteModel updateNew);

	void updateImg(FavoriteModel updateNew);

	void delete(long[] ids);

	void delete(long id);

	void deleteAll();

	List<FavoriteModel> findAll(Pageble pageble);

	int getTotalItem();
}
