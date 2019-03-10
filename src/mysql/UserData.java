package mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.xiaaman.domain.User;
public class UserData extends ConnBean{
	private Connection conn=null;
	
	//通过手机号查询用户id
	public int selectUserIdByPhone(String phone) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int id = 0;
		//查询语句
		String selectSql = "select id from user where phone =" + phone;
		conn = (Connection) getConnection();
		try {
			pstmt = conn.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
			if(rs != null) {
				rs.next();
				id = rs.getInt("id");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return id;
	}
	
	//通过好友id查询好友信息
	public List<User> selectUsersByIdList(List<Integer> list) {
		List<User> userList = new ArrayList<>();
		User user;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		//查询语句
		String selectSql;
		conn = (Connection) getConnection();
		try {
			for (int i=0; i<list.size(); i++) {
				selectSql = "select * from user where id =" +list.get(i);
				pstmt = conn.prepareStatement(selectSql);
				rs = pstmt.executeQuery();
				rs.next();
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setImage(rs.getString("image"));
				user.setSex(rs.getInt("sex"));
				user.setPhone(rs.getString("phone"));
				user.setNickName(rs.getString("nickName"));
				userList.add(user);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return userList;
	}
	
}
