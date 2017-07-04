package cz.jcu.uai.praktikum.EvidenceVydaju;

import javax.swing.*;
import java.awt.*;

public class HlavniMenu {
	JFrame hlavniMenu;
	JPanel panel;
	FlowLayout fl = new FlowLayout();
	GridBagLayout gbl = new GridBagLayout();
	
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
	}
	
	public static void main (String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				HlavniMenu menu = new HlavniMenu();
			}
		});
	}
}
