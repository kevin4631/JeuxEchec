package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import backEnd.enumPackges.ECouleur;
import gui.jboutons.JBoutonQuitter;
import gui.jboutons.JBoutonRelancer;
import gui.panelsEchiquier.JPanelCase;
import gui.panelsEchiquier.JPanelEchiquier;
import gui.panelsPieceDead.JPanelPieceDead;

public class JFrameFenetre extends JFrame {

	private JPanelEchiquier panelEchiquier;
	private JPanelPieceDead panelPiecesMortesBlanc;
	private JPanelPieceDead panelPiecesMortesNoir;

	private List<List<JPanelCase>> listCase;
	private JPanel panelFonctionnalites;
	private JPanel panelPrincipal;

	public JFrameFenetre() {
		initializeComponents();
		setupLayout();
	}

	private void initializeComponents() {

		setMinimumSize(new Dimension(800, 500));
		setTitle("Jeux d'échec RTAI");

		// panel principal
		panelPrincipal = new JPanel(new BorderLayout());

		// Panel pour l'échiquier
		listCase = new ArrayList<>();
		panelEchiquier = new JPanelEchiquier(listCase);
		addComponentListener();

		// Panel contentat deux sous panels pour les pièces mortes
		panelFonctionnalites = new JPanel(new GridLayout(1, 2));
		panelFonctionnalites.setSize(new Dimension(400, getHeight()));
		panelFonctionnalites.setBorder(BorderFactory.createLineBorder(new Color(89, 102, 115), 3));

		// Panel Pieces Blanches Mortes
		panelPiecesMortesBlanc = new JPanelPieceDead("Pieces blanches Mortes", 100, getHeight(), ECouleur.BLANC);
		// Panel pour Pieces Noires Mortes
		panelPiecesMortesNoir = new JPanelPieceDead("Pieces Noires Mortes", 100, getHeight(), ECouleur.NOIR);

		// Ajouter les deux sous panels dans le panel panelFonctionalites
		panelPiecesMortesBlanc.setBackground(new Color(255, 162, 162));
		panelPiecesMortesNoir.setBackground(Color.gray.darker());

		panelFonctionnalites.add(panelPiecesMortesBlanc);
		panelFonctionnalites.add(panelPiecesMortesNoir);

		// Ajouter panelEchiquier et panelFonctionnalites au panel principal
		panelPrincipal.add(panelFonctionnalites, BorderLayout.WEST);
		panelPrincipal.add(panelEchiquier, BorderLayout.CENTER);


		// Utilisation de BorderLayout pour organiser le panel principal au centre
		setLayout(new BorderLayout());
		add(panelPrincipal, BorderLayout.CENTER);

		// Panel contenant les boutons
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(new JBoutonRelancer(this));
		buttonsPanel.add(new JBoutonQuitter(this));

		// Ajouter les boutons au panel principal
		add(buttonsPanel, BorderLayout.NORTH);

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

	public JPanelEchiquier getpanelEchiquier() {
		return panelEchiquier;
	}

	public JPanel getpanelFonctionnalites() {
		return panelFonctionnalites;
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