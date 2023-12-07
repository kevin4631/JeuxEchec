package gui;

import backEnd.echiquier.Echiquier;
import backEnd.joueur.JoueurBlanc;
import backEnd.joueur.JoueurNoir;

public class Main {

	public static Echiquier echiquier;
	public static JFrameFenetre gui;
	static JoueurBlanc joueurBlanc;
	static JoueurNoir joueurNoir;

	static public int nbCaseLongeur = 8;

	public static void main(String[] args) {

		lancerPartie();

		gui = new JFrameFenetre();
		gui.setVisible(true);

	}

	public static void lancerPartie() {
		joueurBlanc = new JoueurBlanc();
		joueurNoir = new JoueurNoir();
		echiquier = new Echiquier(joueurBlanc, joueurNoir);
	}
}