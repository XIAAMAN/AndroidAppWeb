package com.xiaaman.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
* @author XIAAMAN
* @version 创建时间：Feb 21, 2019 5:45:48 PM
* 类说明: 
*/
public class RequestFriendSocketServer implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		new Thread(){
			@Override
			public	void run(){
				new Server().startService();
//				try {
//					// 启用两个Reactor线程池【netty是基于NIO的，基于线程处理的】
//			        // 用于接收Client端连接的
//					EventLoopGroup bossGroup = new NioEventLoopGroup();
//					// 进行网络通信读写
//					EventLoopGroup workGroup = new NioEventLoopGroup();
//					try {
//					    // 创建一个辅助类Bootstrap，就是对我们的Server进行一系列的配置
//						ServerBootstrap b = new ServerBootstrap();
//						b.group(bossGroup, workGroup);
//						// 指定使用NioServerSocketChannel这种类型的通道
//						b.channel(NioServerSocketChannel.class);
//						/*
//						 *  使用 childHandler 去初始化服务器
//						 *  添加handler，用来监听已经连接的客户端的Channel的动作和状态。
//						 *
//						 *  被绑定的MyWebSocketChannelHandler()里面设置了服务端初始化参数以及
//						 *
//						 */
//						b.childHandler(new MyWebSocketChannelHandler());
//
//						System.out.println("服务端开启等待客户端连接....");
//						Channel ch = b.bind(8888).sync().channel();
//						ch.closeFuture().sync();
//						
//					} catch (Exception e) {
//						e.printStackTrace();
//					}finally{
//						//优雅的退出程序
//						bossGroup.shutdownGracefully();
//						workGroup.shutdownGracefully();
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			}
		}.start();
	}
 
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
 
	}
}