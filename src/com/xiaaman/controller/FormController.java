package com.xiaaman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/** 

* @author 作者 XIAAMAN

* @version 创建时间：Feb 11, 2019 6:07:36 PM 

* 类说明 :访问那些没有名字的servlet会在这里进行处理

*/
@Controller
public class FormController {
	@RequestMapping(value="/{formName}")
	 public String loginForm(@PathVariable String formName){
		System.out.println(formName);
		return formName;
	}
}
