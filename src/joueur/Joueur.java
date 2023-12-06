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
	private List<Piece> piecesMorte = new ArrayList<>(16);
	private int indexPM = 0;

	protected Joueur(Couleur couleur, Echiquier echiquier) {
		this.couleur = couleur;
		this.echiquier = echiquier;

		initialiserPion();
		initialiserTour();
		initialiserCavalier();
		initialiserFou();
		initialiserDamme();
		initialiserRoi();
		initListPiecesMorte();
	}

	private void initListPiecesMorte() {
		for (int i = 0; i < 16; i++) {
			piecesMorte.add(null);
		}
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

	public Couleur getCouleur() {
		return couleur;
	}

	public List<Piece> getListPiece() {
		return listPiece;
	}

	public Roi getRoi() {
		return roi;
	}

	public void ajouterPieceMorte(Piece p) {
		piecesMorte.add(indexPM++, p);
	}

	public List<Piece> getPiecesMorte() {
		return piecesMorte;
	}
}
