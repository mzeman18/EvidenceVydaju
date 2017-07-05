package cz.jcu.uai.praktikum.EvidenceVydaju;

import java.util.List;

public interface VydajDao {

	List<Vydaj> findAll();
	void save(Vydaj vydaj);
	
	
}
