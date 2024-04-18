package com.laptrinhjava.service;

import java.util.List;

import com.laptrinhjava.model.CommentModel;
import com.laptrinhjava.paging.Pageble;

public interface ICommentService {
	CommentModel findOne(long id);

	List<CommentModel> findAllItem();

	List<CommentModel> findAllNewId(Long id);

	Long save(CommentModel commentModel);

	CommentModel update(CommentModel updateNew);

	void delete(long[] ids);

	void delete(long id);

	List<CommentModel> findAll(Pageble pageble);

	int getTotalItem();
}
