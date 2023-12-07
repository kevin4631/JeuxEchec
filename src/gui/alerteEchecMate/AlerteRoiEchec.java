package gui.alerteEchecMate;

import javax.swing.JOptionPane;

import backEnd.enumPackges.ECouleur;
import gui.Main;

public class AlerteRoiEchec extends JOptionPane {

	public AlerteRoiEchec(ECouleur couleur) {
		JOptionPane AlerteEchec = new JOptionPane();
		AlerteEchec.showMessageDialog(Main.gui, "Le roi " + couleur + " est en échec!", "Échec!",
				JOptionPane.INFORMATION_MESSAGE);

	}
}