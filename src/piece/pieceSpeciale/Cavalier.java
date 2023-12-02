package piece.pieceSpeciale;

import java.util.Iterator;

import echiquier.Echiquier;
import piece.Deplacement;
import piece.Piece;
import piece.Vecteur;
import piece.enumPackges.Couleur;
import piece.enumPackges.NomPiece;

public class Cavalier extends Piece {
	Deplacement deplacements;

	public Cavalier(Couleur couleur) {
		super(couleur, NomPiece.CAVALIER);
	}

	@Override
	public Deplacement getDeplacement(Echiquier echiquier, int x, int y) {

		deplacements = new Deplacement();
		Deplacement d = new Deplacement();

		d.addDeplacement(+2, +1);
		d.addDeplacement(+2, -1);

		d.addDeplacement(-2, +1);
		d.addDeplacement(-2, -1);

		d.addDeplacement(+1, +2);
		d.addDeplacement(+1, -2);

		d.addDeplacement(-1, +2);
		d.addDeplacement(-1, -2);

		Iterator<Vecteur> iterator = d.iterator();
		while (iterator.hasNext()) {
			Vecteur v = iterator.next();
			if (echiquier.inEchiquier(x + v.getX(), y + v.getY())
					&& echiquier.getCouleurPiece(x + v.getX(), y + v.getY()) != this.getCouleur())
				deplacements.addDeplacement(v.getX(), v.getY());
		}

		return deplacements;
	}

}
