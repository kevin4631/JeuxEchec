package piece;

import java.util.ArrayList;
import java.util.List;

import echiquier.Case;

public class ListDeplacement {

	private List<Vecteur> listVecteur;

	public ListDeplacement() {
		this.listVecteur = new ArrayList<>();
		System.out.println();
	}

	public void addDeplacement(Vecteur v) {
		listVecteur.add(v);
	}

	public void addDeplacement(int x, int y) {
		addDeplacement(new Vecteur(x, y));
	}

	public void addDeplacement(ListDeplacement deplacement) {
		for (Vecteur vecteur : deplacement.getListDeplacement())
			addDeplacement(vecteur);
	}

	/**
	 * @return the listDeplacement
	 */
	public List<Vecteur> getListDeplacement() {
		return listVecteur;
	}

	public Boolean contientDestination(Case c1, Case c2) {
		for (Vecteur vecteur : listVecteur) {
			if (vecteur.getX() + c1.getX() == c2.getX() && vecteur.getY() + c1.getY() == c2.getY())
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();

		for (Vecteur vecteur : listVecteur)
			string.append(vecteur.getX() + " " + vecteur.getY() + "\n");

		return string.toString();
	}

}
