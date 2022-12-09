package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Role;

public class RoleDao {
	private PreparedStatement Query(String _sql) throws SQLException {
		PreparedStatement pst = null;
		DBConnect con = new DBConnect();
		String sql = _sql;
		Connection conn = con.connect();
		pst = conn.prepareStatement(sql);

		return pst;
	}
	
	public List<Role> getList() throws SQLException {
		PreparedStatement pst = Query("select id, name from role");
		ResultSet rs = pst.executeQuery();
		
		List<Role> roles = new ArrayList<>();
		
		while(rs.next()) {
			Role role = new Role();
			role.setId(rs.getString(1));
			role.setName(rs.getString(2));
			roles.add(role);
		};
		
		return roles;
	}
}
