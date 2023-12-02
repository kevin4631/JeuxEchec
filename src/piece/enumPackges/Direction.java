/**
 *
 */
package piece.enumPackges;

import piece.Vecteur;

/**
 *
 */
public enum Direction {
	UP        (new Vecteur(+0, +1)), 
	DOWN      (new Vecteur( 0, -1)), 
	LEFT      (new Vecteur(-1,  0)), 
	RIGHT     (new Vecteur(+1,  0)), 
	LEFT_UP   (new Vecteur(-1, +1)), 
	RIGHT_UP  (new Vecteur(+1, +1)), 
	LEFT_DOWN (new Vecteur(-1, -1)), 
	RIGHT_DOWN(new Vecteur(+1, -1));

	private final Vecteur vecteur;

	Direction(Vecteur vecteur) {
		this.vecteur = vecteur;
	}

	public Vecteur getVecteur() {
		return this.vecteur;
	}
}
