package piece.pieceSpeciale;

import echiquier.Case;
import echiquier.Echiquier;
import echiquier.ICoordonee;
import piece.ListDeplacement;
import piece.Piece;
import piece.enumPackges.Couleur;
import piece.enumPackges.Direction;
import piece.enumPackges.NomPiece;

public class Pion extends Piece {
	private boolean premierTour = true;

	public Pion(Couleur couleur) {
		super(couleur, NomPiece.PION);
	}

	@Override
	public ListDeplacement getDeplacement(Echiquier echiquier, int origineX, int origineY) {
		int vecteurY = this.getCouleur() == Couleur.BLANC ? Direction.UP.getY() : Direction.DOWN.getY();

		ListDeplacement listeCase = new ListDeplacement();
		ListDeplacement listVecteur = new ListDeplacement();

		int destinationY = origineY + vecteurY;
		int destinationX = origineX;

		if (echiquier.inEchiquier(destinationX, destinationY) && echiquier.isCaseVide(destinationX, destinationY)) {
			listeCase.add(new Case(destinationX, destinationY));
			if (premierTour)
				listeCase.add(new Case(destinationX, destinationY + vecteurY));
		}

		listVecteur.add(Direction.LEFT_UP);
		listVecteur.add(Direction.RIGHT_UP);

		for (ICoordonee vecteur : listVecteur.getListDeplacement()) {
			destinationX = origineX + vecteur.getX();
			destinationY = origineY + vecteur.getY() * vecteurY;

			if (echiquier.inEchiquier(destinationX, destinationY) && !echiquier.isCaseVide(destinationX, destinationY)
					&& echiquier.getCouleurPiece(destinationX, destinationY) != this.getCouleur())
				listeCase.add(new Case(destinationX, destinationY));
		}
		return listeCase;
	}

	public void premierTourFalse() {
		premierTour = false;
	}

	public boolean getPremierTour() {
		return premierTour;
	}

}