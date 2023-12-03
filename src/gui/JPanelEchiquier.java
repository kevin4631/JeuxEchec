package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import echiquier.Case;
import echiquier.ICoordonee;
import piece.ListDeplacement;
import piece.enumPackges.Couleur;

public class JPanelEchiquier extends JPanel {

	private List<List<JPanelCase>> listJPanelCase;

	private Color couleurBlanc = Color.decode("#FAFAFA");
	private Color couleurNoir = Color.decode("#ABABAB");
	private Color couleurSelectionBlanc = Color.decode("#92E4FF");
	private Color couleurSelectionNoir = Color.decode("#527E8D");

	private boolean actionEnCours = false;
	private JPanelCase JPanelcaseSelection;
	private ListDeplacement caseDestinationPossible;
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
				int y = convertPixelInCoordonnee(e.getY());

				if (!actionEnCours) {
					actionSelectionPion(x, y, couleurJoueurEnCours(tourJoueurBlanc));
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

	private void actionSelectionPion(int x, int y, Couleur CouleurJoueur) {
		actionEnCours = true;

		Case caseSelection = Main.echiquier.getCase(x, y);

		if (!caseSelection.isVide() && caseSelection.getCouleurPiece() == CouleurJoueur) {
			JPanelcaseSelection = listJPanelCase.get(y).get(x);

			caseDestinationPossible = caseSelection.getDeplacementPiece(Main.echiquier);
			paintBackgroundCases(true);
		} else {
			actionEnCours = false;
		}
	}

	private void actionSelectionCaseDestination(int x, int y) {
		Case caseSelection = Main.echiquier.getCase(JPanelcaseSelection.getJPanelCaseX(),
				JPanelcaseSelection.getJPanelCaseY());

		Case caseDestination = Main.echiquier.getCase(x, y);

		if (caseDestinationPossible.contientCaseDestination(caseDestination)) {
			Main.echiquier.move(caseSelection, caseDestination);
			tourJoueurBlanc = !tourJoueurBlanc;
		}

		paintBackgroundCases(false);
		actionEnCours = false;
		JPanelcaseSelection = null;
		caseDestinationPossible = null;
	}

	private void paintBackgroundCases(Boolean paint) {

		JPanelcaseSelection.paintBackground(paint);

		for (ICoordonee coordonee : caseDestinationPossible.getListDeplacement()) {
			JPanelCase c = listJPanelCase.get(coordonee.getY()).get(coordonee.getX());
			c.paintBackground(paint);
		}

	}

	private int convertPixelInCoordonnee(int pixel) {
		return 7 - pixel / (getHeight() / Main.nbCaseLongeur);
	}

	private Couleur couleurJoueurEnCours(Boolean bool) {
		return bool ? Couleur.BLANC : Couleur.NOIR;
	}

}
