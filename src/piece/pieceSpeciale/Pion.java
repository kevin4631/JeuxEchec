package piece.pieceSpeciale;

import echiquier.Echiquier;
import piece.Couleur;
import piece.DeplacementPosible;
import piece.NomPiece;
import piece.Piece;

public class Pion extends Piece {

	private boolean premierTour = true;
	private DeplacementPosible deplacements;

	public Pion(Couleur couleur) {
		super(couleur, NomPiece.PION);
	}

	public DeplacementPosible getDeplacement(Echiquier echiquier, int x, int y) {
		int vecteurY = this.getCouleur() == Couleur.BLANC ? +1 : -1;

		deplacements = new DeplacementPosible();

		if (echiquier.getCase(x, y + vecteurY).caseVide())
			deplacements.addDeplacement(0, vecteurY);

		if (premierTour)
			deplacements.addDeplacement(0, vecteurY * 2);

		if (echiquier.getCase(x - 1, y + vecteurY) != null && !echiquier.getCase(x - 1, y + vecteurY).caseVide())
			deplacements.addDeplacement(-1, vecteurY);

		if (echiquier.getCase(x + 1, y + vecteurY) != null && !echiquier.getCase(x + 1, y + vecteurY).caseVide())
			deplacements.addDeplacement(1, vecteurY);

		return deplacements;

	}

}