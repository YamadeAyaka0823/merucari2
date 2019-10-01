package com.example.form;

public class ItemForm {
	/** 大カテゴリの名前 */
	private String nameAllParent;
	/** 中カテゴリの名前 */
	private String nameAllChild;
	/** 小カテゴリの名前 */
	private String nameAllGrandChild;
	
	public String getNameAllParent() {
		return nameAllParent;
	}
	public void setNameAllParent(String nameAllParent) {
		this.nameAllParent = nameAllParent;
	}
	public String getNameAllChild() {
		return nameAllChild;
	}
	public void setNameAllChild(String nameAllChild) {
		this.nameAllChild = nameAllChild;
	}
	public String getNameAllGrandChild() {
		return nameAllGrandChild;
	}
	public void setNameAllGrandChild(String nameAllGrandChild) {
		this.nameAllGrandChild = nameAllGrandChild;
	}
	
	@Override
	public String toString() {
		return "ItemForm [nameAllParent=" + nameAllParent + ", nameAllChild=" + nameAllChild + ", nameAllGrandChild="
				+ nameAllGrandChild + "]";
	}
	
	

}
