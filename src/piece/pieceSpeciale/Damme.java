package piece.pieceSpeciale;

import piece.Couleur;
import piece.NomPiece;
import piece.Piece;
import utils.Coordonnees;

public class Damme extends Piece {

	public Damme(Couleur couleur, Coordonnees coordonnees) {
		super(couleur, NomPiece.DAMME, coordonnees);
	}

}
