package gui.panelsPieceDead;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import piece.enumPackges.Couleur;

public class JPanelPieceDead extends JPanel {

	private String titre;
	private int width;
	private int height;
	private Couleur couleur;

	public JPanelPieceDead(String titre, int width, int height, Couleur couleur) {
		this.titre = titre;
		this.width = width;
		this.height = height;
		this.couleur = couleur;

		setBorder(BorderFactory.createTitledBorder(titre));
		setLayout(new GridLayout(8, 2, 3, 3));
		setPreferredSize(new Dimension(width, height));



		for (int i = 0; i < 16; i++) {
			add(new JPanelIcon(i, couleur));
		}

	}


}