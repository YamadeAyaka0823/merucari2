package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

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
		item.setCategoryName(rs.getNString("c_name"));
		return item;
	};
	
	
	/**
	 * 商品全件検索のリポジトリ.
	 * @return
	 */
	public List<Item> findAll(){
		String sql = "SELECT i_id i.id, i_name i.name, i_price i.price, i_shipping i.shipping, i_brand i.brand, i_category i.category, i_condition i.condition, i_description i.description, c_name c.name FROM items i INNER JOIN category c ON i.name = c.name  ORDER BY i.id LIMIT 30 ";
		List<Item> itemList = template.query(sql, ITEM_ROW_MAPPER);
		return itemList;
	}

}
