package gui;

import echiquier.Echiquier;
import joueur.JoueurBlanc;
import joueur.JoueurNoir;

public class Main {

	static Echiquier echiquier = new Echiquier();
	static int nbCaseLongeur = 8;

	public static void main(String[] args) {
		JoueurBlanc joueurBlanc = new JoueurBlanc(echiquier);
		JoueurNoir joueurNoir = new JoueurNoir(echiquier);

		JFrameFenetre gui = new JFrameFenetre();
		gui.setVisible(true);

	}
}