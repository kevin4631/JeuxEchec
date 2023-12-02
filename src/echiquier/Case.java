package echiquier;

import piece.ListDeplacement;
import piece.Piece;
import piece.enumPackges.Couleur;

public class Case implements ICoordonee {

	private int x;
	private int y;
	private Piece piece = null;

	public Case(int possitionX, int possitionY) {
		super();
		this.x = possitionX;
		this.y = possitionY;
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

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	public Couleur getCouleurPiece() {
		if (isVide())
			return null;
		return piece.getCouleur();
	}

	@Override
	public String toString() {
		return "x: " + x + "  y: " + y + "   " + getPiece();
	}

	public ListDeplacement getDeplacementPiece(Echiquier echiquier) {
		return piece.getDeplacement(echiquier, x, y);
	}

}
