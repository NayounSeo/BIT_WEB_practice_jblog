package com.estsoft.jblog.vo;

public class BlogVo {
	private long blogNo;
	private long userNo;
	private String title;
	private String logoImage;
	
	public long getBlogNo() {
		return blogNo;
	}
	public void setBlogNo(long blogNo) {
		this.blogNo = blogNo;
	}
	public long getUserNo() {
		return userNo;
	}
	public void setUserNo(long userNo) {
		this.userNo = userNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogoImage() {
		return logoImage;
	}
	public void setLogoImage(String logoImage) {
		this.logoImage = logoImage;
	}
	@Override
	public String toString() {
		return "BlogVo [blogNo=" + blogNo + ", userNo=" + userNo + ", title=" + title + ", logoImage=" + logoImage
				+ "]";
	}

}
