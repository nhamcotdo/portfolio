package model.bean;

public class User {
	private String Id;
	private String UserName;
	private String Password;
	private Information information;
	private Role role;

	public User() {

	}

	protected User(String userName, String password) {
		this.UserName = userName;
		this.Password = password;
	}

	public String getUserName() {
		return this.UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getId() {
		return this.Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
