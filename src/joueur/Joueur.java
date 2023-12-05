package joueur;

import java.util.ArrayList;
import java.util.List;

import echiquier.Echiquier;
import piece.Piece;
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
	private Roi roi;
	private List<Piece> listPiece = new ArrayList<>();

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
			listPiece.add(new Pion(x, y, couleur));
		}
	}

	private void initialiserTour() {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		listPiece.add(new Tour(0, y, couleur));
		listPiece.add(new Tour(7, y, couleur));
	}

	private void initialiserCavalier() {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		listPiece.add(new Cavalier(1, y, couleur));
		listPiece.add(new Cavalier(6, y, couleur));
	}

	private void initialiserFou() {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		listPiece.add(new Fou(2, y, couleur));
		listPiece.add(new Fou(5, y, couleur));
	}

	private void initialiserDamme() {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		listPiece.add(new Damme(3, y, couleur));
	}

	private void initialiserRoi() {
		int y = couleur == Couleur.BLANC ? 0 : 7;

		roi = new Roi(4, y, couleur);

		listPiece.add(roi);
	}

	public void move(Piece piece, int destinationX, int destinationY) {
		if (piece.getClass() == Pion.class) {
			((Pion) piece).premierTourFalse();
		}

		if (!echiquier.caseVide(destinationX, destinationY)) {
			Piece p = echiquier.getPiece(destinationX, destinationY);
			listPiece.remove(p);
		}

		echiquier.getTableuPiece().get(piece.getY()).set(piece.getX(), null);
		piece.setXY(destinationX, destinationY);
		echiquier.getTableuPiece().get(destinationY).set(destinationX, piece);
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public List<Piece> getListPiece() {
		return listPiece;
	}

	public List<Piece> piecesEnVie() {
		return listPiece;
	}

	public Roi getRoi() {
		return roi;
	}
}
