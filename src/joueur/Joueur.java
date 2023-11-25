package joueur;

import java.util.ArrayList;
import java.util.List;

import piece.Couleur;
import piece.Piece;
import piece.pieceSpeciale.Cavalier;
import piece.pieceSpeciale.Damme;
import piece.pieceSpeciale.Fou;
import piece.pieceSpeciale.Pion;
import piece.pieceSpeciale.Roi;
import piece.pieceSpeciale.Tour;
import utils.Coordonnees;

public abstract class Joueur {
	private Couleur couleur;
	private List<Piece> listPiece = new ArrayList<>();

	protected Joueur(Couleur couleur) {
		this.couleur = couleur;
		initPieces();
	}

	private void initPieces() {

		int y = couleur == Couleur.BLANC ? 0 : 7;
		int yPion = couleur == Couleur.BLANC ? 1 : 6;

		for (int x = 0; x < 8; x++)
			listPiece.add(new Pion(couleur, new Coordonnees(x, yPion)));

		listPiece.add(new Tour(couleur, new Coordonnees(0, y)));
		listPiece.add(new Tour(couleur, new Coordonnees(7, y)));
		listPiece.add(new Cavalier(couleur, new Coordonnees(1, y)));
		listPiece.add(new Cavalier(couleur, new Coordonnees(6, y)));
		listPiece.add(new Fou(couleur, new Coordonnees(2, y)));
		listPiece.add(new Fou(couleur, new Coordonnees(5, y)));
		listPiece.add(new Damme(couleur, new Coordonnees(3, y)));
		listPiece.add(new Roi(couleur, new Coordonnees(4, y)));
	}

	public List<Piece> getListPiece() {
		return listPiece;
	}

	public Couleur getCouleur() {
		return couleur;
	}

}
