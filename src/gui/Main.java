package gui;

import backEnd.echiquier.Echiquier;
import backEnd.joueur.JoueurBlanc;
import backEnd.joueur.JoueurNoir;

public class Main {

	public static Echiquier echiquier;
	public static JFrameFenetre gui;
	public static JoueurBlanc joueurBlanc;
	public static JoueurNoir joueurNoir;
	public static int nbCaseLongeur = 8;

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