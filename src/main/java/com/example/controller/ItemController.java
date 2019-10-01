package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.form.ItemForm;
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
	public String list(Integer pageNumber,Model model, ItemForm form, String parentName, String childName) {
		if(pageNumber == null) {
			pageNumber = 1;
		}
		
		List<Item> itemList = itemService.findAll(pageNumber, form);
		model.addAttribute("itemList", itemList);
		model.addAttribute("pageNumber", pageNumber);
		
		List<Category> parentList = itemService.searchParent();
		model.addAttribute("parentList", parentList);
		
		List<Category> childList = itemService.searchChild(parentName);
		model.addAttribute("childList", childList);
		
		List<Category> grandChildList = itemService.searchGrandChild(parentName, childName);
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
	public String findName(Integer pageNumber, String nameAll, String brand, Model model) {
		if(pageNumber == null) {
			pageNumber = 1;
		}
		model.addAttribute("pageNumber", pageNumber);
		List<Item> itemNameList = itemService.findName(nameAll, pageNumber);
		model.addAttribute("itemList", itemNameList);
		List<Item> itemBrandList = itemService.findBrand(brand, pageNumber);
		model.addAttribute("itemList", itemBrandList);
		return "list";
	}
	
	/**
	 * 検索ボタンを使って検索する.
	 * @param nameAllParent
	 * @param nameAllChild
	 * @param nameAllGrandChild
	 * @param pageNumber
	 * @param model
	 * @param nameAll
	 * @return
	 */
//	@RequestMapping("/searchItem")
//	public String searchItem(ItemForm form, Integer pageNumber, Model model, String nameAll) {
//		System.out.println(form);
//		if(pageNumber == null) {
//			pageNumber = 1;
//		}
//		model.addAttribute("pageNumber", pageNumber);
//		List<Item> searchItemList = itemService.searchItem(form, pageNumber);
//		model.addAttribute("itemList", searchItemList);
//		return "list";
//	}
	
	/**
	 * 大カテゴリ→中カテゴリのプルダウン.
	 * @param nameAllChild
	 * @return
	 */
	@RequestMapping(value="/pulldown/{parentName}",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String changePulldown(@PathVariable("parentName") String parentName) {
		List<Category> childList = itemService.searchChild(parentName);
		StringBuilder sb = new StringBuilder();
		String str = "";
		sb.append("[");
		
		for(int i=0; i<childList.size(); i++) {
			Category child = childList.get(i);
		   sb.append("{\"");
		   sb.append("itemValue");
		   sb.append("\"");
		   sb.append(":");
		   sb.append("\"");
		   sb.append(child.getNameAll());
		   sb.append("\"");
		   sb.append(",");
		   sb.append("\"");
		   sb.append("itemLabel");
		   sb.append("\"");
		   sb.append(":");
		   sb.append("\"");
		   sb.append(child.getNameAll());
		   sb.append("\"}");
		   sb.append(",");
		}
		
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("]");
		str = sb.toString();
		
		return str;
	}
	
	/**
	 * 中カテゴリ→小カテゴリのプルダウン.
	 * @param parentName
	 * @return
	 */
	@RequestMapping(value="/pulldown2/{parentName}/{childName}",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String changePulldown2(@PathVariable("parentName") String parentName, @PathVariable("childName")String childName) {
		List<Category> grandChildList = itemService.searchGrandChild(parentName, childName);
		StringBuilder sb = new StringBuilder();
		String str = "";
		sb.append("[");
		
		for(int i=0; i<grandChildList.size(); i++) {
			Category grandChild = grandChildList.get(i);
		   sb.append("{\"");
		   sb.append("itemValue");
		   sb.append("\"");
		   sb.append(":");
		   sb.append("\"");
		   sb.append(grandChild.getNameAll());
		   sb.append("\"");
		   sb.append(",");
		   sb.append("\"");
		   sb.append("itemLabel");
		   sb.append("\"");
		   sb.append(":");
		   sb.append("\"");
		   sb.append(grandChild.getNameAll());
		   sb.append("\"}");
		   sb.append(",");
		}
		
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("]");
		str = sb.toString();
		
		return str;
	}

}
