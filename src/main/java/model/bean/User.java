package model.bean;

public class User {
	private String Id;
	private String UserName;
	private String Password;

	public User() {

	}

	protected User(String userName, String password) {
		this.UserName = userName;
		this.Password = password;
	}

	public String GetUserName() {
		return this.UserName;
	}

	public void SetUserName(String userName) {
		this.UserName = userName;
	}

	public String GetPassword() {
		return this.Password;
	}

	public void SetPassword(String password) {
		this.Password = password;
	}

	public String GetId() {
		return this.Id;
	}

	public void SetId(String id) {
		this.Id = id;
	}
}
