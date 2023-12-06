package backEnd.piece.allPiece;

import backEnd.ICoordonee;
import backEnd.ListElementICoordonee;
import backEnd.echiquier.Coordonee;
import backEnd.echiquier.Echiquier;
import backEnd.piece.Piece;
import backEnd.piece.Vecteur;
import backEnd.piece.enumPackges.Couleur;
import backEnd.piece.enumPackges.NomPiece;

public class Cavalier extends Piece {

	public Cavalier(int x, int y, Couleur couleur) {
		super(x, y, couleur, NomPiece.CAVALIER);
	}

	@Override
	public ListElementICoordonee getDeplacement(Echiquier echiquier) {
		ListElementICoordonee listeCoordonee = new ListElementICoordonee();
		ListElementICoordonee listVecteur = new ListElementICoordonee();

		listVecteur.add(new Vecteur(+2, +1));
		listVecteur.add(new Vecteur(+2, -1));

		listVecteur.add(new Vecteur(-2, +1));
		listVecteur.add(new Vecteur(-2, -1));

		listVecteur.add(new Vecteur(+1, +2));
		listVecteur.add(new Vecteur(+1, -2));

		listVecteur.add(new Vecteur(-1, +2));
		listVecteur.add(new Vecteur(-1, -2));

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
