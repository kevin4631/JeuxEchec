package piece.pieceSpeciale;

import echiquier.Echiquier;
import piece.Couleur;
import piece.DeplacementPosible;
import piece.NomPiece;
import piece.Piece;

public class Fou extends Piece {

	public Fou(Couleur couleur) {
		super(couleur, NomPiece.FOU);
	}

	@Override
	public DeplacementPosible getDeplacement(Echiquier echiquier, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
