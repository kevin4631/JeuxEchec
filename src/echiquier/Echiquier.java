package echiquier;

import java.util.ArrayList;
import java.util.List;

import joueur.Joueur;
import piece.Couleur;
import piece.Piece;
import piece.pieceSpeciale.Cavalier;
import piece.pieceSpeciale.Damme;
import piece.pieceSpeciale.Fou;
import piece.pieceSpeciale.Pion;
import piece.pieceSpeciale.Roi;
import piece.pieceSpeciale.Tour;

public class Echiquier {

	private List<List<Case>> tableuCase;
	private Joueur joueurBlanc;
	private Joueur joueurNoir;

	public Echiquier() {
		this.tableuCase = new ArrayList<>();
	}

	public void initialiserEchiquier() {

		initialiserCase();

		initialiserPion(Couleur.BLANC);
		initialiserPion(Couleur.NOIR);

		initialiserTour(Couleur.BLANC);
		initialiserTour(Couleur.NOIR);

		initialiserCavalier(Couleur.BLANC);
		initialiserCavalier(Couleur.NOIR);

		initialiserFou(Couleur.BLANC);
		initialiserFou(Couleur.NOIR);

		initialiserDamme(Couleur.BLANC);
		initialiserDamme(Couleur.NOIR);

		initialiserRoi(Couleur.BLANC);
		initialiserRoi(Couleur.NOIR);
	}

	private void initialiserCase() {
		for (int y = 0; y < 8; y++) {
			tableuCase.add(new ArrayList<>());
			for (int x = 0; x < 8; x++) {
				tableuCase.get(y).add(new Case(x, y));
			}
		}
	}

	private void initialiserPion(Couleur couleur) {
		int y = couleur == Couleur.BLANC ? 1 : 6;

		for (int x = 0; x < 8; x++) {
			ajouterPiece(x, y, new Pion(couleur));
		}
	}

	private void initialiserTour(Couleur couleur) {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		ajouterPiece(0, y, new Tour(couleur));
		ajouterPiece(7, y, new Tour(couleur));
	}

	private void initialiserCavalier(Couleur couleur) {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		ajouterPiece(1, y, new Cavalier(couleur));
		ajouterPiece(6, y, new Cavalier(couleur));
	}

	private void initialiserFou(Couleur couleur) {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		ajouterPiece(2, y, new Fou(couleur));
		ajouterPiece(5, y, new Fou(couleur));
	}

	private void initialiserDamme(Couleur couleur) {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		ajouterPiece(4, y, new Damme(couleur));
	}

	private void initialiserRoi(Couleur couleur) {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		ajouterPiece(3, y, new Roi(couleur));
	}

	private void ajouterPiece(int x, int y, Piece piece) {
		tableuCase.get(y).get(x).assignerPiece(piece);
	}

	public Case getCase(int x, int y) {
		if (!inEchiquier(x, y))
			return null;
		return tableuCase.get(y).get(x);
	}

	public Joueur getJoueurBlanc() {
		return joueurBlanc;
	}

	public Joueur getJoueurNoir() {
		return joueurNoir;
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
		return getCase(x, y).caseVide();
	}

	public Couleur getCouleurPiece(int x, int y) {
		return getCase(x, y).getCouleurPiece();
	}

}
