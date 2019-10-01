package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.form.ItemForm;
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
	public List<Item> findAll(Integer pageNumber, ItemForm form){
		List<Item> itemList = itemRepository.findAll(pageNumber, form.getNameAllParent(), form.getNameAllChild(), form.getNameAllGrandChild());
		return itemList;
	}
	
	/**
	 * 商品詳細を1件検索するサービス.
	 * @param id
	 * @return
	 */
	public Item load(Integer id) {
		Item item = itemRepository.load(id);
		return item;
	}
	
	/**
	 * 商品をカテゴリごとに検索するサービス.
	 * @param nameAll
	 * @return
	 */
	public List<Item> findName(String nameAll, Integer pageNumber){
		List<Item> itemNameList = itemRepository.findName(nameAll, pageNumber);
		return itemNameList;
	}
	
	/**
	 * 検索ボタンを押して検索するサービス.
	 * @param form
	 * @param pageNumber
	 * @return
	 */
//	public List<Item> searchItem(ItemForm form, Integer pageNumber){
//		List<Item> searchItemList = itemRepository.searchItem(form.getNameAllParent(), form.getNameAllChild(), form.getNameAllGrandChild(), pageNumber);
//		return searchItemList;
//	}
	
	/**
	 * ブランドごとに検索するサービス.
	 * @param brand
	 * @param pageNumber
	 * @return
	 */
	public List<Item> findBrand(String brand, Integer pageNumber){
		List<Item> itemBrandList = itemRepository.findBrand(brand, pageNumber);
		return itemBrandList;
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
	public List<Category> searchChild(String parentName){
		List<Category> childList = itemRepository.searchChild(parentName);
		return childList;
	}
	
	/**
	 * 小カテゴリを検索するサービス.
	 * @return
	 */
	public List<Category> searchGrandChild(String parentName, String childName){
		List<Category> grandChildList = itemRepository.searchGrandChild(parentName, childName);
		return grandChildList;
	}

}
