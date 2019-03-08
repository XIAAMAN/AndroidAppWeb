package com.xiaaman.listen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


import mysql.AddFriendInfoData;

/**
* @author XIAAMAN
* @version 创建时间：Feb 23, 2019 12:37:07 PM
* 类说明: 
*/
public class Server {
	ServerSocket serverSocket = null;
	public final int port = 9999;

	public Server(){

	        //输出服务器的IP地址
	        try {
	            InetAddress addr = InetAddress.getLocalHost();
	            System.out.println("local host:"+addr);
	            serverSocket = new ServerSocket(port);
	            System.out.println("0k");
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

	public void startService(){

	    try {
	        Socket socket = null;
	        System.out.println("waiting...");
	        //等待连接，每建立一个连接，就新建一个线程
	        while(true){                
	            socket = serverSocket.accept();//等待一个客户端的连接，在连接之前，此方法是阻塞的
	            System.out.println("connect to"+socket.getInetAddress()+":"+socket.getLocalPort());
	            new ConnectThread(socket).start();
	        }

	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        System.out.println("IOException");
	        e.printStackTrace();
	    }
	}

	//向客户端发送信息
	class ConnectThread extends Thread{
	    Socket socket = null;

	    public ConnectThread(Socket socket){    
	        super();
	        this.socket = socket;
	    }

	    @Override
	    public void run(){
	        try {
	        	int i=1;
	        	Boolean status = true;
	            DataInputStream dis = new DataInputStream(socket.getInputStream());
	            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
	            System.out.println(Thread.currentThread().getName());
	            //线程一直连接
	            while(status){
	            	
	                String msgRecv = dis.readUTF();
	                String out;
	                out = new AddFriendInfoData().selectByFriendPhone(msgRecv);
	                System.out.println("msg from client:"+msgRecv);
	                System.out.println("msg from server:"+out);
	                dos.writeUTF(out);
	                dos.flush();
	                System.out.println(i++);
	                status = false;
	                dis.close();
	                dos.close();
	            }
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 

	    }
	}
}
