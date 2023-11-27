package piece.pieceSpeciale;

import echiquier.Echiquier;
import piece.Couleur;
import piece.DeplacementPosible;
import piece.NomPiece;
import piece.Piece;

public class Roi extends Piece {

	public Roi(Couleur couleur) {
		super(couleur, NomPiece.ROI);
	}

	@Override
	public DeplacementPosible getDeplacement(Echiquier echiquier, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
