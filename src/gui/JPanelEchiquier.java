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

		setLayout(new GridLayout(8, 8));

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
					actionEnCours = true;
					Case caseSelection = Main.echiquier.getCase(x, y);
					if (!caseSelection.isVide()) {
						JPanelcaseSelection = listJPanelCase.get(y).get(x);

						deplacementPossible = caseSelection.getPiece().getDeplacement(Main.echiquier, x, y);

						paintCasesSelection(deplacementPossible, x, y, true);
					} else {
						actionEnCours = false;
					}

				} else {
					Case caseSelection = Main.echiquier.getCase(JPanelcaseSelection.getJPanelCaseX(),
							JPanelcaseSelection.getJPanelCaseY());

					Case caseDestination = Main.echiquier.getCase(x, y);

					if (deplacementPossible.contientDestination(caseSelection, caseDestination)) {
						Main.echiquier.move(caseSelection, caseDestination);
					}

					paintCasesSelection(deplacementPossible, x, y, false);
					actionEnCours = false;
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

	private void paintCasesSelection(Deplacement deplacementPossible, int x, int y, Boolean paint) {
		Iterator<Vecteur> iterator = deplacementPossible.iterator();

		if (paint)
			JPanelcaseSelection.setBackground(JPanelcaseSelection.getCouleurSelection());
		else
			JPanelcaseSelection.setBackground(JPanelcaseSelection.getCouleur());

		while (iterator.hasNext()) {
			Vecteur v = iterator.next();

			if (paint) {
				JPanelCase c = listJPanelCase.get(y + v.getY()).get(x + v.getX());
				c.setBackground(c.getCouleurSelection());

			} else {
				JPanelCase c = listJPanelCase.get(JPanelcaseSelection.getJPanelCaseY() + v.getY())
						.get(JPanelcaseSelection.getJPanelCaseX() + v.getX());
				c.setBackground(c.getCouleur());
			}
		}

	}

	private int convertPixelInCoordonnee(int pixel) {
		return pixel / (getHeight() / Main.nbCaseLongeur);
	}

}
