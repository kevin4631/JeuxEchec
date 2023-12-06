package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import piece.Piece;

public class JPanelIcon extends JPanel {

	private int index;
	private List<Piece> piecesMortes;

	public JPanelIcon(int index, List<Piece> piecesMortes) {
		this.index = index;
		this.piecesMortes = piecesMortes;
		setBackground(Color.cyan);
		setSize(30, 30);

		if (piecesMortes.get(index) != null) {
			ImageIcon i = new ImageIcon(piecesMortes.get(index).getImage());
			add(new JLabel(i));
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Piece piece = piecesMortes.get(index);
		if (piece != null)
			g.drawImage(piece.getImage(), 0, 0, getHeight(), getHeight(), null);
	}

}
