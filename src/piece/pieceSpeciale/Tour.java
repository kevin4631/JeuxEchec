package piece.pieceSpeciale;

import echiquier.Echiquier;
import echiquier.ICoordonee;
import piece.ListElementICoordonee;
import piece.Piece;
import piece.enumPackges.Couleur;
import piece.enumPackges.Direction;
import piece.enumPackges.NomPiece;

public class Tour extends Piece {

	public Tour(int x, int y, Couleur couleur) {
		super(x, y, couleur, NomPiece.TOUR);
	}

	@Override
	public ListElementICoordonee getDeplacement(Echiquier echiquier) {
		ListElementICoordonee listeCoordonee = new ListElementICoordonee();
		ListElementICoordonee listVecteur = new ListElementICoordonee();

		listVecteur.add(Direction.UP);
		listVecteur.add(Direction.DOWN);
		listVecteur.add(Direction.LEFT);
		listVecteur.add(Direction.RIGHT);

		for (ICoordonee vecteur : listVecteur.getListElement()) {
			ListElementICoordonee c = caseDestinationInDirection(echiquier, (Direction) vecteur);
			listeCoordonee.add(c);
		}

		return listeCoordonee;
	}

}
