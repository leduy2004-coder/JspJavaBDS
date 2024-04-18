package com.laptrinhjava.dao;

import java.util.List;

import com.laptrinhjava.model.HotNewModel;
import com.laptrinhjava.paging.Pageble;

public interface IHotNewDAO extends GenericDAO<HotNewModel> {
	HotNewModel findOne(Long id);

	List<HotNewModel> findAllItem();

	List<HotNewModel> findByCategoryId(Long categoryId);

	Long save(HotNewModel hotNewModel);

	void update(HotNewModel updateNew);

	void delete(long id);

	List<HotNewModel> findAll(Pageble pageble);

	int getTotalItem();
}
