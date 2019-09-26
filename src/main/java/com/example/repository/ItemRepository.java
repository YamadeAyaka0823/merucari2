package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Category;
import com.example.domain.Item;

@Repository
public class ItemRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Item> ITEM_ROW_MAPPER = (rs,i) -> {
		Item item = new Item();
		item.setId(rs.getInt("i_id"));
		item.setName(rs.getString("i_name"));
		item.setPrice(rs.getDouble("i_price"));
		item.setShipping(rs.getInt("i_shipping"));
		item.setBrand(rs.getString("i_brand"));
		item.setCategory(rs.getInt("i_category"));
		item.setCondition(rs.getInt("i_condition"));
		item.setDescription(rs.getString("i_description"));
		item.setNameAll(rs.getString("c_name_all"));
		return item;
	};
	
	private static final RowMapper<Category> CATEGORY_ROW_MAPPER = (rs,i) -> {
		Category category = new Category();
//		category.setId(rs.getInt("id"));
//		category.setName(rs.getString("name"));
		category.setNameAll(rs.getString("split_part"));
//		category.setParent(rs.getInt("parent"));
		return category;
	};
	
	
	/**
	 * 商品全件検索のリポジトリ.
	 * @return
	 */
	public List<Item> findAll(Integer pageNumber){
		int offset = (pageNumber - 1) * 30;
		String sql = "SELECT i.id i_id, i.name i_name, i.price i_price, i.shipping i_shipping, i.brand i_brand, i.category i_category, i.condition i_condition, i.description i_description, c.name_all c_name_all FROM items i LEFT OUTER JOIN category c ON i.category = c.id  ORDER BY i.id LIMIT 30 OFFSET " + offset;
		List<Item> itemList = template.query(sql, ITEM_ROW_MAPPER);
		return itemList;
	}
	
	/**
	 * 商品詳細を1件検索するリポジトリ.
	 * @param id
	 * @return
	 */
	public Item load(Integer id) {
		String sql = "SELECT id, name, price, shipping, brand, category, condition, description FROM items WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Item item = template.queryForObject(sql, param, ITEM_ROW_MAPPER);
		return item;
	}
	
	/**
	 * 大カテゴリを検索するリポジトリ.
	 * @return
	 */
	public List<Category> searchParent(){
		String sql = "SELECT DISTINCT SPLIT_PART(name_all, '/', 1) FROM category WHERE name_all IS NOT NULL";
		List<Category> parentList = template.query(sql, CATEGORY_ROW_MAPPER);
		return parentList;
	}
	
	/**
	 * 中カテゴリを検索するリポジトリ.
	 * @return
	 */
	public List<Category> searchChild(){
		String sql = "SELECT DISTINCT SPLIT_PART(name_all, '/', 2) FROM category WHERE name_all IS NOT NULL";
		List<Category> parentList = template.query(sql, CATEGORY_ROW_MAPPER);
		return parentList;
	}
	
	/**
	 * 小カテゴリを検索するリポジトリ.
	 * @return
	 */
	public List<Category> searchGrandChild(){
		String sql = "SELECT DISTINCT SPLIT_PART(name_all, '/', 3) FROM category WHERE name_all IS NOT NULL";
		List<Category> parentList = template.query(sql, CATEGORY_ROW_MAPPER);
		return parentList;
	}
	
	

}
