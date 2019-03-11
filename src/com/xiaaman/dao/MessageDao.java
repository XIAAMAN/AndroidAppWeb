package com.xiaaman.dao;

import org.apache.ibatis.annotations.Insert;

import com.xiaaman.domain.Message;

public interface MessageDao {
	//添加聊天记录
	@Insert("insert into message(content, sendPhone, receivedPhone, time,"
			+ "isSaw, isSuccess, showState) values(#{content},#{sendPhone},"
			+ "#{receivedPhone},#{time},#{isSaw},#{isSuccess},#{showState})")
	void addMessage(Message message);
}
