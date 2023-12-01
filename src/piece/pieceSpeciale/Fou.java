package piece.pieceSpeciale;

import echiquier.Echiquier;
import piece.Couleur;
import piece.Deplacement;
import piece.NomPiece;
import piece.Piece;

public class Fou extends Piece {

	private Deplacement deplacements;

	public Fou(Couleur couleur) {
		super(couleur, NomPiece.FOU);
	}

	@Override
	public Deplacement getDeplacement(Echiquier echiquier, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
