package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameFenetre extends JFrame {

	private JPanel panelPrincilpale;
	private JPanelEchiquier panelEchiquier;
	private List<List<JPanelCase>> listCase;

	public JFrameFenetre() {

		// option fenetre
		setSize(900, 800);
		setMinimumSize(new Dimension(600, 400));
		setTitle("Projet echec RTAI");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// panel principale pour l'organisation
		panelPrincilpale = new JPanel();
		panelPrincilpale.setLayout(new GridLayout(1, 1));
		add(panelPrincilpale);

		// echiquier graphique
		listCase = new ArrayList<>();
		panelEchiquier = new JPanelEchiquier(listCase);
		panelPrincilpale.add(panelEchiquier);

		// redimensionne les cases a la bonne taille
		addComponentListener();

	}

	private void addComponentListener() {
		addComponentListener(new java.awt.event.ComponentAdapter() {
			@Override
			public void componentResized(java.awt.event.ComponentEvent evt) {

				int height = panelPrincilpale.getHeight();
				int width = panelPrincilpale.getWidth();
				int sizeMin = width < height ? width : height;
				int sizeCase = sizeMin / 8;

				panelEchiquier.setSize(sizeMin, sizeMin);

				for (int y = 0; y < 8; y++) {
					for (int x = 0; x < 8; x++) {
						listCase.get(y).get(x).setBounds(x * sizeCase, y * sizeCase, sizeCase, sizeCase);
					}
				}

			}
		});
	}

}
