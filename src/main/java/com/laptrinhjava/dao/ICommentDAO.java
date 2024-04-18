package com.laptrinhjava.dao;

import java.util.List;

import com.laptrinhjava.model.CommentModel;
import com.laptrinhjava.paging.Pageble;

public interface ICommentDAO extends GenericDAO<CommentModel> {
	CommentModel findOne(Long id);

	List<CommentModel> findAllItem();

	List<CommentModel> findAllNewId(Long id);

	Long save(CommentModel commentModel);

	void delete(long id);

	List<CommentModel> findAll(Pageble pageble);

	int getTotalItem();
}
