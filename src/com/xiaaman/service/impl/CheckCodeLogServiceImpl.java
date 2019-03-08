package com.xiaaman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiaaman.dao.CheckCodeLogDao;
import com.xiaaman.domain.CheckCodeLog;
import com.xiaaman.service.CheckCodeLogService;

/** 

* @author 作者 XIAAMAN

* @version 创建时间：Feb 13, 2019 9:57:41 PM 

* 类说明 

*/

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("checkCodeLogService")
public class CheckCodeLogServiceImpl implements CheckCodeLogService{

	
	@Autowired
	private CheckCodeLogDao checkDao;
	@Override
	public CheckCodeLog queryByPhone(String telephoneNumber) {
		// TODO Auto-generated method stub
		return checkDao.selectByPhone(telephoneNumber);
	}

	@Override
	public void insertCheckCodeLog(CheckCodeLog checkCodeLog) {
		// TODO Auto-generated method stub
		checkDao.addCheckCodeLog(checkCodeLog);
		
	}

	@Override
	public void updateCheckCodeLog(CheckCodeLog checkCodeLog) {
		// TODO Auto-generated method stub
		checkDao.updateCheckCodeLog(checkCodeLog);
		
	}

}
