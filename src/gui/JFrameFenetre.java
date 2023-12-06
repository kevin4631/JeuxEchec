package gui;

import java.awt.TextArea;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import piece.Piece;

public class JFrameFenetre extends JFrame {

	private JPanel panelPrincilpale, SecondPanel;
	private JPanelEchiquier panelEchiquier;

	private List<List<JPanelCase>> listCase;

	private TextArea conteneurPieceDeadBlanc = new TextArea();
	private TextArea conteneurPieceDeadNoir = new TextArea();

	public JFrameFenetre() {

		// panel principale pour l'organisation
		panelPrincilpale = new JPanel();
		add(panelPrincilpale);

		// Affichage PieceDead
		// updateListePieceBlancDead();

		// echiquier graphique
		listCase = new ArrayList<>();
		panelEchiquier = new JPanelEchiquier(listCase, this);
		panelPrincilpale.add(panelEchiquier);
		addComponentListener();

		updateListePieceBlancDead();
		SecondPanel = new JPanel();
		JButton Relancer = new JButton();
		JButton Quitter = new JButton();

		JLabel JoueurNoir = new JLabel();
		JLabel JoueurBlanc = new JLabel();

		// TextArea conteneurPieceDeadBNoir = new java.awt.TextArea();
		// TextArea conteneurPieceDeadBlanc = new java.awt.TextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(255, 204, 204));
		setResizable(false);

		javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincilpale);
		panelPrincilpale.setLayout(panelPrincipalLayout);
		panelPrincipalLayout.setHorizontalGroup(panelPrincipalLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 770, Short.MAX_VALUE));
		panelPrincipalLayout.setVerticalGroup(panelPrincipalLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 669, Short.MAX_VALUE));

		SecondPanel.setBorder(javax.swing.BorderFactory.createLineBorder(null));

		Relancer.setText("Relancer");
		Relancer.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				Main.echiquier.initialiserEchiquier();
				panelEchiquier.repaint();
			}
		});

		Quitter.setText("Quitter");
		Quitter.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});

		JoueurNoir.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
		JoueurNoir.setText(" Joueur Noir");

		JoueurBlanc.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
		JoueurBlanc.setText(" Joueur Blanc");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(SecondPanel);

		SecondPanel.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addComponent(Relancer)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(Quitter))
				.addGroup(GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(conteneurPieceDeadBlanc,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(conteneurPieceDeadNoir,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addGap(82, 82, 82)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(JoueurBlanc).addComponent(JoueurNoir, GroupLayout.PREFERRED_SIZE,
										105, GroupLayout.PREFERRED_SIZE))
						.addGap(0, 66, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(Relancer).addComponent(Quitter))
						.addGap(46, 46, 46).addComponent(JoueurNoir)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(conteneurPieceDeadBlanc, GroupLayout.PREFERRED_SIZE, 173,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
						.addComponent(conteneurPieceDeadNoir, GroupLayout.PREFERRED_SIZE, 170,
								GroupLayout.PREFERRED_SIZE)
						.addGap(21, 21, 21).addComponent(JoueurBlanc).addGap(24, 24, 24)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap()
						.addComponent(SecondPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(panelPrincilpale, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(55, 55, 55)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(SecondPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(panelPrincilpale, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addGap(14, 14, 14))

				);

		pack();
	}

	public void updateListePieceBlancDead() {
		List<Piece> mylist = Main.echiquier.getJoueurBlanc().getPiecesMorte();

		conteneurPieceDeadBlanc.append(mylist.toString());
		// System.out.print(piece + ", ");

		// System.out.println();
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
						listCase.get(y).get(x).setBounds(x * sizeCase, (7 - y) * sizeCase, sizeCase, sizeCase);
					}
				}

			}
		});
	}


}
