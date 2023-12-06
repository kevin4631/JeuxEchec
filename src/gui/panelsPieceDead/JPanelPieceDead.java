package gui.panelsPieceDead;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import gui.Main;
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
			piecesMortes = Main.echiquier.getJoueurBlanc().getPiecesMorte();
		}
		else {
			piecesMortes = Main.echiquier.getJoueurNoir().getPiecesMorte();
		}

		for (int i = 0; i < 16; i++) {
			add(new JPanelIcon(i, piecesMortes));
		}

	}


}