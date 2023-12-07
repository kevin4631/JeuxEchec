package backEnd.joueur;

import backEnd.echiquier.Echiquier;
import backEnd.piece.enumPackges.Couleur;

public class JoueurBlanc extends Joueur {

	public JoueurBlanc(Echiquier echiquier) {
		super(Couleur.BLANC, echiquier);
	}

	public JoueurBlanc(Joueur joueur, Echiquier echiquier) {
		super(joueur, echiquier);
	}
}
