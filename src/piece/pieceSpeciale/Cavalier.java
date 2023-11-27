package piece.pieceSpeciale;

import echiquier.Echiquier;
import piece.Couleur;
import piece.DeplacementPosible;
import piece.NomPiece;
import piece.Piece;

public class Cavalier extends Piece {

	public Cavalier(Couleur couleur) {
		super(couleur, NomPiece.CAVALIER);
	}

	@Override
	public DeplacementPosible getDeplacement(Echiquier echiquier, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
