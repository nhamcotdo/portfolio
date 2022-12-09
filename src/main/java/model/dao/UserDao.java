package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.bean.Information;
import model.bean.Skill;
import model.bean.User;

public class UserDao {
	private PreparedStatement Query(String _sql) throws SQLException {
		PreparedStatement pst = null;
		DBConnect con = new DBConnect();
		String sql = _sql;
		Connection conn = con.connect();
		pst = conn.prepareStatement(sql);

		return pst;
	}

	public String IsValidUser(String userName, String password) throws Exception {
		PreparedStatement pst = Query("Select id from user where username = ? and password = ?");
		pst.setString(1, userName);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			return rs.getString(1);
		} else {
			return null;
		}
	}

	public String Create(User user) throws Exception {
		String id = UUID.randomUUID().toString();

		PreparedStatement pst = Query("Select id from user where username = ?");
		pst.setString(1, user.getUserName());
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			throw new Exception("UserName already exist!");
		}

		pst = Query("insert into user(id,username,password) values(?,?,?)");
		pst.setString(1, id);
		pst.setString(2, user.getUserName());
		pst.setString(3, user.getPassword());

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

	public User get(String id) throws Exception {
		User user = new User();
		PreparedStatement pst = Query("Select username from user where id = ?");
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			user.setId(id);
			user.setUserName(rs.getString(1));

			pst = Query("Select Id, Name, Title, Bio, Birthday, Website,"
					+ " Phone, Degree, Email, Freelance, Description, AvatarUrl, Facebook,"
					+ " LinkedIn, Skype, Instagram,Address, UserId from information where UserId = ?");
			pst.setString(1, id);
			rs = pst.executeQuery();
			Information information = new Information();
			if (rs.next()) {
				information.setId(rs.getString(1));
				information.setName(rs.getString(2));
				information.setTitle(rs.getString(3));
				information.setBio(rs.getString(4));
				information.setBirthday(rs.getDate(5));
				information.setWebsite(rs.getString(6));
				information.setPhone(rs.getString(7));
				information.setDegree(rs.getString(8));
				information.setEmail(rs.getString(9));
				information.setFreelance(rs.getString(10));
				information.setDescription(rs.getString(11));
				information.setAvatarUrl(rs.getString(12));
				information.setFacebook(rs.getString(13));
				information.setLinkedIn(rs.getString(14));
				information.setSkype(rs.getString(15));
				information.setInstagram(rs.getString(16));
				information.setAddress(rs.getString(17));
				information.setUserId(rs.getString(18));

				pst = Query("select id,name,percent from skill where infoid = ?");
				pst.setString(1, information.getId());
				rs = pst.executeQuery();
				List<Skill> skills = new ArrayList<>();

				while (rs.next()) {
					Skill skill = new Skill();
					skill.setId(rs.getString(1));
					skill.setName(rs.getString(2));
					skill.setPercent(rs.getInt(3));
					skills.add(skill);
				}

				information.setSkills(skills);
			}
			user.setInformation(information);
			return user;
		} else {
			throw new Exception("Id isn't exist");
		}
	}

	public String Role(String userId) throws SQLException {
		PreparedStatement pst = Query("""
				SELECT role.name FROM role
				JOIN user_role
					ON role.id = user_role.roleId
				JOIN user
				  	ON user.id = user_role.userId
				 WHERE
				 	user.id = ?
				""");
		pst.setString(1, userId);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			return rs.getString(1);
		}
		return null;
	}

	public User getByUserName(String userName) throws Exception {
		User user = new User();
		PreparedStatement pst = Query("Select id from user where username = ?");
		pst.setString(1, userName);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			user.setId(rs.getString(1));
			user.setUserName(userName);

			pst = Query("Select Id, Name, Title, Bio, Birthday, Website,"
					+ " Phone, Degree, Email, Freelance, Description, AvatarUrl, Facebook,"
					+ " LinkedIn, Skype, Instagram,Address, UserId from information where UserId = ?");
			pst.setString(1, user.getId());
			rs = pst.executeQuery();
			Information information = new Information();
			if (rs.next()) {
				information.setId(rs.getString(1));
				information.setName(rs.getString(2));
				information.setTitle(rs.getString(3));
				information.setBio(rs.getString(4));
				information.setBirthday(rs.getDate(5));
				information.setWebsite(rs.getString(6));
				information.setPhone(rs.getString(7));
				information.setDegree(rs.getString(8));
				information.setEmail(rs.getString(9));
				information.setFreelance(rs.getString(10));
				information.setDescription(rs.getString(11));
				information.setAvatarUrl(rs.getString(12));
				information.setFacebook(rs.getString(13));
				information.setLinkedIn(rs.getString(14));
				information.setSkype(rs.getString(15));
				information.setInstagram(rs.getString(16));
				information.setAddress(rs.getString(17));
				information.setUserId(rs.getString(18));

				pst = Query("select id,name,percent from skill where infoid = ?");
				pst.setString(1, information.getId());
				rs = pst.executeQuery();
				List<Skill> skills = new ArrayList<>();

				while (rs.next()) {
					Skill skill = new Skill();
					skill.setId(rs.getString(1));
					skill.setName(rs.getString(2));
					skill.setPercent(rs.getInt(3));
					skills.add(skill);
				}

				information.setSkills(skills);
			}
			user.setInformation(information);
			return user;
		} else {
			throw new Exception("UserName isn't exist");
		}
	}

	public List<User> getList() throws SQLException {
		PreparedStatement pst = Query("Select id,username from user");
		ResultSet rs1 = pst.executeQuery();

		List<User> users = new ArrayList<>();

		while (rs1.next()) {

			User user = new User();
			user.setId(rs1.getString(1));
			user.setUserName(rs1.getString(2));

			// Role
			model.bean.Role role = new model.bean.Role();
			pst = Query("""
					SELECT role.id, role.name FROM role
						JOIN user_role
					ON role.id = user_role.roleId
						JOIN user
					 	ON user.id = user_role.userId
					WHERE
						user.id = ?
					""");
			pst.setString(1, user.getId());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				role.setId(rs.getString(1));
				role.setName(rs.getString(2));
				user.setRole(role);
			}

			// Information
			pst = Query("Select Id, Name, Title, Bio, Birthday, Website,"
					+ " Phone, Degree, Email, Freelance, Description, AvatarUrl, Facebook,"
					+ " LinkedIn, Skype, Instagram,Address, UserId from information where UserId = ?");
			pst.setString(1, user.getId());
			rs = pst.executeQuery();
			Information information = new Information();
			if (rs.next()) {
				information.setId(rs.getString(1));
				information.setName(rs.getString(2));
				information.setTitle(rs.getString(3));
				information.setBio(rs.getString(4));
				information.setBirthday(rs.getDate(5));
				information.setWebsite(rs.getString(6));
				information.setPhone(rs.getString(7));
				information.setDegree(rs.getString(8));
				information.setEmail(rs.getString(9));
				information.setFreelance(rs.getString(10));
				information.setDescription(rs.getString(11));
				information.setAvatarUrl(rs.getString(12));
				information.setFacebook(rs.getString(13));
				information.setLinkedIn(rs.getString(14));
				information.setSkype(rs.getString(15));
				information.setInstagram(rs.getString(16));
				information.setAddress(rs.getString(17));
				information.setUserId(rs.getString(18));

				pst = Query("select id,name,percent from skill where infoid = ?");
				pst.setString(1, information.getId());
				rs = pst.executeQuery();
				List<Skill> skills = new ArrayList<>();

				while (rs.next()) {
					Skill skill = new Skill();
					skill.setId(rs.getString(1));
					skill.setName(rs.getString(2));
					skill.setPercent(rs.getInt(3));
					skills.add(skill);
				}

				information.setSkills(skills);
			}
			user.setInformation(information);
			users.add(user);
		}

		return users;
	}
	
	public void updatePassword(String id,String oldPassword, String newPassword) throws Exception {
		PreparedStatement pst = Query("Select id from user where id =? and password = ?");
		pst.setString(1, id);
		pst.setNString(2, oldPassword);
		ResultSet rs = pst.executeQuery();
		if(!rs.next()) {
			throw new Exception("Password incorrect!");
		}
		
		pst = Query("update user set password = ? where id = ?");
		pst.setString(2, id);
		pst.setNString(1, newPassword);
		pst.execute();
	}
}
