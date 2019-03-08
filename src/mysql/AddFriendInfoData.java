package mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.xiaaman.domain.AddFriendInfo;
/**
* @author XIAAMAN
* @version 创建时间：Feb 23, 2019 1:06:49 PM
* 类说明: 
*/
public class AddFriendInfoData extends ConnBean{
private Connection conn=null;
	
	//通过被申请人的手机号，查询有哪些人申请为好友，并返回所有未读申请人的手机号，修改返回信息记录的状态
	public String selectByFriendPhone(String friendPhone) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String message = "";
		//查询语句
		String selectSql = "select * from addFriendInfo where friendPhone = "+friendPhone+" and isSaw = 0";  
		//将返回的记录isSaw改为1，设置为已读
		String updateSql = "update addFriendInfo set isSaw = 1 where isSaw = 0 and friendPhone = "+friendPhone;
		ArrayList<AddFriendInfo> friendList = new ArrayList<>();
		conn = (Connection) getConnection();
		try {
			
			//查询，并将查询到的信息返回给客户端，在客户端进行数据存储
			pstmt = conn.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					AddFriendInfo friendInfo = new AddFriendInfo();
					friendInfo.setMyPhone(rs.getString("myPhone"));
					friendInfo.setFriendPhone(rs.getString("friendPhone"));
					friendInfo.setIsSaw(rs.getInt("isSaw"));
					friendInfo.setTime(rs.getString("time"));
					friendList.add(friendInfo);				
				}
				
				message = friendList.toString();		//转化为json字符串格式
				pstmt.close();
				rs.close();
				
				//修改查到的申请信息，将记录设置为已读
				pstmt = conn.prepareStatement(updateSql);
				int number = pstmt.executeUpdate();		//修改记录条数
				System.out.println("number = "+ number);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		System.out.println(friendList.toString());
		return message;		//如果查询到更新信息则返回信息，如果没有更新，则返回""
	}
	
	

}
