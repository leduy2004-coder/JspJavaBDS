package com.laptrinhjava.dao;

import java.util.List;

import com.laptrinhjava.model.FavoriteModel;
import com.laptrinhjava.model.NewModel;
import com.laptrinhjava.paging.Pageble;

public interface IFavoriteDAO extends GenericDAO<FavoriteModel> {
	FavoriteModel findOne(Long id);

	List<FavoriteModel> findAllItem();

	List<FavoriteModel> findAllByUserId(Long id);

	List<FavoriteModel> findByCategoryId(Long categoryId);

	Long save(FavoriteModel newModel);

	void update(FavoriteModel updateNew);

	void delete(long id);

	void deleteAll();

	List<FavoriteModel> findAll(Pageble pageble);

	int getTotalItem();

	List<NewModel> findAllNone();
}
