package piece.pieceSpeciale;

import piece.Couleur;
import piece.NomPiece;
import piece.Piece;
import utils.Coordonnees;

public class Fou extends Piece {

	public Fou(Couleur couleur, Coordonnees coordonnees) {
		super(couleur, NomPiece.FOU, coordonnees);
	}

}
