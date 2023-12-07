package backEnd.piece.allPiece;

import backEnd.ICoordonee;
import backEnd.ListElementICoordonee;
import backEnd.echiquier.Coordonee;
import backEnd.echiquier.Echiquier;
import backEnd.enumPackges.ECouleur;
import backEnd.enumPackges.EDirection;
import backEnd.enumPackges.ENomPiece;
import backEnd.piece.Piece;

public class Roi extends Piece {

	public Roi(int x, int y, ECouleur couleur) {
		super(x, y, couleur, ENomPiece.ROI);
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
			int destinationX = getX() + vecteur.getX();
			int destinationY = getY() + vecteur.getY();
			Piece pieceDestination = echiquier.getPiece(destinationX, destinationY);

			if (echiquier.inEchiquier(destinationX, destinationY)
					&& (pieceDestination == null || pieceDestination.getCouleur() != this.getCouleur()))
				listeCoordonee.add(new Coordonee(destinationX, destinationY));
		}

		return listeCoordonee;
	}
}
