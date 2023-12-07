package backEnd.joueur;

import java.util.ArrayList;
import java.util.List;

import backEnd.enumPackges.ECouleur;
import backEnd.piece.Piece;
import backEnd.piece.allPiece.Cavalier;
import backEnd.piece.allPiece.Damme;
import backEnd.piece.allPiece.Fou;
import backEnd.piece.allPiece.Pion;
import backEnd.piece.allPiece.Roi;
import backEnd.piece.allPiece.Tour;

public abstract class Joueur {

	private ECouleur couleur;
	private Roi roi;
	private List<Piece> listPiece = new ArrayList<>();
	private List<Piece> piecesMorte = new ArrayList<>();
	private int indexPM = 0;

	protected Joueur(ECouleur couleur) {
		this.couleur = couleur;

		initialiserPion();
		initialiserTour();
		initialiserCavalier();
		initialiserFou();
		initialiserDamme();
		initialiserRoi();
		initListPiecesMorte();
	}

	protected Joueur(Joueur ancienJour) {

		this.couleur = ancienJour.getCouleur() == ECouleur.BLANC ? ECouleur.BLANC : ECouleur.NOIR;

		for (Piece p : ancienJour.getListPiece()) {
			Class<? extends Piece> typeClass = p.getClass();

			if (typeClass == Pion.class) {
				listPiece.add(new Pion(p.getX(), p.getY(), couleur));
			} else if (typeClass == Tour.class) {
				listPiece.add(new Tour(p.getX(), p.getY(), couleur));
			} else if (typeClass == Cavalier.class) {
				listPiece.add(new Cavalier(p.getX(), p.getY(), couleur));
			} else if (typeClass == Fou.class) {
				listPiece.add(new Fou(p.getX(), p.getY(), couleur));
			} else if (typeClass == Damme.class) {
				listPiece.add(new Damme(p.getX(), p.getY(), couleur));
			} else if (typeClass == Roi.class) {
				this.roi = new Roi(p.getX(), p.getY(), couleur);
				listPiece.add(roi);
			}
		}
	}

	private void initialiserPion() {
		int y = couleur == ECouleur.BLANC ? 1 : 6;

		for (int x = 0; x < 8; x++) {
			listPiece.add(new Pion(x, y, couleur));
		}
	}

	private void initialiserTour() {
		int y = couleur == ECouleur.BLANC ? 0 : 7;

		listPiece.add(new Tour(0, y, couleur));
		listPiece.add(new Tour(7, y, couleur));
	}

	private void initialiserCavalier() {
		int y = couleur == ECouleur.BLANC ? 0 : 7;

		listPiece.add(new Cavalier(1, y, couleur));
		listPiece.add(new Cavalier(6, y, couleur));
	}

	private void initialiserFou() {
		int y = couleur == ECouleur.BLANC ? 0 : 7;

		listPiece.add(new Fou(2, y, couleur));
		listPiece.add(new Fou(5, y, couleur));
	}

	private void initialiserDamme() {
		int y = couleur == ECouleur.BLANC ? 0 : 7;

		listPiece.add(new Damme(3, y, couleur));
	}

	private void initialiserRoi() {
		int y = couleur == ECouleur.BLANC ? 0 : 7;

		roi = new Roi(4, y, couleur);

		listPiece.add(roi);
	}

	private void initListPiecesMorte() {
		for (int i = 0; i < 16; i++) {
			piecesMorte.add(null);
		}
	}

	public void addPiece(Piece piece) {
		listPiece.add(piece);
	}

	public void removePiece(Piece piece) {
		listPiece.remove(piece);
	}

	public ECouleur getCouleur() {
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

	public List<Piece> getlistPieceMorte() {
		return piecesMorte;
	}
}