package model.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Skill {
	private String Id;
	private String InfoId;
	@JsonProperty("Name")
	private String Name;
	@JsonProperty("Percent")
	private int Percent;

	public Skill() {
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getInfoId() {
		return InfoId;
	}

	public void setInfoId(String infoId) {
		InfoId = infoId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getPercent() {
		return Percent;
	}

	public void setPercent(int percent) {
		Percent = percent;
	}
}
