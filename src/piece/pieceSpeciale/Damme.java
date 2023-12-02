package piece.pieceSpeciale;

import echiquier.Echiquier;
import echiquier.ICoordonee;
import piece.ListDeplacement;
import piece.Piece;
import piece.enumPackges.Couleur;
import piece.enumPackges.Direction;
import piece.enumPackges.NomPiece;

public class Damme extends Piece {

	public Damme(Couleur couleur) {
		super(couleur, NomPiece.DAMME);
	}

	@Override
	public ListDeplacement getDeplacement(Echiquier echiquier, int x, int y) {
		ListDeplacement listeCase = new ListDeplacement();
		ListDeplacement listVecteur = new ListDeplacement();

		listVecteur.add(Direction.UP);
		listVecteur.add(Direction.DOWN);
		listVecteur.add(Direction.LEFT);
		listVecteur.add(Direction.RIGHT);
		listVecteur.add(Direction.LEFT_UP);
		listVecteur.add(Direction.LEFT_DOWN);
		listVecteur.add(Direction.RIGHT_UP);
		listVecteur.add(Direction.RIGHT_DOWN);

		for (ICoordonee vecteur : listVecteur.getListDeplacement()) {
			ListDeplacement c = echiquier.caseDestinationInDirection(x, y, (Direction) vecteur);
			listeCase.add(c);
		}

		return listeCase;
	}

}
