package com.xiaaman.dao;

import org.apache.ibatis.annotations.Insert;

import com.xiaaman.domain.Relation;

public interface RelationDao {
	//添加好友关系表
	@Insert("insert into relation(myId, friendId, time) values(#{myId}, #{friendId}, #{time})")
	void addRelation(Relation relation);

}
