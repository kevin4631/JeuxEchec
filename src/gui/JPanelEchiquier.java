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
import piece.DeplacementPosible;
import piece.Vecteur;

public class JPanelEchiquier extends JPanel {

	private List<List<JPanelCase>> listJPanelCase;

	private Color couleurBlanc = Color.decode("#FAFAFA");
	private Color couleurNoir = Color.decode("#ABABAB");
	private Color couleurSelectionBlanc = Color.decode("#92E4FF");
	private Color couleurSelectionNoir = Color.decode("#527E8D");

	private boolean actionEnCours = false;
	private JPanelCase JPanelcaseSelection;
	private DeplacementPosible deplacementEnCours;

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
					
					int x = e.getX() / (getHeight() / 8);
					int y = e.getY() / (getHeight() / 8);

					Case caseSelection = Main.echiquier.getCase(x, y);
					
					if (!actionEnCours) {
						actionEnCours = true;

						if (!caseSelection.caseVide()) {

							deplacementEnCours = caseSelection.getPiece().getDeplacement(Main.echiquier, x, y);

							Iterator<Vecteur> iterator = deplacementEnCours.iterator();

							while (iterator.hasNext()) {
								Vecteur v = iterator.next();
								JPanelCase c = listJPanelCase.get(y + v.getY()).get(x + v.getX());
								c.setBackground(c.getCouleurSelection());
							}

							JPanelcaseSelection = listJPanelCase.get(y).get(x);
							JPanelcaseSelection.setBackground(JPanelcaseSelection.getCouleurSelection());
						} else {
							actionEnCours = false;
						}
					} else {
						
						Main.echiquier.move(Main.echiquier.getCase(JPanelcaseSelection.getJPanelCaseX(), 
																					JPanelcaseSelection.getJPanelCaseY())
																					, caseSelection);
						
						JPanelcaseSelection.setBackground(JPanelcaseSelection.getCouleur());

						Iterator<Vecteur> iterator = deplacementEnCours.iterator();
						while (iterator.hasNext()) {
							Vecteur v = iterator.next();
							JPanelCase c = listJPanelCase.get(JPanelcaseSelection.getJPanelCaseY() + v.getY())
									.get(JPanelcaseSelection.getJPanelCaseX() + v.getX());
							c.setBackground(c.getCouleur());

						}
						
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
}
