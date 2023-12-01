package gui;

import echiquier.Echiquier;

public class Main {
	
	static Echiquier echiquier = new Echiquier();
	static int nbCaseLongeur = 8; 
	
	public static void main(String[] args) {
		
		echiquier.initialiserEchiquier();

		JFrameFenetre gui = new JFrameFenetre();
		gui.setVisible(true);
	}
}
