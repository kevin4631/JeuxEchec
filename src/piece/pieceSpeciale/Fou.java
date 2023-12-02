package piece.pieceSpeciale;

import java.util.Iterator;

import echiquier.Echiquier;
import piece.Deplacement;
import piece.Piece;
import piece.Vecteur;
import piece.enumPackges.Couleur;
import piece.enumPackges.Direction;
import piece.enumPackges.NomPiece;

public class Fou extends Piece {

	public Fou(Couleur couleur) {
		super(couleur, NomPiece.FOU);
	}

	@Override
	public Deplacement getDeplacement(Echiquier echiquier, int x, int y) {
		Deplacement deplacements = new Deplacement();
		Deplacement dDirection = new Deplacement();

		dDirection.addDeplacement(Direction.LEFT_UP.getVecteur());
		dDirection.addDeplacement(Direction.LEFT_DOWN.getVecteur());
		dDirection.addDeplacement(Direction.RIGHT_UP.getVecteur());
		dDirection.addDeplacement(Direction.RIGHT_DOWN.getVecteur());

		Iterator<Vecteur> iterator = dDirection.iterator();
		while (iterator.hasNext()) {
			Deplacement d = echiquier.getDeplacementsInDirection(echiquier.getCase(x, y), iterator.next());
			deplacements.addDeplacement(d);
		}

		return deplacements;
	}

}
