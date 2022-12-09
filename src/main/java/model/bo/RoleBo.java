package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.bean.Role;
import model.dao.RoleDao;

public class RoleBo {
	private RoleDao roleDao;
	
	public RoleBo() {
		this.roleDao = new RoleDao();
	}
	
	public List<Role> getList() throws SQLException {
		return roleDao.getList();
	}
}
