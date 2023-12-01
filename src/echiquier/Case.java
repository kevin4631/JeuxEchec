package echiquier;

import piece.Piece;

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

	public Boolean caseVide() {
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

	public String toString() {
		return "x: " + getPossitionX() + "  y: " + getPossitionY() + "   " + getPiece();
	}

}
