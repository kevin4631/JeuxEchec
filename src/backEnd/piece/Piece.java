package backEnd.piece;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import backEnd.ListElementICoordonee;
import backEnd.echiquier.Echiquier;
import backEnd.enumPackges.ECouleur;
import backEnd.enumPackges.ENomPiece;

public abstract class Piece {

	private int x;
	private int y;
	private ECouleur couleur;
	private ENomPiece nomPiece;
	private BufferedImage image = null;

	protected Piece(int x, int y, ECouleur couleur, ENomPiece nomPiece) {
		super();
		this.x = x;
		this.y = y;
		this.couleur = couleur;
		this.nomPiece = nomPiece;

		String path = "img/" + nomPiece + "_" + couleur + ".png";

		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract ListElementICoordonee getDeplacement(Echiquier echiquier);

	public BufferedImage getImage() {
		return image;
	}

	public ECouleur getCouleur() {
		return couleur;
	}

	public ENomPiece getNomPiece() {
		return nomPiece;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return getNomPiece().toString();
	}

}
