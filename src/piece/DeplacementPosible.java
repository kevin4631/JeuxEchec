package piece;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeplacementPosible {
	private List<Vecteur> listDeplacement;

	public DeplacementPosible() {
		this.listDeplacement = new ArrayList<>();
	}

	public void addDeplacement(int x, int y) {
		listDeplacement.add(new Vecteur(x, y));
	}

	public Iterator<Vecteur> iterator() {
		return listDeplacement.iterator();
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
