package cz.jcu.uai.praktikum.EvidenceVydaju;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VlozitVydaj {
	JDialog vydajOkno;
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc= new GridBagConstraints();
	

	public VlozitVydaj() {
		vytvorOkno();
	}
	
	private void vytvorOkno() {
		vydajOkno = new JDialog();
		vydajOkno.setTitle("Vložit výdaj");
		vydajOkno.setSize(325, 300);
		vydajOkno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vydajOkno.setLocation(1020, 310);
		vydajOkno.setLocationRelativeTo(null);
		vydajOkno.setLayout(gbl);
		vydajOkno.setVisible(true);
		
		
	}

}
