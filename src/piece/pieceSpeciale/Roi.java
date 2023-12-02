package piece.pieceSpeciale;

import java.util.Iterator;

import echiquier.Echiquier;
import piece.Deplacement;
import piece.Piece;
import piece.Vecteur;
import piece.enumPackges.Couleur;
import piece.enumPackges.NomPiece;

public class Roi extends Piece {

	public Roi(Couleur couleur) {
		super(couleur, NomPiece.ROI);
	}

	@Override
	public Deplacement getDeplacement(Echiquier echiquier, int x, int y) {

		Deplacement deplacements = new Deplacement();

		Deplacement d = new Deplacement();

		d.addDeplacement(+1, +1);
		d.addDeplacement(+1, 0);
		d.addDeplacement(+1, -1);

		d.addDeplacement(-1, +1);
		d.addDeplacement(-1, 0);
		d.addDeplacement(-1, -1);

		d.addDeplacement(0, +1);
		d.addDeplacement(0, -1);

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
