package echiquier;

import java.util.ArrayList;
import java.util.List;

import piece.ListDeplacement;
import piece.Piece;
import piece.enumPackges.Couleur;
import piece.enumPackges.Direction;
import piece.pieceSpeciale.Pion;

public class Echiquier {

	private List<List<Case>> tableuCase;

	public Echiquier() {
		this.tableuCase = new ArrayList<>();
		initialiserCase();
	}

	private void initialiserCase() {
		for (int y = 0; y < 8; y++) {
			tableuCase.add(new ArrayList<>());
			for (int x = 0; x < 8; x++) {
				tableuCase.get(y).add(new Case(x, y));
			}
		}
	}

	public void ajouterPiece(int x, int y, Piece piece) {
		tableuCase.get(y).get(x).assignerPiece(piece);
	}

	public Case getCase(int x, int y) {
		if (!inEchiquier(x, y))
			return null;
		return tableuCase.get(y).get(x);
	}

	public void move(Case selection, Case destination) {
		if (selection.getPiece().getClass() == Pion.class) {
			Pion p = (Pion) selection.getPiece();
			p.premierTourFalse();
		}

		destination.assignerPiece(selection.popPiece());
	}

	public Boolean inEchiquier(int x, int y) {
		return !(x < 0 || x > 7 || y < 0 || y > 7);

	}

	public Boolean isCaseVide(int x, int y) {
		return getCase(x, y).isVide();
	}

	public Couleur getCouleurPiece(int x, int y) {
		return getCase(x, y).getCouleurPiece();
	}

	public ListDeplacement caseDestinationInDirection(int x, int y, Direction vecteur) {
		ListDeplacement deplacements = new ListDeplacement();

		int vx = vecteur.getX();
		int vy = vecteur.getY();

		while (inEchiquier(x + vx, y + vy) && isCaseVide(x + vx, y + vy)) {
			deplacements.add(new Case(x + vx, y + vy));
			vy += vecteur.getY();
			vx += vecteur.getX();
		}

		if (inEchiquier(x + vx, y + vy) && getCouleurPiece(x + vx, y + vy) != getCase(x, y).getCouleurPiece()) {
			deplacements.add(new Case(x + vx, y + vy));
		}

		return deplacements;
	}

}
