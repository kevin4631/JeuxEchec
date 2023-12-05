package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import echiquier.ICoordonee;
import joueur.Joueur;
import piece.ListElementICoordonee;
import piece.Piece;

public class JPanelEchiquier extends JPanel {

	private List<List<JPanelCase>> listJPanelCase;

	private Color couleurBlanc = Color.decode("#FAFAFA");
	private Color couleurNoir = Color.decode("#ABABAB");
	private Color couleurSelectionBlanc = Color.decode("#92E4FF");
	private Color couleurSelectionNoir = Color.decode("#527E8D");

	private boolean actionEnCours = false;
	private JPanelCase JPanelcaseSelection;
	private ListElementICoordonee caseDestinationPossible;
	Boolean tourJoueurBlanc = true;

	public JPanelEchiquier(List<List<JPanelCase>> listJPanelCase) {

		this.listJPanelCase = listJPanelCase;

		setLayout(new GridLayout(Main.nbCaseLongeur, Main.nbCaseLongeur));

		initialisationJPanelCase();
		addMouseListener();
	}

	private void initialisationJPanelCase() {
		Boolean couleur = true;

		for (int y = 0; y < 8; y++) {
			listJPanelCase.add(new ArrayList<>());
			couleur = !couleur;
			for (int x = 0; x < 8; x++) {
				couleur = !couleur;
				listJPanelCase.get(y).add(new JPanelCase(couleur ? couleurBlanc : couleurNoir,
						couleur ? couleurSelectionBlanc : couleurSelectionNoir, x, y));
				add(listJPanelCase.get(y).get(x));
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
					actionSelectionPion(x, y, joueurEnCours(tourJoueurBlanc));
				} else {
					actionSelectionCaseDestination(x, y, joueurEnCours(tourJoueurBlanc));
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

	private void actionSelectionPion(int x, int y, Joueur joueur) {
		actionEnCours = true;

		Piece pieceSelection = Main.echiquier.getPiece(x, y);

		if (pieceSelection != null && pieceSelection.getCouleur() == joueur.getCouleur()) {
			JPanelcaseSelection = listJPanelCase.get(y).get(x);
			caseDestinationPossible = pieceSelection.getDeplacement(Main.echiquier);
			paintBackgroundCases(true);
		} else {
			actionEnCours = false;
		}
	}

	private void actionSelectionCaseDestination(int x, int y, Joueur joueur) {
		Piece pieceSelection = Main.echiquier.getPiece(JPanelcaseSelection.getJPanelCaseX(),
				JPanelcaseSelection.getJPanelCaseY());


		if (caseDestinationPossible.contient(x, y)) {
			joueur.move(pieceSelection, x, y);
			tourJoueurBlanc = !tourJoueurBlanc;
		}

		paintBackgroundCases(false);
		actionEnCours = false;
		JPanelcaseSelection = null;
		caseDestinationPossible = null;
	}

	private void paintBackgroundCases(Boolean paint) {

		JPanelcaseSelection.paintBackground(paint);

		for (ICoordonee coo : caseDestinationPossible.getListElement()) {
			JPanelCase c = listJPanelCase.get(coo.getY()).get(coo.getX());
			c.paintBackground(paint);
		}

	}

	private int convertPixelInCoordonnee(int pixel) {
		return pixel / (getHeight() / Main.nbCaseLongeur);
	}

	private Joueur joueurEnCours(Boolean bool) {
		return bool ? Main.echiquier.getJoueurBlanc() : Main.echiquier.getJoueurNoir();
	}

	public void inEchec() {

	}

}
