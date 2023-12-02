package joueur;

import echiquier.Echiquier;
import piece.enumPackges.Couleur;

public class JoueurBlanc extends Joueur {

	public JoueurBlanc(Echiquier echiquier) {
		super(Couleur.BLANC, echiquier);
	}

}
