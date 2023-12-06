package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import piece.Piece;

public class JPanelIcon extends JPanel {

	private int index;

	public JPanelIcon(int index) {
		this.index = index;
		setBackground(Color.cyan);
		setSize(30, 30);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Piece piece = Main.echiquier.getJoueurNoir().getPiecesMorte().get(index);

		if (piece != null)
			g.drawImage(piece.getImage(), 0, 0, getHeight(), getHeight(), null);
	}

}
