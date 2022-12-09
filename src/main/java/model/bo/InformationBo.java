package model.bo;

import model.bean.Information;
import model.dao.InformationDao;

public class InformationBo {
	private InformationDao informationDao;

	public InformationBo() {
		this.informationDao = new InformationDao();
	}
	
	public void Update(String userId, Information information) throws Exception {
		informationDao.Update(userId, information);
	}
}
