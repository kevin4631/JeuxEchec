package joueur;

import echiquier.Echiquier;
import piece.enumPackges.Couleur;

public class JoueurNoir extends Joueur {

	public JoueurNoir(Echiquier echiquier) {
		super(Couleur.NOIR, echiquier);
	}

}
