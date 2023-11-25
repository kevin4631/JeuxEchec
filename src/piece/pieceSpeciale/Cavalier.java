package piece.pieceSpeciale;

import piece.Couleur;
import piece.NomPiece;
import piece.Piece;
import utils.Coordonnees;

public class Cavalier extends Piece {

	public Cavalier(Couleur couleur, Coordonnees coordonnees) {
		super(couleur, NomPiece.CAVALIER, coordonnees);
	}

}
