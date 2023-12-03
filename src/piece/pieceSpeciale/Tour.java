package piece.pieceSpeciale;

import echiquier.Echiquier;
import echiquier.ICoordonee;
import piece.ListElementICoordonee;
import piece.Piece;
import piece.enumPackges.Couleur;
import piece.enumPackges.Direction;
import piece.enumPackges.NomPiece;

public class Tour extends Piece {

	public Tour(Couleur couleur) {
		super(couleur, NomPiece.TOUR);
	}

	@Override
	public ListElementICoordonee getDeplacement(Echiquier echiquier, int x, int y) {
		ListElementICoordonee listeCase = new ListElementICoordonee();
		ListElementICoordonee listVecteur = new ListElementICoordonee();

		listVecteur.add(Direction.UP);
		listVecteur.add(Direction.DOWN);
		listVecteur.add(Direction.LEFT);
		listVecteur.add(Direction.RIGHT);

		for (ICoordonee vecteur : listVecteur.getListDeplacement()) {
			ListElementICoordonee c = echiquier.caseDestinationInDirection(x, y, (Direction) vecteur);
			listeCase.add(c);
		}

		return listeCase;
	}

}
