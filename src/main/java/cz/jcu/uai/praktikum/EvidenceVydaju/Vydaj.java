package cz.jcu.uai.praktikum.EvidenceVydaju;

import java.util.Date;

public class Vydaj {

	private Date datum;
	private double castka;

	public Vydaj(Date datum, double castka) {
		this.datum = datum;
		this.castka = castka;	
	}
	
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public double getCastka() {
		return castka;
	}
	public void setCastka(double castka) {
		this.castka = castka;
	}
	
}
