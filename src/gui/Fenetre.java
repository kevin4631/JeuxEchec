package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import echiquier.Case;
import echiquier.Echiquier;
import piece.Piece;

public class Fenetre {

	private static int nbCarrelongeur = 8;

	private static Color couleurClaire = Color.decode("#FAFAFA");
	private static Color couleurSombre = Color.decode("#ABABAB");
	private static Case caseSelection = null;
	private static int longeurPixelCarre = 100;

	public static void main(String[] args) {

		Echiquier echiquier = new Echiquier();
		echiquier.initialiserEchiquier();

		FrameFenetre fenetreJeu = new FrameFenetre(900, 900);

		// affichage des carreaux
		JPanel panelPrincipal = new JPanel() {
			@Override
			public void paint(Graphics g) {

				int heightFenetre = fenetreJeu.getSize().height;
				int widthFenetre = fenetreJeu.getSize().width;

				boolean couleur = true;

				// creation quadrillage
				for (int y = 0; y < nbCarrelongeur; y++) {
					couleur = !couleur;
					for (int x = 0; x < nbCarrelongeur; x++) {
						couleur = !couleur;
						g.setColor(couleur ? couleurClaire : couleurSombre);
						g.fillRect(x * longeurPixelCarre, y * longeurPixelCarre, longeurPixelCarre, longeurPixelCarre);
					}
				}

				/*
				 * // affichage des pieces for (int y = 0; y < nbCarrelongeur; y++) { for (int x
				 * = 0; x < nbCarrelongeur; x++) { Case c = echiquier.getCase(x, y); if
				 * (!c.caseVide()) g.drawImage(c.getPiece().getImage(), x * longeurPixelCarre, y
				 * * longeurPixelCarre, longeurPixelCarre, longeurPixelCarre, this); } }
				 */

				for (Piece piece : echiquier.getJoueurBlanc().getListPiece()) {
					g.drawImage(piece.getImage(), piece.getCoordonnees().getX() * longeurPixelCarre,
							piece.getCoordonnees().getY() * longeurPixelCarre, longeurPixelCarre, longeurPixelCarre,
							this);
				}

				for (Piece piece : echiquier.getJoueurNoir().getListPiece()) {
					g.drawImage(piece.getImage(), piece.getCoordonnees().getX() * longeurPixelCarre,
							piece.getCoordonnees().getY() * longeurPixelCarre, longeurPixelCarre, longeurPixelCarre,
							this);
				}

			}
		};

		fenetreJeu.add(panelPrincipal, BorderLayout.CENTER);

		fenetreJeu.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (caseSelection != null) {

				}
			}
		});

		fenetreJeu.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				caseSelection = echiquier.getCase(e.getX() / longeurPixelCarre, e.getY() / longeurPixelCarre);
				System.out.println(caseSelection);
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

		fenetreJeu.setVisible(true);

	}

	private static void addComponentListener(ComponentAdapter componentAdapter) {
		// TODO Auto-generated method stub

	}

}
