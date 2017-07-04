package cz.jcu.uai.praktikum.EvidenceVydaju;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HlavniMenu {
	JFrame hlavniMenu;
	JPanel panel;
	JLabel textOkno, obrazekOkno;
	JButton vlozitVydaj, info, konec;
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
		
		textOkno = new JLabel("Vítejte v aplikaci Evidence výdajů");
		textOkno.setFont (new Font("Sefir", Font.BOLD, 18));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.ipady = 15;
		gbc.anchor = (GridBagConstraints.CENTER);
		gbl.setConstraints(textOkno, gbc);
		panel.add(textOkno);
		
		vlozitVydaj = new JButton ("Vložit výdaje");
		vlozitVydaj.setFont(new Font("Serif", Font.BOLD, 20));
		vlozitVydaj.setBackground(new Color(255, 150, 100) );
		vlozitVydaj.setFocusPainted(false);
		vlozitVydaj.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets (10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.gridwidth = 1;
		gbl.setConstraints(vlozitVydaj, gbc);
		vlozitVydaj.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				VlozitVydaj vlozitVydaj = new VlozitVydaj();
			}
		});
		panel.add(vlozitVydaj);
		
		info = new JButton("Informace");
		info.setFont(new Font("Serif",Font.BOLD,18));
		info.setBackground(new Color(255, 150, 100));
		info.setFocusPainted(false);
		info.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets (10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 1;
		gbc.gridwidth = 1;
		gbl.setConstraints(info, gbc);
		info.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				JOptionPane.showMessageDialog(info, "Verze 1.0",null,JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panel.add(info);

		
		
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
