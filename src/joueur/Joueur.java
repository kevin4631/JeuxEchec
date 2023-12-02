package joueur;

import echiquier.Echiquier;
import piece.enumPackges.Couleur;
import piece.pieceSpeciale.Cavalier;
import piece.pieceSpeciale.Damme;
import piece.pieceSpeciale.Fou;
import piece.pieceSpeciale.Pion;
import piece.pieceSpeciale.Roi;
import piece.pieceSpeciale.Tour;

public abstract class Joueur {
	private Couleur couleur;
	private Echiquier echiquier;

	protected Joueur(Couleur couleur, Echiquier echiquier) {
		this.couleur = couleur;
		this.echiquier = echiquier;

		initialiserPion();
		initialiserTour();
		initialiserCavalier();
		initialiserFou();
		initialiserDamme();
		initialiserRoi();
	}

	private void initialiserPion() {
		int y = couleur == Couleur.BLANC ? 1 : 6;

		for (int x = 0; x < 8; x++) {
			echiquier.ajouterPiece(x, y, new Pion(couleur));
		}
	}

	private void initialiserTour() {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		echiquier.ajouterPiece(0, y, new Tour(couleur));
		echiquier.ajouterPiece(7, y, new Tour(couleur));
	}

	private void initialiserCavalier() {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		echiquier.ajouterPiece(1, y, new Cavalier(couleur));
		echiquier.ajouterPiece(6, y, new Cavalier(couleur));
	}

	private void initialiserFou() {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		echiquier.ajouterPiece(2, y, new Fou(couleur));
		echiquier.ajouterPiece(5, y, new Fou(couleur));
	}

	private void initialiserDamme() {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		echiquier.ajouterPiece(4, y, new Damme(couleur));
	}

	private void initialiserRoi() {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		echiquier.ajouterPiece(3, y, new Roi(couleur));
	}

	public Couleur getCouleur() {
		return couleur;
	}

}
