package backEnd.piece.allPiece;

import backEnd.ICoordonee;
import backEnd.ListElementICoordonee;
import backEnd.echiquier.Coordonee;
import backEnd.echiquier.Echiquier;
import backEnd.piece.Piece;
import backEnd.piece.enumPackges.Couleur;
import backEnd.piece.enumPackges.Direction;
import backEnd.piece.enumPackges.NomPiece;

public class Roi extends Piece {

	public Roi(int x, int y, Couleur couleur) {
		super(x, y, couleur, NomPiece.ROI);
	}

	@Override
	public ListElementICoordonee getDeplacement(Echiquier echiquier) {
		ListElementICoordonee listeCoordonee = new ListElementICoordonee();
		ListElementICoordonee listVecteur = new ListElementICoordonee();

		listVecteur.add(Direction.UP);
		listVecteur.add(Direction.DOWN);
		listVecteur.add(Direction.LEFT);
		listVecteur.add(Direction.RIGHT);
		listVecteur.add(Direction.LEFT_UP);
		listVecteur.add(Direction.LEFT_DOWN);
		listVecteur.add(Direction.RIGHT_UP);
		listVecteur.add(Direction.RIGHT_DOWN);

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
