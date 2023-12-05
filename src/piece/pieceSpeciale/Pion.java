package piece.pieceSpeciale;

import echiquier.Coordonee;
import echiquier.Echiquier;
import echiquier.ICoordonee;
import piece.ListElementICoordonee;
import piece.Piece;
import piece.enumPackges.Couleur;
import piece.enumPackges.Direction;
import piece.enumPackges.NomPiece;

public class Pion extends Piece {
	private boolean premierTour = true;

	public Pion(int x, int y, Couleur couleur) {
		super(x, y, couleur, NomPiece.PION);
	}

	@Override
	public ListElementICoordonee getDeplacement(Echiquier echiquier) {
		int vecteurY = this.getCouleur() == Couleur.BLANC ? Direction.UP.getY() : Direction.DOWN.getY();

		ListElementICoordonee listeCoordonee = new ListElementICoordonee();
		ListElementICoordonee listVecteur = new ListElementICoordonee();

		int destinationX = getX();
		int destinationY = getY() + vecteurY;

		if (echiquier.inEchiquier(destinationX, destinationY) && echiquier.caseVide(destinationX, destinationY)) {
			listeCoordonee.add(new Coordonee(destinationX, destinationY));
			if (premierTour)
				listeCoordonee.add(new Coordonee(destinationX, destinationY + vecteurY));
		}

		listVecteur.add(Direction.LEFT_UP);
		listVecteur.add(Direction.RIGHT_UP);
		for (ICoordonee vecteur : listVecteur.getListElement()) {
			destinationX = getX() + vecteur.getX();
			destinationY = getY() + vecteur.getY() * vecteurY;

			Piece p = echiquier.getPiece(destinationX, destinationY);
			if (echiquier.inEchiquier(destinationX, destinationY) && p != null && p.getCouleur() != this.getCouleur())
				listeCoordonee.add(new Coordonee(destinationX, destinationY));
		}

		return listeCoordonee;
	}

	public void premierTourFalse() {
		premierTour = false;
	}

	public boolean getPremierTour() {
		return premierTour;
	}

}