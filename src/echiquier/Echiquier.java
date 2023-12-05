package echiquier;

import java.util.ArrayList;
import java.util.List;

import joueur.Joueur;
import joueur.JoueurBlanc;
import joueur.JoueurNoir;
import piece.ListElementICoordonee;
import piece.Piece;
import piece.pieceSpeciale.Roi;

public class Echiquier {

	private List<List<Piece>> tableuPiece = new ArrayList<>();
	private JoueurBlanc joueurBlanc;
	private JoueurNoir joueurNoir;

	public Echiquier() {
		joueurBlanc = new JoueurBlanc(this);
		joueurNoir = new JoueurNoir(this);

		initialiserCase(joueurBlanc, joueurNoir);
	}

	private void initialiserCase(Joueur joueurBlanc, Joueur joueurNoir) {
		for (int y = 0; y < 8; y++) {
			tableuPiece.add(new ArrayList<>());
			for (int x = 0; x < 8; x++) {
				tableuPiece.get(y).add(null);
			}
		}

		for (Piece p : joueurBlanc.getListPiece()) {
			tableuPiece.get(p.getY()).set(p.getX(), p);
		}

		for (Piece p : joueurNoir.getListPiece()) {
			tableuPiece.get(p.getY()).set(p.getX(), p);
		}
	}

	public Boolean inEchec(Joueur joueur) {
		ListElementICoordonee casesControleAdverse = new ListElementICoordonee();
		Roi roi = joueur.getRoi();

		for (Piece p : joueur.piecesEnVie()) {
			casesControleAdverse.add(p.getDeplacement(this));
		}

		for (ICoordonee c : casesControleAdverse.getListElement()) {
			if (c.getX() == roi.getX() && c.getY() == roi.getY())
				return true;
		}
		return false;
	}

	public Boolean inEchiquier(int x, int y) {
		return !(x < 0 || x > 7 || y < 0 || y > 7);
	}

	public Piece getPiece(int x, int y) {
		if (!inEchiquier(x, y))
			return null;
		return tableuPiece.get(y).get(x);
	}

	public Boolean caseVide(int x, int y) {
		return getPiece(x, y) == null;
	}

	public List<List<Piece>> getTableuPiece() {
		return tableuPiece;
	}

	public JoueurBlanc getJoueurBlanc() {
		return joueurBlanc;
	}

	public JoueurNoir getJoueurNoir() {
		return joueurNoir;
	}

	public void afficher() {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				Piece piece = tableuPiece.get(y).get(x);
				if (piece == null)
					System.out.print(" |");
				else
					System.out.print(piece.getNomPiece().diminutif() + "|");
			}
			System.out.println("");
		}
	}


}
