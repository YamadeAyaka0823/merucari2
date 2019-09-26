package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.repository.ItemRepository;

@Service
@Transactional
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	/**
	 * 商品全件検索のサービス.
	 * @return
	 */
	public List<Item> findAll(Integer pageNumber){
		List<Item> itemList = itemRepository.findAll(pageNumber);
		return itemList;
	}
	
	/**
	 * 大カテゴリを検索するリポジトリ.
	 * @return
	 */
	public List<Category> searchParent(){
		List<Category> parentList = itemRepository.searchParent();
		return parentList;
	}

}
