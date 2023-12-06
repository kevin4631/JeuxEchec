package gui.panelsPieceDead;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;

import javax.swing.JPanel;

import piece.Piece;

public class JPanelIcon extends JPanel {

	private int index;
	private List<Piece> list;

	public JPanelIcon(int index, List<Piece> list) {
		this.list = list;
		this.index = index;
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

		super.paintComponent(g);
		Piece piece = list.get(index);

		if (piece != null)
			g2d.drawImage(piece.getImage(), 0, 0, getHeight(), getHeight(), null);
	}

}
