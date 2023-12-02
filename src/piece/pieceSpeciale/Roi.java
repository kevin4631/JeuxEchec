package piece.pieceSpeciale;

import java.util.Iterator;

import echiquier.Echiquier;
import piece.Deplacement;
import piece.Piece;
import piece.Vecteur;
import piece.enumPackges.Couleur;
import piece.enumPackges.Direction;
import piece.enumPackges.NomPiece;

public class Roi extends Piece {

	public Roi(Couleur couleur) {
		super(couleur, NomPiece.ROI);
	}

	@Override
	public Deplacement getDeplacement(Echiquier echiquier, int x, int y) {

		Deplacement deplacements = new Deplacement();

		Deplacement dDirection = new Deplacement();

		dDirection.addDeplacement(Direction.UP.getVecteur());
		dDirection.addDeplacement(Direction.DOWN.getVecteur());
		dDirection.addDeplacement(Direction.LEFT.getVecteur());
		dDirection.addDeplacement(Direction.RIGHT.getVecteur());
		dDirection.addDeplacement(Direction.LEFT_UP.getVecteur());
		dDirection.addDeplacement(Direction.LEFT_DOWN.getVecteur());
		dDirection.addDeplacement(Direction.RIGHT_UP.getVecteur());
		dDirection.addDeplacement(Direction.RIGHT_DOWN.getVecteur());

		Iterator<Vecteur> iterator = dDirection.iterator();
		while (iterator.hasNext()) {
			Vecteur v = iterator.next();
			if (echiquier.inEchiquier(x + v.getX(), y + v.getY())
					&& echiquier.getCouleurPiece(x + v.getX(), y + v.getY()) != this.getCouleur())
				deplacements.addDeplacement(v.getX(), v.getY());
		}

		return deplacements;
	}
}
