package gui;

import javax.swing.JFrame;

public class FrameFenetre extends JFrame {

	public FrameFenetre(int sizeX, int sizeY) {

		// Titre
		setTitle("Projet echec RTAI");
		// Taille au lancement
		setSize(sizeX, sizeY);
		// Lancement au millieu de l'ecran
		setLocationRelativeTo(null);
		// Operation a l fermeture
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
