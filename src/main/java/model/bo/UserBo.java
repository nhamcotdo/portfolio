package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.bean.Information;
import model.bean.Skill;
import model.bean.User;
import model.dao.InformationDao;
import model.dao.UserDao;

public class UserBo {

	private UserDao userDao;
	private InformationDao informationDao;

	public UserBo() {
		this.userDao = new UserDao();
		this.informationDao = new InformationDao();
	}

	public String Login(String userName, String password) throws Exception {
		return userDao.IsValidUser(userName, password);
	}

	public String Register(User user, Information information, List<Skill> skills) throws Exception {
		String userId = userDao.Create(user);
		information.setUserId(userId);
		informationDao.Create(information, skills);
		
		return userId;
	}
	
	public User getUserById(String Id) throws Exception {
		return userDao.get(Id);
	}
	
	public User getUserByUserName(String userName) throws Exception {
		return userDao.getByUserName(userName);
	}
	
	public String role(String userId) throws SQLException {
		return userDao.Role(userId);
	}
	
	public List<User> getList() throws SQLException {
		return userDao.getList();
	}
	
	public void updatePassword(String id,String oldPassword, String newPassword) throws Exception
	{
		userDao.updatePassword(id, oldPassword, newPassword);
	}
}
