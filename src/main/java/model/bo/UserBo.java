package model.bo;

import model.dao.UserDao;

public class UserBo {
	public boolean Login(String userName, String password) throws Exception
	{
		return (new UserDao()).IsValidUser(userName, password);
	}
}
