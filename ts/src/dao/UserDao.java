package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDao {
	Connection con = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	//µ«¬º
	public User logon(String uphone,String pwd) {
		User user = new User();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/test";
			String username = "root";
			String password = "123456";
			con = DriverManager.getConnection(url, username, password);
			
			String selsql = "SELECT * FROM `user` WHERE uphone = ? and upassword = ?";
			
			stm = con.prepareStatement(selsql);
			stm.setString(1, uphone);
			stm.setString(2, pwd);
			rs = stm.executeQuery();
			while(rs.next()) {
				int uid = rs.getInt("uid");
				String uname = rs.getString("uname");
				String uphones = rs.getString("uphone");
				String upassword = rs.getString("upassword");
				user.setUid(uid);
				user.setUname(uname);
				user.setUpassword(upassword);
				user.setUphone(uphones);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return user;
	}

	//◊¢≤·
	public void login(String username,String phone,String password1) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/test";
			String user = "root";
			String password = "123456";
			con = DriverManager.getConnection(url, user, password);
			
			String inssql = "INSERT INTO `user` VALUES(NULL,?,?,?)";
			stm = con.prepareStatement(inssql);
			stm.setString(1, username);
			stm.setString(2, phone);
			stm.setString(3, password1);
			int i = stm.executeUpdate();
			if(i > 0) {
				System.out.println("÷¥––ÃÌº””Ôæ‰≥…π¶");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
