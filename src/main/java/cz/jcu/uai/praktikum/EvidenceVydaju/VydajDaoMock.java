package cz.jcu.uai.praktikum.EvidenceVydaju;

import java.util.ArrayList;
import java.util.List;

public class VydajDaoMock implements VydajDao {
	
	   List<Vydaj> vydaje = new ArrayList<>();

	@Override
	public List<Vydaj> findAll() {
		return vydaje;
	}

	@Override
	public void saveVydaj(Vydaj v) {
		vydaje.add(v); 

	}


}
