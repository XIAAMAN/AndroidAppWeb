package com.xiaaman.dao;
/**
* @author XIAAMAN
* @version 创建时间：Feb 21, 2019 4:33:56 PM
* 类说明: 
*/

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xiaaman.domain.AddFriendInfo;

public interface AddFriendInfoDao {

	//通过被申请人的手机号查询未看见的申请
	@Select("select * from addFriendInfo where friendPhone = #{friendPhone} and isSaw = 0")
	List<AddFriendInfo> selectByFriendPhone(@Param("friendPhone") String friendPhone);
	
	//将状态设置为已读
	@Update("update addFriendInfo set isSaw = 1 where myPhone = #{myPhone} and friendPhone = {friendPhone} and isSaw = 0")
	void updateState(
			@Param("myPhone") String myPhone,
			@Param("friendPhone") String friendPhone);
	//添加
	@Insert("insert into addFriendInfo(myPhone,friendPhone,isSaw,time) "
			+ "values(#{myPhone},#{friendPhone},#{isSaw},#{time})")
	void add(AddFriendInfo addFriendInfo);
	
}
