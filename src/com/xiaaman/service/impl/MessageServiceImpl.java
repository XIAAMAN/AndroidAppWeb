package com.xiaaman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiaaman.dao.MessageDao;
import com.xiaaman.domain.Message;
import com.xiaaman.service.MessageService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("messageService")
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageDao messageDao;
	@Override
	public String addMessage(Message message) {
		// TODO Auto-generated method stub
		messageDao.addMessage(message);
		return "200";
	}

}
