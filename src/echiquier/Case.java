package echiquier;

import piece.Deplacement;
import piece.Piece;
import piece.enumPackges.Couleur;

public class Case {

	private int possitionX;
	private int possitionY;
	private Piece piece = null;

	public Case(int possitionX, int possitionY) {
		super();
		this.possitionX = possitionX;
		this.possitionY = possitionY;
	}

	public void assignerPiece(Piece piece) {
		this.piece = piece;
	}

	public Boolean isVide() {
		return piece == null;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Piece popPiece() {
		Piece p = piece;
		piece = null;
		return p;
	}

	public int getPossitionX() {
		return possitionX;
	}

	public int getPossitionY() {
		return possitionY;
	}

	public Couleur getCouleurPiece() {
		if (isVide())
			return null;
		return piece.getCouleur();
	}

	@Override
	public String toString() {
		return "x: " + getPossitionX() + "  y: " + getPossitionY() + "   " + getPiece();
	}

	public Deplacement getDeplacementPiece(Echiquier echiquier) {
		return piece.getDeplacement(echiquier, possitionX, possitionY);
	}

}
