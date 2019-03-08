package com.xiaaman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiaaman.dao.AddFriendInfoDao;
import com.xiaaman.dao.UserDao;
import com.xiaaman.domain.AddFriendInfo;
import com.xiaaman.service.AddFriendInfoService;

/**
* @author XIAAMAN
* @version 创建时间：Feb 21, 2019 4:54:18 PM
* 类说明: 
*/
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("addFriendInfoService")
public class AddFriendInfoServiceImpl implements AddFriendInfoService{
	
	@Autowired
	private AddFriendInfoDao addFriendInfoDao;
	@Override
	public List<AddFriendInfo> selectByFriendPhone(String friendPhone) {
		// TODO Auto-generated method stub
		return addFriendInfoDao.selectByFriendPhone(friendPhone);
	}

	@Override
	public void updateState(String myPhone, String friendPhone) {
		// TODO Auto-generated method stub
		addFriendInfoDao.updateState(myPhone, friendPhone);
		
	}

	@Override
	public void add(AddFriendInfo addFriendInfo) {
		// TODO Auto-generated method stub
		addFriendInfoDao.add(addFriendInfo);
	}

}
