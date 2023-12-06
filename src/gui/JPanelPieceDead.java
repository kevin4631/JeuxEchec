package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import piece.Piece;
import piece.enumPackges.Couleur;

public class JPanelPieceDead extends JPanel {

	private String titre;
	private int width;
	private int height;
	private Couleur couleur;
	private List<Piece> piecesMortes;

	public JPanelPieceDead(String titre, int width, int height, Couleur couleur) {
		this.titre = titre;
		this.width = width;
		this.height = height;
		this.couleur = couleur;

		setBorder(BorderFactory.createTitledBorder(titre));
		setLayout(new GridLayout(8, 2, 3, 3));
		setPreferredSize(new Dimension(width, height));

		if (couleur == Couleur.BLANC) {
			setBackground(Color.blue);
			piecesMortes = Main.echiquier.getJoueurBlanc().getPiecesMorte();
		}
		else {
			setBackground(Color.black);
			piecesMortes = Main.echiquier.getJoueurNoir().getPiecesMorte();
		}

		for (int i = 0; i < 16; i++) {
			JPanelIcon pi = new JPanelIcon(i, piecesMortes);
			pi.setSize(10, 10);
			add(pi);
		}
	}


}