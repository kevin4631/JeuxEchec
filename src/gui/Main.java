package gui;

import backEnd.echiquier.Echiquier;

public class Main {

	static public Echiquier echiquier;
	static public JFrameFenetre gui;
	static public int nbCaseLongeur = 8;

	public static void main(String[] args) {

		echiquier = new Echiquier();

		gui = new JFrameFenetre();
		gui.setVisible(true);


	}

}