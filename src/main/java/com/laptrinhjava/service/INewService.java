package com.laptrinhjava.service;

import java.util.List;

import com.laptrinhjava.model.NewModel;
import com.laptrinhjava.paging.Pageble;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);

	NewModel findOne(long id);

	NewModel findOneImg(long id);

	List<NewModel> findSearch(String s);

	List<NewModel> findAllItem();

	NewModel save(NewModel newModel);

	Long saveImg(NewModel newModel);

	NewModel update(NewModel updateNew);

	void updateImg(NewModel updateNew);

	void delete(long[] ids);

	void delete(long id);

	List<NewModel> findAll(Pageble pageble);

	int getTotalItem();
}
