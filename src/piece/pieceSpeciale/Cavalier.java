package piece.pieceSpeciale;

import echiquier.Coordonee;
import echiquier.Echiquier;
import echiquier.ICoordonee;
import piece.ListElementICoordonee;
import piece.Piece;
import piece.Vecteur;
import piece.enumPackges.Couleur;
import piece.enumPackges.NomPiece;

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
