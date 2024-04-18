package com.laptrinhjava.service;

import java.util.List;

import com.laptrinhjava.model.HotNewModel;
import com.laptrinhjava.paging.Pageble;

public interface IHotNewService {
	List<HotNewModel> findByCategoryId(Long categoryId);

	HotNewModel findOne(long id);

	HotNewModel findOneImg(long id);

	List<HotNewModel> findAllItem();

	HotNewModel save(HotNewModel newModel);

	Long saveImg(HotNewModel newModel);

	HotNewModel update(HotNewModel updateNew);

	void updateImg(HotNewModel updateNew);

	void delete(long[] ids);

	void delete(long id);

	List<HotNewModel> findAll(Pageble pageble);

	int getTotalItem();
}
