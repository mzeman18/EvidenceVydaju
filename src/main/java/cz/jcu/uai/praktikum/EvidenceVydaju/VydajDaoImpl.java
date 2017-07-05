package cz.jcu.uai.praktikum.EvidenceVydaju;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VydajDaoImpl implements VydajDao {

	   List<Vydaj> vydaje;

	   public VydajDaoImpl(){
	   }
	      
	@Override
	public List<Vydaj> findAll() {
		return vydaje;
	}

	@Override
	public void save(Vydaj vydaj) {
		vydaje = new ArrayList<Vydaj>();
	}
	

}
