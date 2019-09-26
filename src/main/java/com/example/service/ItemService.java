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
	 * 大カテゴリを検索するサービス.
	 * @return
	 */
	public List<Category> searchParent(){
		List<Category> parentList = itemRepository.searchParent();
		return parentList;
	}
	
	/**
	 * 中カテゴリを検索するサービス.
	 * @return
	 */
	public List<Category> searchChild(){
		List<Category> childList = itemRepository.searchChild();
		return childList;
	}
	
	/**
	 * 小カテゴリを検索するサービス.
	 * @return
	 */
	public List<Category> searchGrandChild(){
		List<Category> grandChildList = itemRepository.searchGrandChild();
		return grandChildList;
	}

}
