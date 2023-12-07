package backEnd.piece.allPiece;

import backEnd.ICoordonee;
import backEnd.ListElementICoordonee;
import backEnd.echiquier.Echiquier;
import backEnd.enumPackges.ECouleur;
import backEnd.enumPackges.EDirection;
import backEnd.enumPackges.ENomPiece;
import backEnd.piece.Piece;

public class Tour extends Piece {

	public Tour(int x, int y, ECouleur couleur) {
		super(x, y, couleur, ENomPiece.TOUR);
	}

	@Override
	public ListElementICoordonee getDeplacement(Echiquier echiquier) {
		ListElementICoordonee listeCoordonee = new ListElementICoordonee();
		ListElementICoordonee listVecteur = new ListElementICoordonee();

		listVecteur.add(EDirection.UP);
		listVecteur.add(EDirection.DOWN);
		listVecteur.add(EDirection.LEFT);
		listVecteur.add(EDirection.RIGHT);

		for (ICoordonee vecteur : listVecteur.getListElement()) {
			ListElementICoordonee c = listCoordoneesInDirection(echiquier, (EDirection) vecteur);
			listeCoordonee.add(c);
		}

		return listeCoordonee;
	}

}
