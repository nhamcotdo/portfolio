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

public class InformationDao {
	public PreparedStatement Query(String _sql) throws SQLException {
		PreparedStatement pst = null;
		DBConnect con = new DBConnect();
		String sql = _sql;
		Connection conn = con.connect();
		pst = conn.prepareStatement(sql);

		return pst;
	}

	public String Create(Information information) throws Exception {
		PreparedStatement pst = Query("Select * from user where id = ?");
		pst.setString(1, information.GetUserId());
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			throw new Exception("UserId isn't exist!");
		}

		pst = Query("insert into information(Id, Name, Tilte, Bio, Birthday, Website, Phone, Degree, Email,"
				+ " Freelance, Description, AvartarUrl, Facebook, LinkedIn, Skype, Instagram,Address, UserId)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		String id = UUID.randomUUID().toString();
		pst.setString(1, id);
		pst.setString(2, information.GetName());
		pst.setString(3, information.GetTitle());
		pst.setString(4, information.GetBio());
		pst.setDate(5, (Date) information.GetBirthday());
		pst.setString(6, information.GetWebsite());
		pst.setString(7, information.GetPhone());
		pst.setString(8, information.GetDegree());
		pst.setString(9, information.GetEmail());
		pst.setString(10, information.GetFreelance());
		pst.setString(11, information.GetDescription());
		pst.setString(12, information.GetAvartarUrl());
		pst.setString(13, information.GetFacebook());
		pst.setString(14, information.GetLinkedIn());
		pst.setString(15, information.GetSkype());
		pst.setString(16, information.GetInstagram());
		pst.setString(17, information.GetAddress());
		pst.setString(18, information.GetUserId());

		pst.execute();

		pst = Query("Select id from information where id = ?");
		pst.setString(1, id);
		rs = pst.executeQuery();

		if (rs.next()) {
			String informationId = rs.getString(1);
			pst.close();
			return informationId;
		} else {
			throw new Exception("Error when execute query!");
		}

	}

	public void Update(String userId, Information information) throws Exception {
		PreparedStatement pst = Query("Select * from user where id = ?");
		pst.setString(1, information.GetUserId());
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			throw new Exception("UserId isn't exist!");
		}

		pst = Query("update information set Name = ?, Tilte = ?,Bio = ?,Birthday = ?,Website = ?,"
				+ "Phone = ?,Degree = ?, Email = ?,Freelance = ?,Description = ?,AvartarUrl = ?,"
				+ "Facebook = ?, LinkedIn = ?,Skype = ?,Instagram = ?,Address = ? where UserId = ?");

		pst.setString(1, information.GetName());
		pst.setString(2, information.GetTitle());
		pst.setString(3, information.GetBio());
		pst.setDate(4, (Date) information.GetBirthday());
		pst.setString(5, information.GetWebsite());
		pst.setString(6, information.GetPhone());
		pst.setString(7, information.GetDegree());
		pst.setString(8, information.GetEmail());
		pst.setString(9, information.GetFreelance());
		pst.setString(10, information.GetDescription());
		pst.setString(11, information.GetAvartarUrl());
		pst.setString(12, information.GetFacebook());
		pst.setString(13, information.GetLinkedIn());
		pst.setString(14, information.GetSkype());
		pst.setString(15, information.GetInstagram());
		pst.setString(16, information.GetAddress());
		pst.setString(17, information.GetUserId());

		pst.executeUpdate();
	}

	public Information get(String id) throws Exception {
		PreparedStatement pst = Query("Select Id, Name, Tilte, Bio, Birthday, Website,"
				+ " Phone, Degree, Email, Freelance, Description, AvartarUrl, Facebook,"
				+ " LinkedIn, Skype, Instagram,Address, UserId from information where id = ?");

		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		Information information = new Information();
		if (rs.next()) {
			information.SetId(rs.getString(1));
			information.SetName(rs.getString(2));
			information.SetTitle(rs.getString(3));
			information.SetBio(rs.getString(4));
			information.SetBirthday(rs.getDate(5));
			information.SetWebsite(rs.getString(6));
			information.SetPhone(rs.getString(7));
			information.SetDegree(rs.getString(8));
			information.SetEmail(rs.getString(9));
			information.SetFreelance(rs.getString(10));
			information.SetDescription(rs.getString(11));
			information.SetAvartarUrl(rs.getString(12));
			information.SetFacebook(rs.getString(13));
			information.SetLinkedIn(rs.getString(14));
			information.SetSkype(rs.getString(15));
			information.SetInstagram(rs.getString(16));
			information.SetAddress(rs.getString(17));
			information.SetUserId(rs.getString(18));

			return information;
		} else {
			throw new Exception("Id isn't exist");
		}
	}

	public List<Information> getList() throws Exception {
		PreparedStatement pst = Query("Select Id, Name, Tilte, Bio, Birthday, Website,"
				+ " Phone, Degree, Email, Freelance, Description, AvartarUrl, Facebook,"
				+ " LinkedIn, Skype, Instagram, Address, UserId from information");

		ResultSet rs = pst.executeQuery();
		List<Information> informations = new ArrayList<Information>();
		while (rs.next()) {
			Information information = new Information();
			information.SetId(rs.getString(1));
			information.SetName(rs.getString(2));
			information.SetTitle(rs.getString(3));
			information.SetBio(rs.getString(4));
			information.SetBirthday(rs.getDate(5));
			information.SetWebsite(rs.getString(6));
			information.SetPhone(rs.getString(7));
			information.SetDegree(rs.getString(8));
			information.SetEmail(rs.getString(9));
			information.SetFreelance(rs.getString(10));
			information.SetDescription(rs.getString(11));
			information.SetAvartarUrl(rs.getString(12));
			information.SetFacebook(rs.getString(13));
			information.SetLinkedIn(rs.getString(14));
			information.SetSkype(rs.getString(15));
			information.SetInstagram(rs.getString(16));
			information.SetAddress(rs.getString(17));
			information.SetUserId(rs.getString(18));

			informations.add(information);
		}

		return informations;
	}
}
