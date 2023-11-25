package piece.pieceSpeciale;

import piece.Couleur;
import piece.NomPiece;
import piece.Piece;
import utils.Coordonnees;

public class Tour extends Piece {

	public Tour(Couleur couleur, Coordonnees coordonnees) {
		super(couleur, NomPiece.TOUR, coordonnees);
	}

}
