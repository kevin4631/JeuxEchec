package piece.pieceSpeciale;

import piece.Couleur;
import piece.NomPiece;
import piece.Piece;
import utils.Coordonnees;

public class Roi extends Piece {

	public Roi(Couleur couleur, Coordonnees coordonnees) {
		super(couleur, NomPiece.ROI, coordonnees);
	}

}
