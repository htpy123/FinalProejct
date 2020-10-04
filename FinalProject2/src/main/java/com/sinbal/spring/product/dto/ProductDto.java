package com.sinbal.spring.product.dto;

public class ProductDto {
	private int num;
	private String productname;
	private String kind;
	private String content;
	private float price;
	private String regdate;
	private String profile;
	private String profile2;
	private int startRowNum;
	private int endRowNum;
	private String search;
	private String arr;
	private String kindSelect;
	
	//디폴트 생성자 
	public ProductDto() {}

	public ProductDto(int num, String productname, String kind, String content, float price, String regdate,
			String profile, String profile2, int startRowNum, int endRowNum, String search, String arr,
			String kindSelect) {
		super();
		this.num = num;
		this.productname = productname;
		this.kind = kind;
		this.content = content;
		this.price = price;
		this.regdate = regdate;
		this.profile = profile;
		this.profile2 = profile2;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.search = search;
		this.arr = arr;
		this.kindSelect = kindSelect;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getProfile2() {
		return profile2;
	}

	public void setProfile2(String profile2) {
		this.profile2 = profile2;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getArr() {
		return arr;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}

	public String getKindSelect() {
		return kindSelect;
	}

	public void setKindSelect(String kindSelect) {
		this.kindSelect = kindSelect;
	}

	
	
}
