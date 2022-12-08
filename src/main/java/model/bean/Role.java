package model.bean;

public class Role {
	private String Id;
	private String Name;

	private Role() {
	}

	public String GetId() {
		return this.Id;
	}

	public void SetId(String id) {
		this.Id = id;
	}

	public String GetName() {
		return this.Name;
	}

	public void SetName(String name) {
		this.Name = name;
	}
}
