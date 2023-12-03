package piece.pieceSpeciale;

import echiquier.Case;
import echiquier.Echiquier;
import echiquier.ICoordonee;
import piece.ListElementICoordonee;
import piece.Piece;
import piece.Vecteur;
import piece.enumPackges.Couleur;
import piece.enumPackges.NomPiece;

public class Cavalier extends Piece {

	public Cavalier(Couleur couleur) {
		super(couleur, NomPiece.CAVALIER);
	}

	@Override
	public ListElementICoordonee getDeplacement(Echiquier echiquier, int origineX, int origineY) {
		ListElementICoordonee listeCase = new ListElementICoordonee();
		ListElementICoordonee listVecteur = new ListElementICoordonee();

		listVecteur.add(new Vecteur(+2, +1));
		listVecteur.add(new Vecteur(+2, -1));

		listVecteur.add(new Vecteur(-2, +1));
		listVecteur.add(new Vecteur(-2, -1));

		listVecteur.add(new Vecteur(+1, +2));
		listVecteur.add(new Vecteur(+1, -2));

		listVecteur.add(new Vecteur(-1, +2));
		listVecteur.add(new Vecteur(-1, -2));

		for (ICoordonee vecteur : listVecteur.getListDeplacement()) {
			int destinationX = origineX + vecteur.getX();
			int destinationY = origineY + vecteur.getY();
			if (echiquier.inEchiquier(destinationX, destinationY)
					&& echiquier.getCouleurPiece(destinationX, destinationY) != this.getCouleur())
				listeCase.add(new Case(destinationX, destinationY));
		}
		return listeCase;
	}

}
