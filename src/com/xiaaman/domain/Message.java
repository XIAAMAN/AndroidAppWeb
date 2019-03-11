package com.xiaaman.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
* @author XIAAMAN
* @version 创建时间：Feb 20, 2019 11:45:11 AM
* 类说明: 
*/
public class Message {
	private int id;
	private String time;		//消息发送时间
	private String content;		//消息内容
	private int isSuccess;	//消息是否发送成功，0代表发送失败，1代表发送成功
	private int isSaw;		//是否已读，0代表未读，1代表已读
	//显示消息是否可见，0代表都不可见，发送人在时间范围内撤回或双方都删除
	//1代表发送方可见，2代表接收方可见，3代表都可见
	private int showState;	
	private String sendPhone;		//发送消息人的手机号
	private String receivedPhone;	//接收消息人的手机号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}
	public int getIsSaw() {
		return isSaw;
	}
	public void setIsSaw(int isSaw) {
		this.isSaw = isSaw;
	}
	public int getShowState() {
		return showState;
	}
	public void setShowState(int showState) {
		this.showState = showState;
	}
	
	public String getSendPhone() {
		return sendPhone;
	}
	public void setSendPhone(String sendPhone) {
		this.sendPhone = sendPhone;
	}
	public String getReceivedPhone() {
		return receivedPhone;
	}
	public void setReceivedPhone(String receivedPhone) {
		this.receivedPhone = receivedPhone;
	}
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	
	
	
}
