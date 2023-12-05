package gui;

import echiquier.Echiquier;

public class Main {

	static Echiquier echiquier;
	static int nbCaseLongeur = 8;

	public static void main(String[] args) {

		echiquier = new Echiquier();

		JFrameFenetre gui = new JFrameFenetre();
		gui.setVisible(true);


	}

}