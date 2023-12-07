package gui.jboutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.JFrameFenetre;

public class JBoutonQuitter extends JBoutons {

	public JBoutonQuitter(JFrameFenetre fenetre) {
		super("Quitter");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}