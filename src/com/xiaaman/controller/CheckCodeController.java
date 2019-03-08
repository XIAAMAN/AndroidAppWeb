package com.xiaaman.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.xiaaman.domain.CheckCodeLog;
import com.xiaaman.service.CheckCodeLogService;
import com.xiaaman.util.SendCheckCode;
import com.alibaba.fastjson.JSONObject;

/** 

* @author 作者 XIAAMAN

* @version 创建时间：Feb 13, 2019 9:31:17 PM 

* 类说明 

*/
@Controller
public class CheckCodeController {
	
	@Autowired
	@Qualifier("checkCodeLogService")
	private CheckCodeLogService checkCodeLogService;
	
	@RequestMapping(value="/sendCheckCode")
	
	public void getCheckCode(HttpServletRequest req,HttpServletResponse rep) throws IOException {
		
		String telephoneNumber = req.getParameter("telephoneNumber");
		CheckCodeLog checkCodeLog = checkCodeLogService.queryByPhone(telephoneNumber);
		String status="";
		//调用发送验证码的方法
		String message = SendCheckCode.sendCode(telephoneNumber);
		if (!"".equals(message)) {		//短信发送成功
			status = "200";
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//获得当前时间日期，精确到时分秒
			String time = dateFormat.format(new Date());
			if (checkCodeLog != null) {		//该账号已经存在，只要更新验证码和时间
				checkCodeLog.setCheckCode(message);
				checkCodeLog.setTime(time);
				System.out.println(checkCodeLog);
				System.out.println(message);
				checkCodeLogService.updateCheckCodeLog(checkCodeLog);
			} else {	//添加该账号
				CheckCodeLog checkCodeLog2 = new CheckCodeLog();
				checkCodeLog2.setTelephoneNumber(telephoneNumber);
				checkCodeLog2.setCheckCode(message);
				checkCodeLog2.setTime(time);
				System.out.println(checkCodeLog2);
				checkCodeLogService.insertCheckCodeLog(checkCodeLog2);
			}
			
		} else {
			status = "400";
		}
		// 200 表示发送成功，400表示短信发送失败，将结果返回给android端
		System.out.println(telephoneNumber + " : " + status);
		rep.getWriter().append(status).flush();
	}
	
	

}
