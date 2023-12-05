package piece;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import echiquier.Coordonee;
import echiquier.Echiquier;
import echiquier.ICoordonee;
import piece.enumPackges.Couleur;
import piece.enumPackges.Direction;
import piece.enumPackges.NomPiece;

public abstract class Piece implements ICoordonee {

	private int x;
	private int y;
	private boolean enVie = true;
	private Couleur couleur;
	private NomPiece nomPiece;
	private String path;
	BufferedImage image = null;

	protected Piece(int x, int y, Couleur couleur, NomPiece nomPiece) {
		super();
		this.x = x;
		this.y = y;
		this.couleur = couleur;
		this.nomPiece = nomPiece;
		path = "src/piece/img/" + nomPiece + "_" + couleur + ".png";

		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ListElementICoordonee caseDestinationInDirection(Echiquier echiquier, Direction vecteur) {
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

	public Couleur getCouleur() {
		return couleur;
	}

	public NomPiece getNomPiece() {
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

	public void mort() {
		enVie = false;
	}

	public Boolean enVie() {
		return enVie;
	}

	@Override
	public String toString() {
		return getNomPiece().toString();
	}


}
