package com.xiaaman.service;

import com.xiaaman.domain.User;

/** 

* @author 作者 XIAAMAN

* @version 创建时间：Feb 11, 2019 9:22:26 PM 

* 类说明 

*/
public interface UserService {

	//用户通过手机号码和密码登录
	User login(String phone, String password);
	
	String addUser(User user);
	
	User selectByPhone(String phone);
	
	String updatePassword(String password, String phone);
}
