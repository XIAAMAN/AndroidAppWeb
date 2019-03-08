package com.xiaaman.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
* @author XIAAMAN
* @version 创建时间：Feb 20, 2019 12:07:00 PM
* 类说明: 这是关系表，所有好友之间的关系都在这张表
*/
public class Relation {
	private int id;
	private int myId;		//把User表中的id作为外键，这是自己的ID
	private int friendId;	//把User表中的id作为外键，这是好友的Id
	private String time;		//成为好友的时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMyId() {
		return myId;
	}
	public void setMyId(int myId) {
		this.myId = myId;
	}
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
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
