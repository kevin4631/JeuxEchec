package backEnd.joueur;

import backEnd.echiquier.Echiquier;
import backEnd.piece.enumPackges.Couleur;

public class JoueurNoir extends Joueur {

	public JoueurNoir(Echiquier echiquier) {
		super(Couleur.NOIR, echiquier);
	}

	public JoueurNoir(Joueur joueur, Echiquier echiquier) {
		super(joueur, echiquier);
	}
}
