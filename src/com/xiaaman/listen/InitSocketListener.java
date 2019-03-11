package com.xiaaman.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
* @author XIAAMAN
* @version 创建时间：Feb 21, 2019 5:45:48 PM
* 类说明: 
*/
public class InitSocketListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//开启监听好友申请
		new Thread(){
			@Override
			public	void run(){
				new RequestFriendServer().startService();
			}
		}.start();
		
		//开启好友关系监听
		new Thread(){
			@Override
			public	void run(){
				new FriendRelationServer().startService();
			}
		}.start();
		
		//开启聊天记录监听
		new Thread(){
			@Override
			public	void run(){
				new ChatMessageServer().startService();
			}
		}.start();
	}
 
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
 
	}
}