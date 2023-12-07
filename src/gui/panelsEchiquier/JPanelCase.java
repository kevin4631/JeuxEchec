package gui.panelsEchiquier;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import backEnd.piece.Piece;
import gui.Main;

public class JPanelCase extends JPanel {

	private Color couleur;
	private Color couleurSelection;

	private int possitionX;
	private int possitionY;

	public JPanelCase(Color couleur, Color couleurSelection, int x, int y) {
		this.possitionX = x;
		this.possitionY = y;
		this.couleur = couleur;
		this.couleurSelection = couleurSelection;
		setBackground(couleur);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// pour afficher le Background
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

		Piece piece = Main.echiquier.getPiece(possitionX, possitionY);

		if (piece != null)
			g2d.drawImage(piece.getImage(), 0, 0, getHeight(), getHeight(), null);
	}

	public void paintBackground(Boolean paint) {
		if (paint)
			setBackground(couleurSelection);
		else
			setBackground(couleur);
	}

	public int getPositionX() {
		return possitionX;
	}

	public int getPositionY() {
		return possitionY;
	}

}