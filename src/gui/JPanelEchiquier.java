package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import echiquier.Case;
import piece.Deplacement;
import piece.Vecteur;

public class JPanelEchiquier extends JPanel {

	private List<List<JPanelCase>> listJPanelCase;

	private Color couleurBlanc = Color.decode("#FAFAFA");
	private Color couleurNoir = Color.decode("#ABABAB");
	private Color couleurSelectionBlanc = Color.decode("#92E4FF");
	private Color couleurSelectionNoir = Color.decode("#527E8D");

	private boolean actionEnCours = false;
	private JPanelCase JPanelcaseSelection;
	private Deplacement deplacementPossible;

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
														 couleur ? couleurSelectionBlanc : couleurSelectionNoir,
														 x,
														 y));
				add(listJPanelCase.get(y).get(x));
			}
		}
	}

	private void addMouseListener() {

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

				int x = convertPixelInCoordonnee(e.getX());
				int y = convertPixelInCoordonnee(e.getY());

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

		Case caseSelection = Main.echiquier.getCase(x, y);

		if (!caseSelection.isVide()) {
			JPanelcaseSelection = listJPanelCase.get(y).get(x);

			deplacementPossible = caseSelection.getDeplacementPiece(Main.echiquier);
			paintBackgroundCases(deplacementPossible, x, y, true);
		} else {
			actionEnCours = false;
		}
	}

	private void actionSelectionCaseDestination(int x, int y) {
		Case caseSelection = Main.echiquier.getCase(JPanelcaseSelection.getJPanelCaseX(),
				JPanelcaseSelection.getJPanelCaseY());

		Case caseDestination = Main.echiquier.getCase(x, y);

		if (deplacementPossible.contientDestination(caseSelection, caseDestination)) {
			Main.echiquier.move(caseSelection, caseDestination);
		}

		paintBackgroundCases(deplacementPossible, JPanelcaseSelection.getJPanelCaseX(),
				JPanelcaseSelection.getJPanelCaseY(), false);
		actionEnCours = false;
		JPanelcaseSelection = null;
		deplacementPossible = null;
	}

	private void paintBackgroundCases(Deplacement deplacementPossible, int x, int y, Boolean paint) {
		Iterator<Vecteur> iterator = deplacementPossible.iterator();

		JPanelcaseSelection.paintBackground(paint);

		while (iterator.hasNext()) {
			Vecteur v = iterator.next();

			JPanelCase c = listJPanelCase.get(y + v.getY()).get(x + v.getX());
			c.paintBackground(paint);
		}

	}

	private int convertPixelInCoordonnee(int pixel) {
		return pixel / (getHeight() / Main.nbCaseLongeur);
	}

}
