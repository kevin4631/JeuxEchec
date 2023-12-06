package backEnd.piece.allPiece;

import backEnd.ICoordonee;
import backEnd.ListElementICoordonee;
import backEnd.echiquier.Coordonee;
import backEnd.echiquier.Echiquier;
import backEnd.piece.Piece;
import backEnd.piece.enumPackges.Couleur;
import backEnd.piece.enumPackges.Direction;
import backEnd.piece.enumPackges.NomPiece;

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