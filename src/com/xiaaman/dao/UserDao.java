package com.xiaaman.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xiaaman.domain.User;

/** 

* @author 作者 XIAAMAN

* @version 创建时间：Feb 11, 2019 9:03:07 PM 

* 类说明 

*/
public interface UserDao {

	//用户登录查询
		@Select("select * from user where phone = #{phone} and password = #{password}")
		User selectByLoginPhoneAndPassword(
				@Param("phone") String phone,
				@Param("password") String password);
		
	//通过电话号码查询该用户是否存在
		@Select("select * from user where phone = #{phone}")
		User selectByPhone(@Param("phone") String phone);
		
	//用户注册
		@Insert("insert into user(name, phone, password, time, "
				+ "image, sex, nickName, email, communityNumber, "
				+ "isOnLine, rank, checkLoginInfo) values(#{name},"
				+ "#{phone},#{password},#{time},#{image},#{sex},#{nickName},"
				+ "#{email},#{communityNumber},#{isOnLine},#{rank},#{checkLoginInfo})")
		void addUser(User user);
		
	//用户修改密码
		@Update("update user set password = #{password} where phone = #{phone}")
		void updatePassword(
				@Param("password") String password, 
				@Param("phone") String phone);
		
		
}
