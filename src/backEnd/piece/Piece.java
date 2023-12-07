package backEnd.piece;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import backEnd.ICoordonee;
import backEnd.ListElementICoordonee;
import backEnd.echiquier.Coordonee;
import backEnd.echiquier.Echiquier;
import backEnd.enumPackges.ECouleur;
import backEnd.enumPackges.EDirection;
import backEnd.enumPackges.ENomPiece;

public abstract class Piece implements ICoordonee {

	private int x;
	private int y;
	private ECouleur couleur;
	private ENomPiece nomPiece;
	private String path;
	private BufferedImage image = null;

	protected Piece(int x, int y, ECouleur couleur, ENomPiece nomPiece) {
		super();
		this.x = x;
		this.y = y;
		this.couleur = couleur;
		this.nomPiece = nomPiece;
		path = "img/" + nomPiece + "_" + couleur + ".png";

		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ListElementICoordonee listCoordoneesInDirection(Echiquier echiquier, EDirection vecteur) {
		ListElementICoordonee coordonees = new ListElementICoordonee();

		int vx = vecteur.getX();
		int vy = vecteur.getY();

		while (echiquier.inEchiquier(x + vx, y + vy) && echiquier.caseVide(x + vx, y + vy)) {
			coordonees.add(new Coordonee(x + vx, y + vy));
			vy += vecteur.getY();
			vx += vecteur.getX();
		}

		Piece p = echiquier.getPiece(x + vx, y + vy);
		if (echiquier.inEchiquier(x + vx, y + vy) && p != null && p.getCouleur() != couleur)
			coordonees.add(new Coordonee(x + vx, y + vy));

		return coordonees;
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

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return getNomPiece().toString();
	}


}
