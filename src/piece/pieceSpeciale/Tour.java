package piece.pieceSpeciale;

import echiquier.Echiquier;
import piece.Couleur;
import piece.Deplacement;
import piece.NomPiece;
import piece.Piece;

public class Tour extends Piece {

	public Tour(Couleur couleur) {
		super(couleur, NomPiece.TOUR);
	}

	@Override
	public Deplacement getDeplacement(Echiquier echiquier, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
