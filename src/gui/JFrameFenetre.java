package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		setLayout(new BorderLayout());
		add(panelEchiquier, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.NORTH);
		add(panelFonctionnalites, BorderLayout.EAST);

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


	private void addComponentListener() {
		addComponentListener(new java.awt.event.ComponentAdapter() {
			@Override
			public void componentResized(java.awt.event.ComponentEvent evt) {
				int height = panelEchiquier.getHeight();
				int width = panelEchiquier.getWidth();
				int sizeMin = width < height ? width : height;
				int sizeCase = sizeMin / 8;

				panelEchiquier.setSize(sizeMin, sizeMin);

				for (int y = 0; y < 8; y++) {
					for (int x = 0; x < 8; x++) {
						listCase.get(y).get(x).setBounds(x * sizeCase, (7 - y) * sizeCase, sizeCase, sizeCase);
					}
				}
			}
		});
	}
}