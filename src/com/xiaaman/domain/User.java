package com.xiaaman.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/** 

* @author 作者 XIAAMAN

* @version 创建时间：Feb 11, 2019 8:21:40 PM 

* 类说明 :用户bean

*/
public class User {

	private int id;
	private String name;
	private String phone;
	private String image;			//头像文件名
	private String nickName;		//昵称
	private String password;		//密码
	private int sex;				//性别,0表示男,1表示女
	private String email;			//邮箱
	private String communityNumber;	//群号
	private int isOnLine;			//是否在线,0表示不在线,1表示在线
	private int rank;				//用户级别,用于判断是普通用户还是群主,0表示普通,1表示群主
	private String checkLoginInfo;	//检查用户是否登录
	private String time;			//用户注册时间
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCommunityNumber() {
		return communityNumber;
	}
	public void setCommunityNumber(String communityNumber) {
		this.communityNumber = communityNumber;
	}
	public int getIsOnLine() {
		return isOnLine;
	}
	public void setIsOnLine(int isOnLine) {
		this.isOnLine = isOnLine;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getCheckLoginInfo() {
		return checkLoginInfo;
	}
	public void setCheckLoginInfo(String checkLoginInfo) {
		this.checkLoginInfo = checkLoginInfo;
	}
	
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	
	 	 	
}
