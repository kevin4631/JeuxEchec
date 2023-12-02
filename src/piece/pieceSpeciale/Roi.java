package piece.pieceSpeciale;

import echiquier.Case;
import echiquier.Echiquier;
import echiquier.ICoordonee;
import piece.ListDeplacement;
import piece.Piece;
import piece.enumPackges.Couleur;
import piece.enumPackges.Direction;
import piece.enumPackges.NomPiece;

public class Roi extends Piece {

	public Roi(Couleur couleur) {
		super(couleur, NomPiece.ROI);
	}

	@Override
	public ListDeplacement getDeplacement(Echiquier echiquier, int origineX, int origineY) {
		ListDeplacement listeCase = new ListDeplacement();
		ListDeplacement listVecteur = new ListDeplacement();

		listVecteur.add(Direction.UP);
		listVecteur.add(Direction.DOWN);
		listVecteur.add(Direction.LEFT);
		listVecteur.add(Direction.RIGHT);
		listVecteur.add(Direction.LEFT_UP);
		listVecteur.add(Direction.LEFT_DOWN);
		listVecteur.add(Direction.RIGHT_UP);
		listVecteur.add(Direction.RIGHT_DOWN);

		for (ICoordonee vecteur : listVecteur.getListDeplacement()) {
			int destinationX = origineX + vecteur.getX();
			int destinationY = origineY + vecteur.getY();
			if (echiquier.inEchiquier(destinationX, destinationY)
					&& echiquier.getCouleurPiece(destinationX, destinationY) != this.getCouleur())
				listeCase.add(new Case(destinationX, destinationY));
		}

		return listeCase;
	}
}
