package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	/**
	 * 商品全件検索.
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Integer pageNumber,Model model) {
		if(pageNumber == null) {
			pageNumber = 1;
		}
		
		List<Item> itemList = itemService.findAll(pageNumber);
		model.addAttribute("itemList", itemList);
		model.addAttribute("pageNumber", pageNumber);
		
		List<Category> parentList = itemService.searchParent();
		model.addAttribute("parentList", parentList);
		
		List<Category> childList = itemService.searchChild();
		model.addAttribute("childList", childList);
		
		List<Category> grandChildList = itemService.searchGrandChild();
		model.addAttribute("grandChildList", grandChildList);
		return "list";
	}
	
	/**
	 * 商品詳細.
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail")
	public String detail(Integer id, Model model) {
		Item item = itemService.load(id);
		model.addAttribute("item", item);
		return "detail";
	}
	
	/**
	 * 商品をカテゴリごとに検索する.
	 * @param nameAll
	 * @param model
	 * @return
	 */
	@RequestMapping("/findName")
	public String findName(Integer pageNumber, String nameAll, Model model) {
		if(pageNumber == null) {
			pageNumber = 1;
		}
		model.addAttribute("pageNumber", pageNumber);
		List<Item> itemNameList = itemService.findName(nameAll, pageNumber);
		model.addAttribute("itemList", itemNameList);
		return "list";
	}

}
