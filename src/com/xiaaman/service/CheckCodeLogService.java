package com.xiaaman.service;

import com.xiaaman.domain.CheckCodeLog;

/** 

* @author 作者 XIAAMAN

* @version 创建时间：Feb 13, 2019 9:53:00 PM 

* 类说明 

*/
public interface CheckCodeLogService {

	CheckCodeLog queryByPhone(String telephoneNumber);
	void insertCheckCodeLog(CheckCodeLog checkCodeLog);
	void updateCheckCodeLog(CheckCodeLog checkCodeLog);
	
}
