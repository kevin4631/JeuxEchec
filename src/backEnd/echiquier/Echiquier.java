package backEnd.echiquier;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import backEnd.ICoordonee;
import backEnd.ListElementICoordonee;
import backEnd.joueur.Joueur;
import backEnd.joueur.JoueurBlanc;
import backEnd.joueur.JoueurNoir;
import backEnd.piece.Piece;
import backEnd.piece.allPiece.Damme;
import backEnd.piece.allPiece.Pion;
import backEnd.piece.allPiece.Roi;
import backEnd.piece.enumPackges.Couleur;
import gui.Main;

public class Echiquier {

	private List<List<Piece>> tableuPiece;
	private JoueurBlanc joueurBlanc;
	private JoueurNoir joueurNoir;
	private Joueur joueurEnCours;

	public Echiquier() {

		initialiserEchiquier();

	}

	public void initialiserEchiquier() {
		tableuPiece = new ArrayList<>();
		joueurBlanc = new JoueurBlanc(this);
		joueurNoir = new JoueurNoir(this);
		joueurEnCours = joueurBlanc;
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

	public void move(Piece piece, int destinationX, int destinationY) {
		if (piece.getClass() == Pion.class) {
			((Pion) piece).premierTourFalse();
		}

		if (!caseVide(destinationX, destinationY)) {
			Piece p = getPiece(destinationX, destinationY);
			if (p.getCouleur() == Couleur.BLANC) {
				joueurBlanc.getListPiece().remove(p);
				joueurBlanc.ajouterPieceMorte(p);
			} else {
				joueurNoir.getListPiece().remove(p);
				joueurNoir.ajouterPieceMorte(p);
			}
		}

		getTableuPiece().get(piece.getY()).set(piece.getX(), null);
		piece.setXY(destinationX, destinationY);
		getTableuPiece().get(destinationY).set(destinationX, piece);

		promotionEnReine(piece, destinationX, destinationY);

		if (inEchec(joueurBlanc)) {
			System.out.println("blanc echec");
			JOptionPane.showMessageDialog(Main.gui, "Le roi est en échec!");
		}

		System.out.println(inEchec(joueurNoir));
	}

	private void promotionEnReine(Piece piece, int destinationX, int destinationY) {
		int y = piece.getCouleur() == Couleur.BLANC ? 7 : 0;
		if (destinationY == y && piece.getClass() == Pion.class) {
			Damme damme = new Damme(destinationX, destinationY, piece.getCouleur());

			joueurEnCours.getListPiece().remove(piece);
			joueurEnCours.getListPiece().add(damme);

			getTableuPiece().get(destinationY).set(destinationX, damme);

		}
	}

	public Boolean inEchec(Joueur joueur) {
		ListElementICoordonee casesControleAdverse = new ListElementICoordonee();
		Roi roi = joueur.getRoi();

		for (Piece p : joueurAdverse(joueur).getListPiece()) {
			casesControleAdverse.add(p.getDeplacement(this));
		}


		for (ICoordonee c : casesControleAdverse.getListElement()) {
			if (c.getX() == roi.getX() && c.getY() == roi.getY())
				return true;
		}
		return false;
	}

	public Boolean inMat(Joueur joueur) {



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

	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}

	public Joueur joueurAdverse(Joueur joueur) {
		if (joueur == joueurBlanc)
			return joueurNoir;
		return joueurBlanc;
	}

	public void auJoueurSuivant() {
		joueurEnCours = joueurEnCours == joueurBlanc ? joueurNoir : joueurBlanc;
	}

	public Boolean pieceAppartientJoeurEnCours(Piece piece) {
		return piece != null && piece.getCouleur() == joueurEnCours.getCouleur();
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
