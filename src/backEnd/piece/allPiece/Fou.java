package backEnd.piece.allPiece;

import backEnd.ICoordonee;
import backEnd.ListElementICoordonee;
import backEnd.echiquier.Echiquier;
import backEnd.piece.Piece;
import backEnd.piece.enumPackges.Couleur;
import backEnd.piece.enumPackges.Direction;
import backEnd.piece.enumPackges.NomPiece;

public class Fou extends Piece {

	public Fou(int x, int y, Couleur couleur) {
		super(x, y, couleur, NomPiece.FOU);
	}

	@Override
	public ListElementICoordonee getDeplacement(Echiquier echiquier) {
		ListElementICoordonee listeCoordonee = new ListElementICoordonee();
		ListElementICoordonee listVecteur = new ListElementICoordonee();

		listVecteur.add(Direction.LEFT_UP);
		listVecteur.add(Direction.LEFT_DOWN);
		listVecteur.add(Direction.RIGHT_UP);
		listVecteur.add(Direction.RIGHT_DOWN);

		for (ICoordonee vecteur : listVecteur.getListElement()) {
			ListElementICoordonee c = caseDestinationInDirection(echiquier, (Direction) vecteur);
			listeCoordonee.add(c);
		}

		return listeCoordonee;
	}

}
