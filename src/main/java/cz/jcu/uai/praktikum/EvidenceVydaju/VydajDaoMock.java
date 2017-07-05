package cz.jcu.uai.praktikum.EvidenceVydaju;

import java.util.ArrayList;
import java.util.List;

public class VydajDaoMock implements VydajDao {

	private List<Vydaj> vydaje = new ArrayList<Vydaj>();

	
	@Override
	public List<Vydaj> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Vydaj vydaj) {
		// TODO Auto-generated method stub

	}

}
