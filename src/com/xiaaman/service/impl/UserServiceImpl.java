package com.xiaaman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiaaman.dao.UserDao;
import com.xiaaman.domain.User;
import com.xiaaman.service.UserService;

/** 

* @author 作者 XIAAMAN

* @version 创建时间：Feb 11, 2019 9:25:42 PM 

* 类说明 

*/
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService{

	/**
	 * 自动注入持久层Dao对象
	 * */
	
	@Autowired
	private UserDao userDao;
	@Override
	public User login(String phone, String password) {
		// TODO Auto-generated method stub
		return userDao.selectByLoginPhoneAndPassword(phone, password);
	}
	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
		return "200";
		
	}
	@Override
	public User selectByPhone(String phone) {
		// TODO Auto-generated method stub
		return userDao.selectByPhone(phone);
	}
	@Override
	public String updatePassword(String password, String phone) {
		// TODO Auto-generated method stub
		userDao.updatePassword(password, phone);
		return "200";
	}


}
