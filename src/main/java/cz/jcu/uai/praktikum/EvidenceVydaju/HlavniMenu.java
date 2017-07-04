package cz.jcu.uai.praktikum.EvidenceVydaju;

import javax.swing.*;
import java.awt.*;

public class HlavniMenu {
	JFrame hlavniMenu;
	JPanel panel;
	JLabel textOkno, obrazekOkno;
	FlowLayout fl = new FlowLayout();
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	public HlavniMenu() {
		vytvorOkno();
	}
	
	private void vytvorOkno() {
		hlavniMenu = new JFrame ("Evidence výdajů");
		hlavniMenu.setSize(600, 600);
		hlavniMenu.setVisible(true);
		hlavniMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hlavniMenu.setLocationRelativeTo(null);
		hlavniMenu.setResizable(false);
		hlavniMenu.setLayout(fl);
		
		panel = new JPanel();
		panel.setLayout(gbl);
		panel.setBackground(Color.WHITE);
		
		textOkno = new JLabel("Vítejte v aplikaci Evidence Výdajů");
		textOkno.setFont (new Font("Sefir", Font.BOLD, 18));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.ipady = 15;
		gbc.anchor = (GridBagConstraints.CENTER);
		gbl.setConstraints(textOkno, gbc);
		panel.add(textOkno);
		
		hlavniMenu.add(panel);
		
	}
	
	public static void main (String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				HlavniMenu menu = new HlavniMenu();
			}
		});
	}
}
