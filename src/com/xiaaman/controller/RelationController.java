package com.xiaaman.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaaman.domain.Relation;
import com.xiaaman.domain.User;
import com.xiaaman.service.RelationService;
import com.xiaaman.service.UserService;
@Controller
public class RelationController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("relationService")
	private RelationService relationService;
	
	//建立好友关系
	@RequestMapping(value="/buildRelation")
	public void buildFriendRelation(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		String myPhone = req.getParameter("myPhone");
		String friendPhone = req.getParameter("friendPhone");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//获得当前时间日期，精确到时分秒
		String time = dateFormat.format(new Date());
		User myUser = userService.selectByPhone(myPhone);
		User friendUser = userService.selectByPhone(friendPhone);
		friendUser.setPassword("");		//不能将密码传过去
		//建立两条好友关系记录，一条自己的，一条好友的		
		Relation myRelation = new Relation();
		myRelation.setMyId(myUser.getId());
		myRelation.setFriendId(friendUser.getId());
		myRelation.setTime(time);
		
		Relation friendRelation = new Relation();
		friendRelation.setMyId(friendUser.getId());
		friendRelation.setFriendId(myUser.getId());
		friendRelation.setTime(time);
		
		//往数据库中添加数据
		relationService.addRelation(myRelation);
		relationService.addRelation(friendRelation);
		
		//返回结果""表示用户已存在或验证信息无效，"200"表示成功注册
		System.out.println("message : " + "成功建立好友关系");
		rep.getWriter().append(friendUser.toString()).flush();
		rep.getWriter().close();
	}
}
