package gui.jboutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.JFrameFenetre;
import gui.Main;

public class JBoutonRelancer extends JBoutons {

	public JBoutonRelancer(JFrameFenetre fenetre) {
		super("Relancer");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.lancerPartie();
				fenetre.getpanelEchiquier().reinitialiser();
				fenetre.getpanelFonctionnalites().repaint();
			}
		});
	}
}