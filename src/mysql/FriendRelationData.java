package mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.xiaaman.domain.User;

public class FriendRelationData extends ConnBean{
private Connection conn=null;
	
	//先通过用户手机号查询到自己的id
	//通过自己的id到relation表中查找所有好友的id
	//根据好友的id到User表中查找该好友的信息
	public List<User> selectFriendsInfoByMyphone(String phone) {
		UserData userData = new UserData();
		int id = userData.selectUserIdByPhone(phone);		//获得用户id
		List<Integer> friendIdList = selectFriendsIdByMyId(id);	//获得所有好友id
		List<User> friendUserList = userData.selectUsersByIdList(friendIdList);		//获得所有好友信息
		return friendUserList;
	}
	
	
	//通过自己的id到relation表中查找所有好友的id
	public List<Integer> selectFriendsIdByMyId (int myId) {
		List<Integer> list = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		//查询语句
		String selectSql = "select friendId from relation where myId =" + myId;
		conn = (Connection) getConnection();
		try {
			pstmt = conn.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
			if(rs != null) {
				while (rs.next()) {
					list.add(rs.getInt("friendId"));
				}				
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return list;		//返回所有好友id
	}
	
	

}
