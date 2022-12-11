package model.bean;

import java.sql.Date;
import java.util.List;

public class Information {
	private String Id;
	private String Name;
	private String Title;
	private String Bio;
	private Date Birthday;
	private String Website;
	private String Phone;
	private String Degree;
	private String Email;
	private String Freelance;
	private String Description;
	private String AvatarUrl;
	private String Facebook;
	private String LinkedIn;
	private String Skype;
	private String Instagram;
	private String Address;
	private String UserId;
	private List<Skill> Skills; 

	public Information() {

	}
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getBio() {
		return Bio;
	}

	public void setBio(String bio) {
		Bio = bio;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getDegree() {
		return Degree;
	}

	public void setDegree(String degree) {
		Degree = degree;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFreelance() {
		return Freelance;
	}

	public void setFreelance(String freelance) {
		Freelance = freelance;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getAvatarUrl() {
		return AvatarUrl;
	}

	public void setAvatarUrl(String AvatarUrl) {
		this.AvatarUrl = AvatarUrl;
	}

	public String getFacebook() {
		return Facebook;
	}

	public void setFacebook(String facebook) {
		Facebook = facebook;
	}

	public String getLinkedIn() {
		return LinkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		LinkedIn = linkedIn;
	}

	public String getSkype() {
		return Skype;
	}

	public void setSkype(String skype) {
		Skype = skype;
	}

	public String getInstagram() {
		return Instagram;
	}

	public void setInstagram(String instagram) {
		Instagram = instagram;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}
	
	public List<Skill> getSkills() {
		return Skills;
	}

	public void setSkills(List<Skill> skills) {
		Skills = skills;
	}
}
