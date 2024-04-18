package com.laptrinhjava.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjava.dao.INewDAO;
import com.laptrinhjava.mapper.NewMapper;
import com.laptrinhjava.model.NewModel;
import com.laptrinhjava.paging.Pageble;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryId = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public List<NewModel> findAllItem() {
		String sql = "SELECT * FROM news";
		return query(sql, new NewMapper());
	}

	@Override
	public Long save(NewModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news(title, thumbnail, shortDescription,");
		sql.append("  price, area, content, categoryid, statusid, address, createddate, createdby, video)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getThumbnail(), newModel.getShortDescription(),
				newModel.getPrice(), newModel.getArea(), newModel.getContent(), newModel.getCategoryId(),
				newModel.getStatusId(), newModel.getAddress(), newModel.getCreatedDate(), newModel.getCreatedBy(),
				newModel.getVideo());
	}

	@Override
	public NewModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);

		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?,");
		sql.append(
				" price = ?, area = ?, shortdescription = ?, content = ?, categoryid = ?, statusid = ?,address = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ?, video= ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getPrice(), updateNew.getArea(),
				updateNew.getShortDescription(), updateNew.getContent(), updateNew.getCategoryId(),
				updateNew.getStatusId(), updateNew.getAddress(), updateNew.getCreatedDate(), updateNew.getCreatedBy(),
				updateNew.getModifiedDate(), updateNew.getModifiedBy(), updateNew.getVideo(), updateNew.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
		}
		return query(sql.toString(), new NewMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM news";
		return count(sql);
	}

	@Override
	public List<NewModel> findSeach(String s) {
		String sql = "SELECT * FROM news WHERE title LIKE '%" + s + "%'";
		List<NewModel> list = query(sql, new NewMapper());
		System.out.println(sql);
		return list;
	}
}
