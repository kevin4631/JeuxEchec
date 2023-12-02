package piece.pieceSpeciale;

import echiquier.Echiquier;
import piece.Deplacement;
import piece.Piece;
import piece.enumPackges.Couleur;
import piece.enumPackges.NomPiece;

public class Pion extends Piece {
	private boolean premierTour = true;
	private Deplacement deplacements;

	public Pion(Couleur couleur) {
		super(couleur, NomPiece.PION);
	}

	@Override
	public Deplacement getDeplacement(Echiquier echiquier, int x, int y) {
		int vecteurY = this.getCouleur() == Couleur.BLANC ? +1 : -1;

		deplacements = new Deplacement();
		if (echiquier.inEchiquier(x, y + vecteurY) && echiquier.isCaseVide(x, y + vecteurY))
			deplacements.addDeplacement(0, vecteurY);

		if (premierTour && echiquier.isCaseVide(x, y + vecteurY))
			deplacements.addDeplacement(0, vecteurY * 2);

		if (echiquier.inEchiquier(x - 1, y + vecteurY) && !echiquier.isCaseVide(x - 1, y + vecteurY)
				&& echiquier.getCouleurPiece(x - 1, y + vecteurY) != this.getCouleur())
			deplacements.addDeplacement(-1, vecteurY);

		if (echiquier.inEchiquier(x + 1, y + vecteurY) && !echiquier.isCaseVide(x + 1, y + vecteurY)
				&& echiquier.getCouleurPiece(x + 1, y + vecteurY) != this.getCouleur())
			deplacements.addDeplacement(1, vecteurY);

		return deplacements;
	}

	public void premierTourFalse() {
		premierTour = false;
	}

	public boolean getPremierTour() {
		return premierTour;
	}

}