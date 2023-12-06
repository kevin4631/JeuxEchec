package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.panelsEchiquier.JPanelCase;
import gui.panelsEchiquier.JPanelEchiquier;
import gui.panelsPieceDead.JPanelPieceDead;
import piece.enumPackges.Couleur;

public class JFrameFenetre extends JFrame {

	private JPanelEchiquier panelEchiquier;
	private JPanelPieceDead panelPiecesMortesBlanc;
	private JPanelPieceDead panelPiecesMortesNoir;

	private List<List<JPanelCase>> listCase;
	private JPanel panelFonctionnalites;

	public JFrameFenetre() {
		initializeComponents();
		setupLayout();
	}

	private void initializeComponents() {

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setMinimumSize(new Dimension(400, 400));

		// Panel pour l'échiquier
		listCase = new ArrayList<>();
		panelEchiquier = new JPanelEchiquier(listCase, this);
		addComponentListener();

		// création boutons
		JButton relancerButton = new JButton("Relancer");
		JButton quitterButton = new JButton("Quitter");

		// Panel contenant les boutons
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(relancerButton);
		buttonsPanel.add(quitterButton);

		// Panel pour les icônes des pièces mortes
		panelFonctionnalites = new JPanel(new BorderLayout());

		// Panel pour Blanc dead pieces
		panelPiecesMortesBlanc = new JPanelPieceDead("Joueur blanc", 200, getHeight(), Couleur.BLANC);

		// Panel pour Noir dead pieces
		panelPiecesMortesNoir = new JPanelPieceDead("Joueur noir", 200, getHeight(), Couleur.NOIR);

		panelFonctionnalites.add(panelPiecesMortesBlanc, BorderLayout.WEST);
		panelFonctionnalites.add(panelPiecesMortesNoir, BorderLayout.EAST);

		// Utilisation de BorderLayout pour organiser l'échiquier au centre et les boutons en
		// haut à droite
		panelPrincipal.setLayout(new BorderLayout());

		panelFonctionnalites.add(buttonsPanel, BorderLayout.NORTH);

		panelPrincipal.add(panelEchiquier, BorderLayout.CENTER);
		panelPrincipal.add(panelFonctionnalites, BorderLayout.EAST);

		relancerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.echiquier.initialiserEchiquier();
				panelEchiquier.repaint();
			}
		});

		quitterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void setupLayout() {
		// la taille de JFrame et d'autres propriétés
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true); // Permettre le redimensionnement de la fenêtre
		setLocationRelativeTo(null);
	}

	public void repaintIconMort() {
		panelPiecesMortesBlanc.repaint();
		panelPiecesMortesNoir.repaint();
	}



	private void addComponentListener() {
		addComponentListener(new java.awt.event.ComponentAdapter() {
			@Override
			public void componentResized(java.awt.event.ComponentEvent evt) {
				int height = panelEchiquier.getHeight();
				int width = panelEchiquier.getWidth();
				int sizeMin = width < height ? width : height;
				int sizeCase = sizeMin / 8;

				if (sizeCase < 50)
					sizeCase = 50;

				for (int y = 0; y < 8; y++) {
					for (int x = 0; x < 8; x++) {
						listCase.get(y).get(x).setBounds(x * sizeCase, (7 - y) * sizeCase, sizeCase, sizeCase);
					}
				}
			}
		});
	}
}