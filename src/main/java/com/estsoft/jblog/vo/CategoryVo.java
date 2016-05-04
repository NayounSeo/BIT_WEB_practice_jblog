package com.estsoft.jblog.vo;

public class CategoryVo {
	private long categoryNo;
	private long blogNo;
	private String categoryName;
	private String description;
	private int postCount;
	
	public long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public long getBlogNo() {
		return blogNo;
	}
	public void setBlogNo(long blogNo) {
		this.blogNo = blogNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPostCount() {
		return postCount;
	}
	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	@Override
	public String toString() {
		return "CategoryVo [categoryNo=" + categoryNo + ", blogNo=" + blogNo + ", categoryName=" + categoryName
				+ ", description=" + description + ", postCount=" + postCount + "]";
	}
}
