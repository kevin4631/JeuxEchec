package backEnd.piece.allPiece;

import backEnd.ICoordonee;
import backEnd.ListElementICoordonee;
import backEnd.echiquier.Echiquier;
import backEnd.piece.Piece;
import backEnd.piece.enumPackges.Couleur;
import backEnd.piece.enumPackges.Direction;
import backEnd.piece.enumPackges.NomPiece;

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
