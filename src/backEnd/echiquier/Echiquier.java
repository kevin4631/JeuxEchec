package backEnd.echiquier;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import backEnd.ICoordonee;
import backEnd.ListElementICoordonee;
import backEnd.enumPackges.ECouleur;
import backEnd.enumPackges.EDirection;
import backEnd.joueur.Joueur;
import backEnd.joueur.JoueurBlanc;
import backEnd.joueur.JoueurNoir;
import backEnd.piece.Piece;
import backEnd.piece.allPiece.Damme;
import backEnd.piece.allPiece.Pion;
import backEnd.piece.allPiece.Roi;
import gui.Main;

public class Echiquier {

	private List<List<Piece>> tableuPiece;
	private JoueurBlanc joueurBlanc;
	private JoueurNoir joueurNoir;
	private Joueur joueurEnCours;

	public Echiquier(JoueurBlanc joueurBlanc, JoueurNoir joueurNoir) {
		this.tableuPiece = new ArrayList<>();
		this.joueurBlanc = joueurBlanc;
		this.joueurNoir = joueurNoir;
		this.joueurEnCours = joueurBlanc;
		initialiserCase(joueurBlanc, joueurNoir);
	}

	public Echiquier(Echiquier echiquier, ICoordonee origine, ICoordonee destination) {

		this.joueurBlanc = new JoueurBlanc(echiquier.getJoueurBlanc());
		this.joueurNoir = new JoueurNoir(echiquier.getJoueurNoir());

		this.joueurEnCours = echiquier.getJoueurEnCours().getCouleur() == ECouleur.BLANC ? this.joueurBlanc
				: this.joueurNoir;

		this.tableuPiece = new ArrayList<>();
		initialiserCase(this.joueurBlanc, this.joueurNoir);
		move2(getPiece(origine.getX(), origine.getY()), destination.getX(), destination.getY());
	}

	private void initialiserCase(Joueur joueurBlanc, Joueur joueurNoir) {
		for (int y = 0; y < 8; y++) {
			tableuPiece.add(new ArrayList<>());
			for (int x = 0; x < 8; x++) {
				tableuPiece.get(y).add(null);
			}
		}

		for (Piece piece : joueurBlanc.getListPiece())
			tableuPiece.get(piece.getY()).set(piece.getX(), piece);

		for (Piece piece : joueurNoir.getListPiece())
			tableuPiece.get(piece.getY()).set(piece.getX(), piece);
	}

	public void move2(Piece piece, int destinationX, int destinationY) {
		if (piece.getClass() == Pion.class) {
			((Pion) piece).premierTourFalse();
		}

		if (!caseVide(destinationX, destinationY)) {
			Piece p = getPiece(destinationX, destinationY);
			joueurEnCours.removePiece(p);
			joueurEnCours.ajouterPieceMorte(p);
		}

		getTableuPiece().get(piece.getY()).set(piece.getX(), null);
		piece.setXY(destinationX, destinationY);
		getTableuPiece().get(destinationY).set(destinationX, piece);

		promotionEnReine(piece, destinationX, destinationY);

	}

	public void move(Piece piece, int destinationX, int destinationY) {
		if (piece.getClass() == Pion.class) {
			((Pion) piece).premierTourFalse();
		}

		if (!caseVide(destinationX, destinationY)) {
			Piece p = getPiece(destinationX, destinationY);
			joueurEnCours.removePiece(p);
			joueurEnCours.ajouterPieceMorte(p);
		}


		getTableuPiece().get(piece.getY()).set(piece.getX(), null);
		piece.setXY(destinationX, destinationY);
		getTableuPiece().get(destinationY).set(destinationX, piece);

		promotionEnReine(piece, destinationX, destinationY);

		int opt = inEchecMat(joueurBlanc);
		if (opt!=0) {
			JOptionPane.showMessageDialog(Main.gui, opt);
		}
	}

	private void promotionEnReine(Piece piece, int destinationX, int destinationY) {
		int lastLigne = piece.getCouleur() == ECouleur.BLANC ? 7 : 0;

		if (destinationY == lastLigne && piece.getClass() == Pion.class) {
			Damme damme = new Damme(destinationX, destinationY, piece.getCouleur());

			joueurEnCours.removePiece(piece);
			joueurEnCours.addPiece(damme);

			getTableuPiece().get(destinationY).set(destinationX, damme);
		}
	}

	public Boolean inEchec(Joueur joueur) {
		ListElementICoordonee casesControleAdverse = new ListElementICoordonee();
		Roi roi = joueur.getRoi();

		for (Piece p : joueurAdverse(joueur).getListPiece()) {
			casesControleAdverse.add(p.getDeplacement(this));
		}

		// en echec le roi ce trouve sur une case controler adverse
		return roiInCasesControleAdverse(casesControleAdverse, roi);
	}


	public int inEchecMat(Joueur joueur) {
		ListElementICoordonee casesControleAdverse = new ListElementICoordonee();
		Roi roi = joueur.getRoi();
		int para = 0;

		for (Piece p : joueurAdverse(joueur).getListPiece()) {
			casesControleAdverse.add(p.getDeplacement(this));
		}

		// en echec le roi ce trouve sur une case controler adverse
		if (roiInCasesControleAdverse(casesControleAdverse, roi)) {
			para = 1;

			// chaque deplacement du roi ce trouve sur une case adverse
			if (allDeplacementRoiInCasesControleAdverse(casesControleAdverse, roi)) {
				para = 2;
				if (!deplacementChangeEchec(joueur))
					para = 3;
			}
		}

		return para;
	}

	private Boolean roiInCasesControleAdverse(ListElementICoordonee casesControleAdverse, Roi roi) {
		for (ICoordonee c : casesControleAdverse.getListElement()) {
			if (c.getX() == roi.getX() && c.getY() == roi.getY())
				return true;
		}
		return false;
	}

	private Boolean allDeplacementRoiInCasesControleAdverse(ListElementICoordonee casesControleAdverse, Roi roi) {
		for (ICoordonee deplacementRoi : roi.getDeplacement(this).getListElement()) {
			if (!casesControleAdverse.contient(deplacementRoi.getX(), deplacementRoi.getY()))
				return false;
		}
		return true;
	}

	private Boolean deplacementChangeEchec(Joueur joueur) {
		for (Piece p : joueur.getListPiece()) {
			for (ICoordonee deplacement : p.getDeplacement(this).getListElement()) {
				Echiquier echiquierVirtuel = new Echiquier(this, new Coordonee(p.getX(), p.getY()), deplacement);
				if (echiquierVirtuel.inEchec(echiquierVirtuel.getJoueur(joueur.getCouleur())) == false) {
					return true;
				}
			}
		}
		return false;
	}

	public ListElementICoordonee listCoordoneesInDirection(Piece piece, EDirection vecteur) {
		ListElementICoordonee listCoordonee = new ListElementICoordonee();

		int vx = vecteur.getX();
		int vy = vecteur.getY();

		int origineX = piece.getX();
		int origineY = piece.getY();


		while (inEchiquier(origineX + vx, origineY + vy) && caseVide(origineX + vx, origineY + vy)) {
			listCoordonee.add(new Coordonee(origineX + vx, origineX + vy));
			vy += vecteur.getY();
			vx += vecteur.getX();
		}

		Piece pieceD = getPiece(origineX + vx, origineY + vy);
		if (inEchiquier(origineX + vx, origineY + vy) && pieceD != null && pieceD.getCouleur() != piece.getCouleur())
			listCoordonee.add(new Coordonee(origineX + vx, origineY + vy));

		return listCoordonee;
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

	public Joueur getJoueur(ECouleur couleur) {
		return couleur == ECouleur.BLANC ? joueurBlanc : joueurNoir;
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
