package com.xiaaman.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
* @author XIAAMAN
* @version 创建时间：Feb 21, 2019 4:27:59 PM
* 类说明: 申请添加为好友表
*/
public class AddFriendInfo {
	
	private int id;
	private String myPhone;			//申请人的手机号
	private String friendPhone;		//被申请人的手机号
	private int isSaw;				//该纪录是否已经通知过用户，0代表未通知，1代表通知
	private String time;			//申请时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMyPhone() {
		return myPhone;
	}
	public void setMyPhone(String myPhone) {
		this.myPhone = myPhone;
	}
	public String getFriendPhone() {
		return friendPhone;
	}
	public void setFriendPhone(String friendPhone) {
		this.friendPhone = friendPhone;
	}
	public int getIsSaw() {
		return isSaw;
	}
	public void setIsSaw(int isSaw) {
		this.isSaw = isSaw;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
