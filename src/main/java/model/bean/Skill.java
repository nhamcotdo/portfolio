package model.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Skill {
	private String Id;
	private String InfoId;
	@JsonProperty("Name")
	private String Name;
	@JsonProperty("Percent")
	private int Percent;

	private Skill() {
	}

	public String GetId() {
		return this.Id;
	}

	public void SetId(String id) {
		this.Id = id;
	}

	public String GetInfoId() {
		return this.InfoId;
	}

	public void SetInfoId(String infoId) {
		this.InfoId = infoId;
	}

	public String GetName() {
		return this.Name;
	}

	public void SetName(String name) {
		this.Name = name;
	}

	public int GetPercent() {
		return this.Percent;
	}

	public void SetPercent(int percent) {
		this.Percent = percent;
	}
}
