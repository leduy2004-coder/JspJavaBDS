package com.laptrinhjava.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjava.dao.IFavoriteDAO;
import com.laptrinhjava.mapper.FavoriteMapper;
import com.laptrinhjava.mapper.NewMapper;
import com.laptrinhjava.model.FavoriteModel;
import com.laptrinhjava.model.NewModel;
import com.laptrinhjava.paging.Pageble;

public class FavoriteDAO extends AbstractDAO<FavoriteModel> implements IFavoriteDAO {

	@Override
	public List<FavoriteModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM favorite WHERE categoryId = ?";
		return query(sql, new FavoriteMapper(), categoryId);
	}

	@Override
	public List<FavoriteModel> findAllItem() {
		String sql = "SELECT * FROM favorite";
		return query(sql, new FavoriteMapper());
	}

	@Override
	public List<NewModel> findAllNone() {
		String sql = "SELECT * FROM news WHERE id NOT IN (SELECT new_id FROM favorite)";
		return query(sql, new NewMapper());
	}

	@Override
	public Long save(FavoriteModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO favorite(title, thumbnail,");
		sql.append("  price, user_id, new_id, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getThumbnail(), newModel.getPrice(),
				newModel.getUser_id(), newModel.getNew_id(), newModel.getCreatedDate(), newModel.getCreatedBy());
	}

	@Override
	public FavoriteModel findOne(Long id) {
		String sql = "SELECT * FROM favorite WHERE id = ?";
		List<FavoriteModel> news = query(sql, new FavoriteMapper(), id);

		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(FavoriteModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE favorite SET title = ?, thumbnail = ?,");
		sql.append(" price = ?, user_id = ?,new_id = ?");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getPrice(),
				updateNew.getUser_id(), updateNew.getNew_id(), updateNew.getCreatedDate(), updateNew.getCreatedBy(),
				updateNew.getModifiedDate(), updateNew.getModifiedBy(), updateNew.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM favorite WHERE id = ?";
		update(sql, id);
	}

	@Override
	public void deleteAll() {
		String sql = "DELETE FROM favorite";
		update(sql);
	}

	@Override
	public List<FavoriteModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM favorite");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
		}
		return query(sql.toString(), new FavoriteMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM favorite";
		return count(sql);
	}

	@Override
	public List<FavoriteModel> findAllByUserId(Long user_id) {
		String sql = "SELECT * FROM favorite WHERE user_id = ?";
		return query(sql, new FavoriteMapper(), user_id);
	}
}
