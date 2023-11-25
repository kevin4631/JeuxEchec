package piece.pieceSpeciale;

import java.util.ArrayList;
import java.util.List;

import echiquier.Echiquier;
import piece.Couleur;
import piece.NomPiece;
import piece.Piece;
import utils.Coordonnees;

public class Pion extends Piece {

	private boolean premierTour = true;

	public Pion(Couleur couleur, Coordonnees coordonnees) {
		super(couleur, NomPiece.PION, coordonnees);
	}

	public List<Coordonnees> deplacementPossible(int x, int y, Echiquier echiquier) {
		List<Coordonnees> listCoordonnees = new ArrayList<>();

		listCoordonnees.add(new Coordonnees(x, y + 1));

		if (premierTour)
			listCoordonnees.add(new Coordonnees(x, y + 2));

		if (!echiquier.getCase(x + 1, y + 1).caseVide())
			listCoordonnees.add(new Coordonnees(x + 1, y + 1));

		if (!echiquier.getCase(x - 1, y + 1).caseVide())
			listCoordonnees.add(new Coordonnees(x - 1, y + 1));

		return listCoordonnees;
	}

}