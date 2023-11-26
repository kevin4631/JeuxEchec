package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import echiquier.Echiquier;

public class Fenetre {

	public static void main(String[] args) {

		Echiquier echiquier = new Echiquier();
		echiquier.initialiserEchiquier();

		FrameFenetre fenetreJeu = new FrameFenetre(900, 900);

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(1, 1));

		PanelEchiquier panelEchiquier = new PanelEchiquier(echiquier);

		panelPrincipal.add(panelEchiquier);
		fenetreJeu.add(panelPrincipal, BorderLayout.CENTER);

		fenetreJeu.setVisible(true);

	}

}
