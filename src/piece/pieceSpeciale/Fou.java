package piece.pieceSpeciale;

import echiquier.Echiquier;
import echiquier.ICoordonee;
import piece.ListElementICoordonee;
import piece.Piece;
import piece.enumPackges.Couleur;
import piece.enumPackges.Direction;
import piece.enumPackges.NomPiece;

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
