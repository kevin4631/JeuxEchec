package gui;

import echiquier.Echiquier;

public class Main {
	public static void main(String[] args) {

		Echiquier echiquier = new Echiquier();
		echiquier.initialiserEchiquier();

		JFrameFenetre gui = new JFrameFenetre(echiquier);
		gui.setVisible(true);
	}
}
