package echiquier;

import java.util.ArrayList;
import java.util.List;

import piece.Deplacement;
import piece.Piece;
import piece.Vecteur;
import piece.enumPackges.Couleur;
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

	public void move(Case c, Case destination) {
		if (c.getPiece().getClass() == Pion.class) {
			Pion p = (Pion) c.getPiece();
			p.premierTourFalse();
		}

		destination.assignerPiece(c.popPiece());
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

	public Deplacement getDeplacementsInDirection(Case casePiece, Vecteur vecteur) {
		Deplacement deplacements = new Deplacement();

		int x = casePiece.getPossitionX();
		int y = casePiece.getPossitionY();

		int vx = vecteur.getX();
		int vy = vecteur.getY();

		while (inEchiquier(x + vx, y + vy) && isCaseVide(x + vx, y + vy)) {
			deplacements.addDeplacement(vx, vy);
			vy += vecteur.getY();
			vx += vecteur.getX();
		}

		if (inEchiquier(x + vx, y + vy) && getCouleurPiece(x + vx, y + vy) != casePiece.getCouleurPiece()) {
			deplacements.addDeplacement(vx, vy);
		}

		return deplacements;
	}

}
