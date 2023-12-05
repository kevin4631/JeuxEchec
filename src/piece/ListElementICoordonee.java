package piece;

import java.util.ArrayList;
import java.util.List;

import echiquier.ICoordonee;

public class ListElementICoordonee {

	private List<ICoordonee> list;

	public ListElementICoordonee() {

		this.list = new ArrayList<>();
	}

	public void add(ICoordonee element) {
		list.add(element);
	}

	public void add(ListElementICoordonee list) {
		for (ICoordonee element : list.getListElement())
			add(element);
	}

	/**
	 * @return the listDeplacement
	 */
	public List<ICoordonee> getListElement() {
		return list;
	}

	public Boolean contient(int x, int y) {
		for (ICoordonee element : list) {
			if (element.getX() == x && element.getY() == y)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();

		for (ICoordonee element : list)
			string.append(element.getX() + " " + element.getY() + "\n");

		return string.toString();
	}

}
