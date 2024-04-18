package com.laptrinhjava.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjava.dao.IHotNewDAO;
import com.laptrinhjava.mapper.HotNewMapper;
import com.laptrinhjava.model.HotNewModel;
import com.laptrinhjava.paging.Pageble;

public class HotNewDAO extends AbstractDAO<HotNewModel> implements IHotNewDAO {

	@Override
	public List<HotNewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM hotnews WHERE categoryId = ?";
		return query(sql, new HotNewMapper(), categoryId);
	}

	@Override
	public List<HotNewModel> findAllItem() {
		String sql = "SELECT * FROM hotnews";
		return query(sql, new HotNewMapper());
	}

	@Override
	public Long save(HotNewModel hotNewModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO hotnews(title, thumbnail, shortDescription,");
		sql.append(" content, categoryid, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), hotNewModel.getTitle(), hotNewModel.getThumbnail(),
				hotNewModel.getShortDescription(), hotNewModel.getContent(), hotNewModel.getCategoryId(),
				hotNewModel.getCreatedDate(), hotNewModel.getCreatedBy());
	}

	@Override
	public HotNewModel findOne(Long id) {
		String sql = "SELECT * FROM hotnews WHERE id = ?";
		List<HotNewModel> news = query(sql, new HotNewMapper(), id);

		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(HotNewModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE hotnews SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
				updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), updateNew.getCreatedBy(),
				updateNew.getModifiedDate(), updateNew.getModifiedBy(), updateNew.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM hotnews WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<HotNewModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM hotnews");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
		}
		return query(sql.toString(), new HotNewMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM hotnews";
		return count(sql);
	}
}
