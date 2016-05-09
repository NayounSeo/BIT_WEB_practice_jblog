package com.estsoft.jblog.vo;

public class BlogVo {
	private long blogNo;
	private long userNo;
	private String userName;
	private String title;
	private String logoImage;
	
	public BlogVo( BlogUserVo blogUserVo ) {
		this.userNo = blogUserVo.getUserNo( );
		this.userName = blogUserVo.getUserName( );
		this.title = blogUserVo.getUserName( )+"의 블로그입니다.";
		this.logoImage = "/assets/images/spring-logo.jpg";
	}
	
	public BlogVo( ) {
	}
	
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "BlogVo [blogNo=" + blogNo + ", userNo=" + userNo + ", userName=" + userName + ", title=" + title
				+ ", logoImage=" + logoImage + "]";
	}
	
}
