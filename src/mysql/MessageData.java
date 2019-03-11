package mysql;
/**   
* @Author：XIAAMAN   
* @Date：11 Mar 2019 16:51:52 
* 类描述：         
*/
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.xiaaman.domain.Message;
import com.xiaaman.domain.User;
public class MessageData extends ConnBean{
	private Connection conn=null;
	
	//通过手机号查询接收的聊天信息,查询后修改信息状态为已经查看
	public String selectMessageByPhone(String phone) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Message> messageList = new ArrayList<>();
		Message message;
		String result = "";
		int id = 0;
		//查询语句
		String selectSql = "select * from message where receivedPhone =" + phone +" and isSaw =0";
		String updateSql = "update message set isSaw = 1 where receivedPhone = " + phone;
		conn = (Connection) getConnection();
		try {
			pstmt = conn.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
			if(rs != null) {
				while (rs.next()) {
					message = new Message();
					message.setContent(rs.getString("content"));
					message.setTime(rs.getString("time"));
					message.setSendPhone(rs.getString("sendPhone"));
					message.setReceivedPhone(rs.getString("receivedPhone"));
					message.setIsSaw(rs.getInt("isSaw"));
					message.setIsSuccess(rs.getInt("isSuccess"));
					message.setShowState(rs.getInt("showState"));
					messageList.add(message);
				}
				result = messageList.toString();
			}
			
			pstmt.close();
			rs.close();
			pstmt = conn.prepareStatement(updateSql);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return result;
	}
	
}
