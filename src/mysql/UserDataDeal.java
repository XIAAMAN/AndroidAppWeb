package mysql;
/**
* @author XIAAMAN
* @version 创建时间：Feb 23, 2019 11:27:51 AM
* 类说明: 
*/

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
public class UserDataDeal extends ConnBean{
	private Connection conn=null;
	
	public void selectUser() {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		conn = (Connection) getConnection();
		try {
			pstmt = conn.prepareStatement("select * from user where phone = 15870811824");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("phone = " + rs.getString("phone"));
				System.out.println("name = " + rs.getString("name"));
				System.out.println("email = "+ rs.getString("email"));
				
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		
	}

}
