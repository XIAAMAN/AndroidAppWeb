package com.xiaaman.service;
/**
* @author XIAAMAN
* @version 创建时间：Feb 21, 2019 4:47:21 PM
* 类说明: 
*/

import java.util.List;

import com.xiaaman.domain.AddFriendInfo;

public interface AddFriendInfoService {
	
	List<AddFriendInfo> selectByFriendPhone(String friendPhone);
	void updateState(String myPhone, String friendPhone);
	void add(AddFriendInfo addFriendInfo);
}
