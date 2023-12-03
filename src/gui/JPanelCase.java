package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import piece.Piece;

public class JPanelCase extends JPanel {

	private Color couleur;
	private Color couleurSelection;

	private int JPanelCaseX;
	private int JPanelCaseY;

	public JPanelCase(Color couleur, Color couleurSelection, int x, int y) {
		this.JPanelCaseX = x;
		this.JPanelCaseY = y;
		this.couleur = couleur;
		this.couleurSelection = couleurSelection;
		setBackground(couleur);
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

		// pour afficher le Background
		super.paintComponent(g);

		Piece piece = Main.echiquier.getCase(JPanelCaseX, JPanelCaseY).getPiece();

		if (piece != null)
			g.drawImage(piece.getImage(), 0, 0, getHeight(), getHeight(), this);
	}

	public void paintBackground(Boolean paint) {
		if (paint)
			setBackground(couleurSelection);
		else
			setBackground(couleur);
	}

	public int getJPanelCaseX() {
		return JPanelCaseX;
	}

	public int getJPanelCaseY() {
		return JPanelCaseY;
	}

}