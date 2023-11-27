package piece;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import echiquier.Echiquier;

public abstract class Piece {

	private Couleur couleur;
	private NomPiece nomPiece;
	private String path;

	protected Piece(Couleur couleur, NomPiece nomPiece) {
		super();
		this.couleur = couleur;
		this.nomPiece = nomPiece;
		path = "src/piece/img/" + nomPiece + "_" + couleur + ".png";
	}

	public abstract DeplacementPosible getDeplacement(Echiquier echiquier, int x, int y);

	public BufferedImage getImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public NomPiece getNomPiece() {
		return nomPiece;
	}

	public String toString() {
		return getNomPiece().toString();
	}

}
