package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.User;

public class BookDao {
	Connection con = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	//图书管理(查询图书)
	public List<Book> book() {
		List<Book> bookList = new ArrayList<Book>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/test";
			String username = "root";
			String password = "123456";
			con = DriverManager.getConnection(url, username, password);
			
			String selSql = "SELECT * FROM `book`";
			
			stm = con.prepareStatement(selSql);
			rs = stm.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				book.setBid(bid);
				book.setBname(bname);
				bookList.add(book);
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
		return bookList;
	}
	
	
	//图书管理(添加图书)
	public String addBook(String bname) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/test";
			String username = "root";
			String password = "123456";
			con = DriverManager.getConnection(url, username, password);
			
			String insSql = "INSERT INTO book VALUES(NULL,?)";
			
			stm = con.prepareStatement(insSql);
			stm.setString(1, bname);
			int i = stm.executeUpdate();
			if(i > 0) {
				return "添加成功";
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
		return "添加成功";
	}
	
	//图书管理(删除图书)
	public String delBook(String bid) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/test";
			String username = "root";
			String password = "123456";
			con = DriverManager.getConnection(url, username, password);
			
			String delSql = "DELETE FROM book WHERE bid=?";
			
			stm = con.prepareStatement(delSql);
			stm.setString(1, bid);
			int i = stm.executeUpdate();
			if(i > 0) {
				return "删除成功";
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
		return "删除成功";
	}
		
	
	//图书管理(借阅图书)
	public String borrowBook(String bid) {
		List<Book> bookList = new ArrayList<Book>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/test";
			String username = "root";
			String password = "123456";
			con = DriverManager.getConnection(url, username, password);
			
			String selSql = "SELECT * FROM `book` WHERE bid=?";
			
			stm = con.prepareStatement(selSql);
			stm.setString(1, bid);
			rs = stm.executeQuery();
			while(rs.next()) {
				int rBid = rs.getInt("bid");
				String rBname = rs.getString("bname");
				String insSql = "INSERT INTO borrow VALUES(?,?)";
				
				stm = con.prepareStatement(insSql);
				stm.setInt(1, rBid);
				stm.setString(2, rBname);
				int i = stm.executeUpdate();
				if(i > 0) {
					return "借阅成功";
				}
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
		return "借阅成功";
	}
	
	//借阅管理(查询借阅书籍)
	public List<Book> borrow() {
		List<Book> bookList = new ArrayList<Book>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/test";
			String username = "root";
			String password = "123456";
			con = DriverManager.getConnection(url, username, password);
			
			String selSql = "SELECT * FROM `borrow`";
			
			stm = con.prepareStatement(selSql);
			rs = stm.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				int bid = rs.getInt("rBid");
				String bname = rs.getString("rBname");
				book.setBid(bid);
				book.setBname(bname);
				bookList.add(book);
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
		return bookList;
	}
	
	//借阅图书管理(归还图书)
	public String delRbook(String bid) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/test";
			String username = "root";
			String password = "123456";
			con = DriverManager.getConnection(url, username, password);
			
			String delSql = "DELETE FROM borrow WHERE rBid=?";
			
			stm = con.prepareStatement(delSql);
			stm.setString(1, bid);
			int i = stm.executeUpdate();
			if(i > 0) {
				return "删除成功";
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
		return "删除成功";
	}
	
}
