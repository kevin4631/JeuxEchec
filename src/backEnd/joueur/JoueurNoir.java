package backEnd.joueur;

import backEnd.enumPackges.ECouleur;

public class JoueurNoir extends Joueur {

	public JoueurNoir() {
		super(ECouleur.NOIR);
	}

	public JoueurNoir(Joueur joueur) {
		super(joueur);
	}
}
