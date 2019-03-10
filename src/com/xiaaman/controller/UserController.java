package com.xiaaman.controller;
/** 

* @author 作者 XIAAMAN

* @version 创建时间：Feb 11, 2019 9:30:59 PM 

* 类说明 

*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xiaaman.domain.AddFriendInfo;
import com.xiaaman.domain.CheckCodeLog;
import com.xiaaman.domain.User;
import com.xiaaman.service.AddFriendInfoService;
import com.xiaaman.service.CheckCodeLogService;
import com.xiaaman.service.UserService;


@Controller
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("checkCodeLogService")
	private CheckCodeLogService checkCodeLogService;
	
	@Autowired
	@Qualifier("addFriendInfoService")
	private AddFriendInfoService addFriendInfoService;
	//客户登录
	@RequestMapping(value="/userLogin")
	public void getjson(HttpServletRequest req,HttpServletResponse rep) throws Exception
	     {
			String message="";
	         String phone = req.getParameter("phone");
	         String password = req.getParameter("password");
	         
	         System.out.println("telephone = " + phone + "password = " +password);
	         User user = userService.login(phone, password);
	         if (user != null) {
	        	 //登录成功
		         message =user.toString();
	         }
	         
	         System.out.println("message : " + message);
	         rep.getWriter().append(message).flush();
	         rep.getWriter().close();
	     }
	
	//增加用户
	@RequestMapping(value="/addUser")
	public void addUser(HttpServletRequest req,HttpServletResponse rep) throws IOException {
		String status = "";		//表示状态码，用于判断数据库操作是否成功
		
		String phone = req.getParameter("phone");
		String checkCode = req.getParameter("checkCode");
		User old = userService.selectByPhone(phone);	//检查手机号是否被注册
		CheckCodeLog checkCodeLog = checkCodeLogService.queryByPhone(phone);	//查询数据库中的该手机号收到的验证信息
		if ( checkCodeLog != null) {			//用户发送过验证码
			String oldCode = checkCodeLog.getCheckCode();		//获得数据库中的验证码
			String oldTime = checkCodeLog.getTime();			//获取数据库中的验证码发送时间
			
			//账号未被注册，验证码正确且有效
			if (old == null && checkCode.equals(oldCode) &&calculateCheckCodeTime(oldTime)) {	
				String name = req.getParameter("name");
				String password = req.getParameter("password");
				String email = req.getParameter("email");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//获得当前时间日期，精确到时分秒
				String time = dateFormat.format(new Date());
				User user = new User();
				user.setName(name);
				user.setPhone(phone);
				user.setPassword(password);
				user.setTime(time);
				user.setEmail(email);
				user.setRank(0);	//默认为普通用户
				status = userService.addUser(user);
				
				if (!"200".equals(status)) {		//数据库操作失败
					status = "";
				}
				
			} else {	//
				status = "";
			}
		}
		
		
		//返回结果""表示用户已存在或验证信息无效，"200"表示成功注册
		System.out.println("status : " +status);
		rep.getWriter().append(status).flush();
		rep.getWriter().close();
		
	}
	
	//修改密码
	@RequestMapping(value="/resetPassword")
	public void updatePassword(HttpServletRequest req,HttpServletResponse rep) throws IOException {
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String code = req.getParameter("checkCode");
		User user = userService.selectByPhone(phone);		//查询手机号是否已经注册
		CheckCodeLog checkCodeLog = checkCodeLogService.queryByPhone(phone);	//查询数据库中的该手机号收到的验证信息
		
		String status = "";
		if (checkCodeLog != null) {
			if (user!=null && code.equals(checkCodeLog.getCheckCode()) && calculateCheckCodeTime(checkCodeLog.getTime())) {
				status = userService.updatePassword(password, phone);
			}
		}
		
		System.out.println("status : " + status);
		
		rep.getWriter().append(status).flush();
		rep.getWriter().close();
	}

	
	public boolean calculateCheckCodeTime(String time) {
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//获得当前时间日期，精确到时分秒
			Long oldTime;
			oldTime = dateFormat.parse(time).getTime();
			Long newTime = new Date().getTime();
			Long remainTime = (newTime - oldTime) / 1000;		//转换为秒
			if (remainTime < 120) {			//验证码两分钟内有效
				return true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//将time转换成时间戳
		
		return false;
	}
	
	
	//查找好友
	@RequestMapping(value="/searchFriend")
	public void searchFriendByPhone(HttpServletRequest req,HttpServletResponse rep) throws IOException {
		String phone = req.getParameter("phone");
		User user = userService.selectByPhone(phone);		//查寻该手机号用户		
		String message = "";
		if (user != null) {
			message = user.toString();
		}
		
		System.out.println("message : " + message);
		
		rep.getWriter().append(message).flush();
		rep.getWriter().close();
	}
	
	//添加好友请求,将请求信息添加到数据库
	@RequestMapping(value="/addFriend")
	public void addFriendRequest(HttpServletRequest req,HttpServletResponse rep) throws IOException {
		String myPhone = req.getParameter("myPhone");
		String friendPhone = req.getParameter("friendPhone");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//获得当前时间日期，精确到时分秒
		String time = dateFormat.format(new Date());
		AddFriendInfo addFriendInfo = new AddFriendInfo();
		addFriendInfo.setMyPhone(myPhone);
		addFriendInfo.setFriendPhone(friendPhone);
		addFriendInfo.setIsSaw(0);
		addFriendInfo.setTime(time);
		
		addFriendInfoService.add(addFriendInfo);
		String status = "200";
		rep.getWriter().append(status).flush();
		rep.getWriter().close();
	}
	
}
