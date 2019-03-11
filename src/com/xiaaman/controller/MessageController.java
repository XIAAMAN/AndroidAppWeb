package com.xiaaman.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaaman.domain.Message;
import com.xiaaman.service.MessageService;
@Controller
public class MessageController {

	@Autowired
	@Qualifier("messageService")
	private MessageService messageService;
	
	//保存聊天记录
	@RequestMapping(value="/sendChatMessage")
	public void sendChatMsg(HttpServletRequest req,HttpServletResponse rep) throws Exception {
		Message message = new Message();
		message.setContent(req.getParameter("content"));
		message.setSendPhone(req.getParameter("sendPhone"));
		message.setReceivedPhone(req.getParameter("receivedPhone"));
		message.setTime(req.getParameter("time"));
		message.setIsSaw(0);
		message.setIsSuccess(1);
		message.setShowState(3);
		String status = "";
		status = messageService.addMessage(message);
		System.out.println("chatMessage :"+"聊天记录保存成功");
		rep.getWriter().append(status).flush();
		rep.getWriter().close();
		
	}
}
