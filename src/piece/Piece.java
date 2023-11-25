package piece;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import utils.Coordonnees;

public abstract class Piece {

	private Couleur couleur;
	private NomPiece nomPiece;
	private String path;
	private Coordonnees coordonnees;

	protected Piece(Couleur couleur, NomPiece nomPiece, Coordonnees coordonnees) {
		super();
		this.couleur = couleur;
		this.nomPiece = nomPiece;
		this.coordonnees = coordonnees;
		path = "src/piece/img/" + nomPiece + "_" + couleur + ".png";
	}

	public BufferedImage getImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(getPath()));
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String toString() {
		return getNomPiece().toString();
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}
}
