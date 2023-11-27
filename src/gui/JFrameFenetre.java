package gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import echiquier.Echiquier;

public class JFrameFenetre extends JFrame {

	protected static Echiquier echiquier;

	public JFrameFenetre(Echiquier echiquier) {

		this.echiquier = echiquier;

		// option fenetre
		setSize(900, 800);
		setTitle("Projet echec RTAI");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// panel principale pour l'organisation
		JPanel panelPrincilpale = new JPanel();
		panelPrincilpale.setLayout(new GridLayout(1, 1));
		add(panelPrincilpale);

		// echiquier graphique
		List<List<JPanelCase>> listCase = new ArrayList<>();
		JPanelEchiquier panelEchiquier = new JPanelEchiquier(listCase);
		panelPrincilpale.add(panelEchiquier);

		// redimensionne les cases a la bonne taille
		addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentResized(java.awt.event.ComponentEvent evt) {

				int height = panelPrincilpale.getHeight();
				int width = panelPrincilpale.getWidth();
				int sizeMin = width < height ? width : height;

				panelEchiquier.setSize(sizeMin, sizeMin);

				int sizeCase = sizeMin / 8;

				for (int y = 0; y < 8; y++) {
					for (int x = 0; x < 8; x++) {
						listCase.get(y).get(x).setBounds(x * sizeCase, y * sizeCase, sizeCase, sizeCase);
					}
				}

			}
		});

	}
}
