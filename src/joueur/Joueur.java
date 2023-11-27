package joueur;

import piece.Couleur;

public abstract class Joueur {
	private Couleur couleur;

	protected Joueur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

}
