package gui.alerteEchecMate;

import java.awt.Window;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import backEnd.enumPackges.ECouleur;
import gui.Main;
import gui.jboutons.JBoutonRelancer;

public class AlerteRoiEchecMat extends JOptionPane {

	public AlerteRoiEchecMat(ECouleur couleur) {

		JBoutonRelancer RelancerPartie = new JBoutonRelancer(Main.gui);

		RelancerPartie.addActionListener(e -> {
			Window window = SwingUtilities.getWindowAncestor(RelancerPartie);
			window.dispose();
		});

		Object[] options = { RelancerPartie };

		JOptionPane.showOptionDialog(Main.gui, "Le roi " + couleur + " est en échec et mat!", "Game Over",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
				options.length > 0 ? options[0] : null);

	}

}
