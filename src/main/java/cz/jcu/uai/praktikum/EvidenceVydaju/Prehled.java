package cz.jcu.uai.praktikum.EvidenceVydaju;

import java.awt.*;
import javax.swing.*;

public class Prehled {
	
	JFrame prehledOkno;
	JTabbedPane panelKarty;

	Prehled() {
		vytvorOkno();
	}
	
	private void vytvorOkno() {
		
		prehledOkno = new JFrame("Zobrazit výdaje");
		prehledOkno.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		prehledOkno.setSize(950, 450);
		prehledOkno.setLocationRelativeTo(null);
		
		panelKarty = new JTabbedPane();
		panelKarty.addTab("Přehled", new PrehledPodleKriterii());
		panelKarty.addTab("Prumery", new PrehledPrumery());
		panelKarty.addTab("Prehled v tabulkách", new PrehledTabulky());
		panelKarty.addTab("Celkové výdaje", new PrehledCelkovy());
		
		panelKarty.setBackgroundAt(0, new Color(255, 255, 255));
		panelKarty.setBackgroundAt(1, new Color(255, 255, 255));
		panelKarty.setBackgroundAt(2, new Color(255, 255, 255));
		panelKarty.setBackgroundAt(3, new Color(255, 255, 255));
		panelKarty.setFont(new Font("Serif", Font.BOLD, 16));
		
		
		
		prehledOkno.add(panelKarty);
		prehledOkno.setVisible(true);
		
		
		
	}
		// TODO Auto-generated constructor stub
	}


