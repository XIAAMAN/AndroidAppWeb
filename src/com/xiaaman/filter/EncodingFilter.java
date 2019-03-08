package com.xiaaman.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/** 

* @author 作者 XIAAMAN

* @version 创建时间：Feb 11, 2019 5:22:14 PM 

* 类说明 :编码过滤类，将编码格式设置为UTF-8，防止出现中文乱码的情况

*/

@WebFilter(filterName="encodingFilter",urlPatterns="/*")
public class EncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

}