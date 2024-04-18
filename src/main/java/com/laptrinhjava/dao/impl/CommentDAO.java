package com.laptrinhjava.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjava.dao.ICommentDAO;
import com.laptrinhjava.mapper.CommentMapper;
import com.laptrinhjava.model.CommentModel;
import com.laptrinhjava.paging.Pageble;

public class CommentDAO extends AbstractDAO<CommentModel> implements ICommentDAO {

	@Override
	public List<CommentModel> findAllItem() {
		String sql = "SELECT * FROM comment";
		return query(sql, new CommentMapper());
	}

	@Override
	public List<CommentModel> findAllNewId(Long id) {
		String sql = "SELECT * FROM comment where new_id=?";
		return query(sql, new CommentMapper(), id);
	}

	@Override
	public Long save(CommentModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO comment(content, new_id, user_id, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?)");
		return insert(sql.toString(), newModel.getContent(), newModel.getNew_id(), newModel.getUser_id(),
				newModel.getCreatedDate(), newModel.getCreatedBy());
	}

	@Override
	public CommentModel findOne(Long id) {
		String sql = "SELECT * FROM comment WHERE id = ?";
		List<CommentModel> news = query(sql, new CommentMapper(), id);

		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM comment WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<CommentModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM comment");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
		}
		return query(sql.toString(), new CommentMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM comment";
		return count(sql);
	}
}
