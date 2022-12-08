package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import model.bean.User;

public class UserDao {
	public PreparedStatement Query(String _sql) throws SQLException {
		PreparedStatement pst = null;
		DBConnect con = new DBConnect();
		String sql = _sql;
		Connection conn = con.connect();
		pst = conn.prepareStatement(sql);

		return pst;
	}
	
	public boolean IsValidUser(String userName, String password) throws Exception {
		PreparedStatement pst = Query("Select id from user where username = ? and password = ?");
		pst.setString(1, userName);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();
		
		return rs.next();
	}
	
	public String Create(User user) throws Exception {
		String id = UUID.randomUUID().toString();

		PreparedStatement pst = Query("Select id from user where username = ?");
		pst.setString(1, user.GetUserName());
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			throw new Exception("UserName already exist!");
		}

		pst = Query("insert into user(id,username,password) values(?,?,?)");
		pst.setString(1, id);
		pst.setString(2, user.GetUserName());
		pst.setString(3, user.GetPassword());

		pst.execute();

		pst = Query("Select id from user where id = ?");
		pst.setString(1, id);
		rs = pst.executeQuery();

		if (rs.next()) {
			String userId = rs.getString(1);
			pst.close();
			return userId;
		} else {
			throw new Exception("Error when execute query!");
		}

	}
	
	public void UpdatePassword(User user, String newPassword) throws Exception {
		PreparedStatement pst = Query("Select id from user where username = ? and password = ?");
		pst.setString(1, user.GetId());
		pst.setString(2, user.GetPassword());
		ResultSet rs = pst.executeQuery();
		
		if(!rs.next()) {
			throw new Exception("Password incorrect!");
		}
		
		pst = Query("Update user set password = ? where username = ?");
		pst.setString(1, newPassword);
		pst.setString(2, user.GetUserName());
		pst.execute();		
		pst.close();
	}
}
