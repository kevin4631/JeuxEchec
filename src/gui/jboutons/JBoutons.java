package gui.jboutons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public abstract class JBoutons extends JButton {
	private String titre;

	public JBoutons(String titre) {
		this.titre = titre;
		customizeButton(titre);
	}

	private void customizeButton(String titre) {
		setText(titre);
		setFont(new Font("Arial", Font.BOLD, 14));
		setForeground(new Color(255, 255, 255)); // Couleur du texte
		setBackground(new Color(255, 162, 162)); // Couleur de fond
		setFocusPainted(false); // Désactiver la mise en surbrillance lorsqu'il est cliqué
		setBorder(BorderFactory.createLineBorder(new Color(217, 181, 181), 2)); // Bordure
		setPreferredSize(new Dimension(100, 40)); // Ajuster la taille
	}
}
