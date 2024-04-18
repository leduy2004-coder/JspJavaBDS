package com.laptrinhjava.dao;

import java.util.List;

import com.laptrinhjava.model.NewModel;
import com.laptrinhjava.paging.Pageble;

public interface INewDAO extends GenericDAO<NewModel> {
	NewModel findOne(Long id);

	List<NewModel> findSeach(String s);

	List<NewModel> findAllItem();

	List<NewModel> findByCategoryId(Long categoryId);

	Long save(NewModel newModel);

	void update(NewModel updateNew);

	void delete(long id);

	List<NewModel> findAll(Pageble pageble);

	int getTotalItem();
}
