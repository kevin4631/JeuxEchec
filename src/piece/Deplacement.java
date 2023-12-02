package piece;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import echiquier.Case;

public class Deplacement {
	private List<Vecteur> listDeplacement;

	public Deplacement() {
		this.listDeplacement = new ArrayList<>();
		System.out.println();
	}

	public void addDeplacement(Vecteur v) {
		listDeplacement.add(v);
	}

	public void addDeplacement(int x, int y) {
		addDeplacement(new Vecteur(x, y));
	}

	// uniquement pour vecteur type
	public void addDeplacement(Deplacement deplacement) {
		Iterator<Vecteur> iterator = deplacement.iterator();

		while (iterator.hasNext()) {
			Vecteur v = iterator.next();
			addDeplacement(v.getX(), v.getY());
		}
	}

	public Iterator<Vecteur> iterator() {
		return listDeplacement.iterator();
	}

	public Boolean contientDestination(Case c1, Case c2) {
		Iterator<Vecteur> iterator = iterator();

		while (iterator.hasNext()) {
			Vecteur v = iterator.next();
			if (v.getX() + c1.getPossitionX() == c2.getPossitionX()
					&& v.getY() + c1.getPossitionY() == c2.getPossitionY())
				return true;
		}

		return false;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();

		Iterator<Vecteur> iterator = iterator();

		while (iterator.hasNext()) {
			Vecteur v = iterator.next();
			string.append(v.getX() + " " + v.getY() + "\n");

		}

		return string.toString();
	}
}
