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
		return "list";
	}

}
