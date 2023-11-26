package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import echiquier.Case;
import echiquier.Echiquier;
import piece.Piece;

public class PanelEchiquier extends JPanel {

	private Color couleurClaire = Color.decode("#FAFAFA");
	private Color couleurSombre = Color.decode("#ABABAB");
	private Case caseSelection = null;
	private Echiquier echiquier;
	private int nbCarrelongeur = 8;

	public PanelEchiquier(Echiquier echiquier) {
		this.echiquier = echiquier;
	}

	public void paint(Graphics g) {

		int height = getHeight();
		int width = getWidth();
		int sizeMin = width < height ? width : height;
		int sizeCase = sizeMin / 8;

		boolean couleur = true;

		// creation quadrillage
		for (int y = 0; y < nbCarrelongeur; y++) {
			couleur = !couleur;
			for (int x = 0; x < nbCarrelongeur; x++) {
				couleur = !couleur;
				g.setColor(couleur ? couleurClaire : couleurSombre);
				g.fillRect(x * sizeCase, y * sizeCase, sizeCase, sizeCase);
			}
		}

		for (Piece piece : echiquier.getJoueurBlanc().getListPiece()) {
			g.drawImage(piece.getImage(), piece.getCoordonnees().getX() * sizeCase,
					piece.getCoordonnees().getY() * sizeCase, sizeCase, sizeCase, this);
		}

		for (Piece piece : echiquier.getJoueurNoir().getListPiece()) {
			g.drawImage(piece.getImage(), piece.getCoordonnees().getX() * sizeCase,
					piece.getCoordonnees().getY() * sizeCase, sizeCase, sizeCase, this);
		}

	}

}
