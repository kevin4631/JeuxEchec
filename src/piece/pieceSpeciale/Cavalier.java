package piece.pieceSpeciale;

import echiquier.Echiquier;
import piece.ListDeplacement;
import piece.Piece;
import piece.Vecteur;
import piece.enumPackges.Couleur;
import piece.enumPackges.NomPiece;

public class Cavalier extends Piece {

	public Cavalier(Couleur couleur) {
		super(couleur, NomPiece.CAVALIER);
	}

	@Override
	public ListDeplacement getDeplacement(Echiquier echiquier, int x, int y) {
		ListDeplacement deplacements = new ListDeplacement();
		ListDeplacement dDirection = new ListDeplacement();

		dDirection.addDeplacement(+2, +1);
		dDirection.addDeplacement(+2, -1);

		dDirection.addDeplacement(-2, +1);
		dDirection.addDeplacement(-2, -1);

		dDirection.addDeplacement(+1, +2);
		dDirection.addDeplacement(+1, -2);

		dDirection.addDeplacement(-1, +2);
		dDirection.addDeplacement(-1, -2);

		for (Vecteur vecteur : dDirection.getListDeplacement()) {
			if (echiquier.inEchiquier(x + vecteur.getX(), y + vecteur.getY())
					&& echiquier.getCouleurPiece(x + vecteur.getX(), y + vecteur.getY()) != this.getCouleur())
				deplacements.addDeplacement(vecteur.getX(), vecteur.getY());
		}

		return deplacements;
	}

}
