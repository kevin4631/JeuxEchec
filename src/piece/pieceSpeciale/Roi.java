package piece.pieceSpeciale;

import echiquier.Echiquier;
import piece.ListDeplacement;
import piece.Piece;
import piece.Vecteur;
import piece.enumPackges.Couleur;
import piece.enumPackges.Direction;
import piece.enumPackges.NomPiece;

public class Roi extends Piece {

	public Roi(Couleur couleur) {
		super(couleur, NomPiece.ROI);
	}

	@Override
	public ListDeplacement getDeplacement(Echiquier echiquier, int x, int y) {
		ListDeplacement deplacements = new ListDeplacement();
		ListDeplacement dDirection = new ListDeplacement();

		dDirection.addDeplacement(Direction.UP.getVecteur());
		dDirection.addDeplacement(Direction.DOWN.getVecteur());
		dDirection.addDeplacement(Direction.LEFT.getVecteur());
		dDirection.addDeplacement(Direction.RIGHT.getVecteur());
		dDirection.addDeplacement(Direction.LEFT_UP.getVecteur());
		dDirection.addDeplacement(Direction.LEFT_DOWN.getVecteur());
		dDirection.addDeplacement(Direction.RIGHT_UP.getVecteur());
		dDirection.addDeplacement(Direction.RIGHT_DOWN.getVecteur());

		for (Vecteur vecteur : dDirection.getListDeplacement()) {
			if (echiquier.inEchiquier(x + vecteur.getX(), y + vecteur.getY())
					&& echiquier.getCouleurPiece(x + vecteur.getX(), y + vecteur.getY()) != this.getCouleur())
				deplacements.addDeplacement(vecteur.getX(), vecteur.getY());
		}

		return deplacements;
	}
}
