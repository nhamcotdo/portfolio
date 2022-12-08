package model.bean;

public class Education {
	private String Id;
	private String Title;
	private String Year;
	private String Subtitle;
	private String Description;
	private String InfoId;

	public Education() {
	}

	public String GetId() {
		return this.Id;
	}

	public void SetId(String id) {
		this.Id = id;
	}

	public String GetTitle() {
		return this.Title;
	}

	public void SetTitle(String title) {
		this.Title = title;
	}

	public String GetYear() {
		return this.Year;
	}

	public void SetYear(String year) {
		this.Year = year;
	}

	public String GetSubtitle() {
		return this.Subtitle;
	}

	public void SetSubtitle(String subtitle) {
		this.Subtitle = subtitle;
	}

	public String GetDescription() {
		return this.Description;
	}

	public void SetDescription(String description) {
		this.Description = description;
	}

	public String GetInfoId() {
		return this.InfoId;
	}

	public void SetInfoId(String infoId) {
		this.InfoId = infoId;
	}
}
