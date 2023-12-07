package gui.panelsPieceDead;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;

import javax.swing.JPanel;

import backEnd.enumPackges.ECouleur;
import backEnd.piece.Piece;
import gui.Main;

public class JPanelIcon extends JPanel {

	private int index;
	private ECouleur couleur;

	public JPanelIcon(int index, ECouleur couleur) {
		this.couleur = couleur;
		this.index = index;
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		List<Piece> list;
		if (couleur == ECouleur.BLANC) {
			list = Main.echiquier.getJoueurBlanc().getlistPieceMorte();
		} else {
			list = Main.echiquier.getJoueurNoir().getlistPieceMorte();
		}

		super.paintComponent(g);
		Piece piece = list.get(index);

		if (piece != null)
			g2d.drawImage(piece.getImage(), 0, 0, getWidth(), getWidth(), null);
	}

}
