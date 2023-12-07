package backEnd.joueur;

import backEnd.enumPackges.ECouleur;

public class JoueurBlanc extends Joueur {

	public JoueurBlanc() {
		super(ECouleur.BLANC);
	}

	public JoueurBlanc(Joueur joueur) {
		super(joueur);
	}
}
