package com.xiaaman.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/** 

* @author 作者 XIAAMAN

* @version 创建时间：Feb 13, 2019 9:27:43 PM 

* 类说明 

*/
public class CheckCodeLog {
	private String telephoneNumber;		//电话号码，为主键
	private String checkCode;			//最新一次验证码
	private String time;				//最新一次验证码发送时间
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
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
