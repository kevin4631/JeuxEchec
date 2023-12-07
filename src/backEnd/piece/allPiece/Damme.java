package backEnd.piece.allPiece;

import backEnd.ICoordonee;
import backEnd.ListElementICoordonee;
import backEnd.echiquier.Echiquier;
import backEnd.enumPackges.ECouleur;
import backEnd.enumPackges.EDirection;
import backEnd.enumPackges.ENomPiece;
import backEnd.piece.Piece;

public class Damme extends Piece {

	public Damme(int x, int y, ECouleur couleur) {
		super(x, y, couleur, ENomPiece.DAMME);
	}

	@Override
	public ListElementICoordonee getDeplacement(Echiquier echiquier) {
		ListElementICoordonee listeCoordonee = new ListElementICoordonee();
		ListElementICoordonee listVecteur = new ListElementICoordonee();

		listVecteur.add(EDirection.UP);
		listVecteur.add(EDirection.DOWN);
		listVecteur.add(EDirection.LEFT);
		listVecteur.add(EDirection.RIGHT);
		listVecteur.add(EDirection.LEFT_UP);
		listVecteur.add(EDirection.LEFT_DOWN);
		listVecteur.add(EDirection.RIGHT_UP);
		listVecteur.add(EDirection.RIGHT_DOWN);

		for (ICoordonee vecteur : listVecteur.getListElement()) {
			ListElementICoordonee c = listCoordoneesInDirection(echiquier, (EDirection) vecteur);
			listeCoordonee.add(c);
		}

		return listeCoordonee;
	}

}