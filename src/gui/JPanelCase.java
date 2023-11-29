package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import piece.Piece;

public class JPanelCase extends JPanel {

	private Color couleur;
	private Color couleurSelection;

	private int x;
	private int y;

	public JPanelCase(Color couleur, Color couleurSelection, int x, int y) {
		this.x = x;
		this.y = y;
		this.couleur = couleur;
		this.couleurSelection = couleurSelection;
		setBackground(couleur);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int height = getHeight();

		Piece piece = JFrameFenetre.echiquier.getCase(x, y).getPiece();

		if (piece != null)
			g.drawImage(piece.getImage(), 0, 0, height, height, this);
	}

	public Color getCouleur() {
		return couleur;
	}

	public Color getCouleurSelection() {
		return couleurSelection;
	}

	public int getJPanelCaseX() {
		return x;
	}

	public int getJPanelCaseY() {
		return y;
	}

}