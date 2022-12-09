package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.bean.Information;
import model.bean.Skill;

public class InformationDao {
	private PreparedStatement Query(String _sql) throws SQLException {
		PreparedStatement pst = null;
		DBConnect con = new DBConnect();
		String sql = _sql;
		Connection conn = con.connect();
		pst = conn.prepareStatement(sql);

		return pst;
	}

	public String Create(Information information, List<Skill> skills) throws Exception {
		PreparedStatement pst = Query("Select * from user where id = ?");
		pst.setString(1, information.getUserId());
		ResultSet rs = pst.executeQuery();
		if (!rs.next()) {
			throw new Exception("UserId isn't exist!");
		}

		pst = Query("insert into information(Id, Name, Title, Bio, Birthday, Website, Phone, Degree, Email,"
				+ " Freelance, Description, AvatarUrl, Facebook, LinkedIn, Skype, Instagram,Address, UserId)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		String id = UUID.randomUUID().toString();
		pst.setString(1, id);
		pst.setString(2, information.getName());
		pst.setString(3, information.getTitle());
		pst.setString(4, information.getBio());
		pst.setDate(5, information.getBirthday());
		pst.setString(6, information.getWebsite());
		pst.setString(7, information.getPhone());
		pst.setString(8, information.getDegree());
		pst.setString(9, information.getEmail());
		pst.setString(10, information.getFreelance());
		pst.setString(11, information.getDescription());
		pst.setString(12, information.getAvatarUrl());
		pst.setString(13, information.getFacebook());
		pst.setString(14, information.getLinkedIn());
		pst.setString(15, information.getSkype());
		pst.setString(16, information.getInstagram());
		pst.setString(17, information.getAddress());
		pst.setString(18, information.getUserId());

		pst.execute();

		pst = Query("Select id from information where id = ?");
		pst.setString(1, id);
		rs = pst.executeQuery();

		if (rs.next()) {
			String informationId = rs.getString(1);

			for (Skill skill : skills) {
				pst = Query("insert into skill(id,name,percent,infoid) values(?,?,?,?)");
				pst.setString(1, UUID.randomUUID().toString());
				pst.setString(2, skill.getName());
				pst.setInt(3, skill.getPercent());
				pst.setString(4, informationId);

				pst.execute();
			}

			pst.close();
			return informationId;
		} else {
			throw new Exception("Error when execute query!");
		}

	}

	public void Update(String userId, Information information) throws Exception {
		PreparedStatement pst = Query("Select * from user where id = ?");
		pst.setString(1, information.getUserId());
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			throw new Exception("UserId isn't exist!");
		}

		pst = Query("update information set Name = ?, Title = ?,Bio = ?,Birthday = ?,Website = ?,"
				+ "Phone = ?,Degree = ?, Email = ?,Freelance = ?,Description = ?,AvatarUrl = ?,"
				+ "Facebook = ?, LinkedIn = ?,Skype = ?,Instagram = ?,Address = ? where UserId = ?");

		pst.setString(1, information.getName());
		pst.setString(2, information.getTitle());
		pst.setString(3, information.getBio());
		pst.setDate(4, (Date) information.getBirthday());
		pst.setString(5, information.getWebsite());
		pst.setString(6, information.getPhone());
		pst.setString(7, information.getDegree());
		pst.setString(8, information.getEmail());
		pst.setString(9, information.getFreelance());
		pst.setString(10, information.getDescription());
		pst.setString(11, information.getAvatarUrl());
		pst.setString(12, information.getFacebook());
		pst.setString(13, information.getLinkedIn());
		pst.setString(14, information.getSkype());
		pst.setString(15, information.getInstagram());
		pst.setString(16, information.getAddress());
		pst.setString(17,  userId);

		pst.executeUpdate();

		pst = Query("Select id from information where userid = ?");
		pst.setString(1, userId);
		rs = pst.executeQuery();
		if (rs.next()) {
			String informationId = rs.getString(1);
			pst = Query("Delete from skill where infoid = ?");
			pst.setString(1, informationId);
			pst.execute();
			
			for (Skill skill : information.getSkills()) {
				pst = Query("insert into skill(id,name,percent,infoid) values(?,?,?,?)");
				pst.setString(1, UUID.randomUUID().toString());
				pst.setString(2, skill.getName());
				pst.setInt(3, skill.getPercent());
				pst.setString(4, informationId);

				pst.execute();
			}

			pst.close();
		}
	}

	public Information get(String id) throws Exception {
		PreparedStatement pst = Query("Select Id, Name, Title, Bio, Birthday, Website,"
				+ " Phone, Degree, Email, Freelance, Description, AvatarUrl, Facebook,"
				+ " LinkedIn, Skype, Instagram,Address, UserId from information where id = ?");

		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
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

			return information;
		} else {
			throw new Exception("Id isn't exist");
		}
	}

	public List<Information> getList() throws Exception {
		PreparedStatement pst = Query("Select Id, Name, Title, Bio, Birthday, Website,"
				+ " Phone, Degree, Email, Freelance, Description, AvatarUrl, Facebook,"
				+ " LinkedIn, Skype, Instagram, Address, UserId from information");

		ResultSet rs = pst.executeQuery();
		List<Information> informations = new ArrayList<Information>();
		while (rs.next()) {
			Information information = new Information();
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

			informations.add(information);
		}

		return informations;
	}
}
