package com.xiaaman.dao;
/** 

* @author 作者 XIAAMAN

* @version 创建时间：Feb 13, 2019 9:35:31 PM 

* 类说明 :验证码日志数据库操作接口

*/

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xiaaman.domain.CheckCodeLog;

public interface CheckCodeLogDao {

	//查询用户是否存在
	@Select("select * from checkcodelog where telephoneNumber = #{telephoneNumber}")
	CheckCodeLog selectByPhone(
			@Param("telephoneNumber") String telephoneNumber);
	//插入
	@Insert("insert into checkcodelog(telephoneNumber, checkCode, time) values(#{telephoneNumber},#{checkCode},#{time})")
	void addCheckCodeLog(CheckCodeLog checkCodeLog);
	
	//修改最新验证码和时间
	@Update("update checkcodelog set checkCode= #{checkCode} , time = #{time} where telephoneNumber = #{telephoneNumber}")
	void updateCheckCodeLog(CheckCodeLog checkCodeLog);
	
	
}

