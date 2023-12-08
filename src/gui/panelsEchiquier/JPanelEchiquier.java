package gui.panelsEchiquier;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import backEnd.ICoordonee;
import backEnd.ListElementICoordonee;
import backEnd.joueur.Joueur;
import backEnd.piece.Piece;
import gui.Main;
import gui.alerteEchecMate.AlerteRoiEchec;
import gui.alerteEchecMate.AlerteRoiEchecMat;

public class JPanelEchiquier extends JPanel {

	private List<List<JPanelCase>> listJPanelCase;

	private Color couleurBlanc = Color.PINK;
	private Color couleurNoir = Color.DARK_GRAY;

	private Color couleurSelectionBlanc = Color.decode("#92E4FF");
	private Color couleurSelectionNoir = Color.decode("#527E8D");

	private boolean actionEnCours;
	private JPanelCase JPanelcaseSelection;
	private ListElementICoordonee listCoordonneePossible;


	public JPanelEchiquier(List<List<JPanelCase>> listJPanelCase) {

		this.listJPanelCase = listJPanelCase;

		setLayout(new GridLayout(Main.nbCaseLongeur, Main.nbCaseLongeur));

		initParametreSelection();
		initialisationJPanelCase();
		addMouseListener();
	}

	public void initParametreSelection() {
		if (listCoordonneePossible != null)
			paintBackgroundCases(false);
		actionEnCours = false;
		JPanelcaseSelection = null;
		listCoordonneePossible = null;
	}

	private void initialisationJPanelCase() {
		Boolean couleur = true;

		for (int y = 0; y < 8; y++) {
			listJPanelCase.add(new ArrayList<>());
			couleur = !couleur;
			for (int x = 0; x < 8; x++) {
				couleur = !couleur;
				JPanelCase panelCase = new JPanelCase(
						couleur ? couleurBlanc : couleurNoir,
						couleur ? couleurSelectionBlanc : couleurSelectionNoir, 
						x,
						y);
				listJPanelCase.get(y).add(panelCase);
				add(panelCase);
			}
		}
	}

	public void addMouseListener() {
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {

			}
			@Override
			public void mousePressed(MouseEvent e) {

				int x = convertPixelInCoordonnee(e.getX());
				int y = 7 - convertPixelInCoordonnee(e.getY());

				if (!actionEnCours) {
					actionSelectionPion(x, y);
				} else {
					actionSelectionCaseDestination(x, y);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
			@Override
			public void mouseEntered(MouseEvent e) {

			}
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

	}

	private void actionSelectionPion(int x, int y) {
		actionEnCours = true;

		Piece pieceSelection = Main.echiquier.getPiece(x, y);

		if (Main.echiquier.pieceAppartientJoeurEnCours(pieceSelection)) {
			JPanelcaseSelection = listJPanelCase.get(y).get(x);
			listCoordonneePossible = pieceSelection.getDeplacement(Main.echiquier);
			paintBackgroundCases(true);
		} else {
			actionEnCours = false;
		}
	}

	private void actionSelectionCaseDestination(int x, int y) {
		Piece pieceSelection = Main.echiquier.getPiece(JPanelcaseSelection.getPositionX(),
				JPanelcaseSelection.getPositionY());

		Boolean deplacementValide = false;

		if (listCoordonneePossible.contient(x, y))
			deplacementValide = Main.echiquier.move(pieceSelection, x, y);

		initParametreSelection();

		if (deplacementValide) {
			Main.gui.repaintIconMort();
			afficherPopUpEchecMat(Main.echiquier.getJoueurBlanc());
			afficherPopUpEchecMat(Main.echiquier.getJoueurNoir());
		}
	}

	private void afficherPopUpEchecMat(Joueur joueur) {
		switch (Main.echiquier.inEchecMat(joueur)) {
			case 1:
				new AlerteRoiEchec(joueur.getCouleur());
				break;
			case 2:
				new AlerteRoiEchecMat(joueur.getCouleur());
				break;
		}
	}

	private void paintBackgroundCases(Boolean paint) {
		JPanelcaseSelection.paintBackground(paint);

		for (ICoordonee coo : listCoordonneePossible.getListElement()) {
			JPanelCase c = listJPanelCase.get(coo.getY()).get(coo.getX());
			c.paintBackground(paint);
		}
	}

	private int convertPixelInCoordonnee(int pixel) {
		return pixel / (getHeight() / Main.nbCaseLongeur);
	}

	public void reinitialiser() {
		initParametreSelection();
		repaint();
	}

}