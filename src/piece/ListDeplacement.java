package piece;

import java.util.ArrayList;
import java.util.List;

import echiquier.Case;
import echiquier.ICoordonee;

public class ListDeplacement {

	private List<ICoordonee> list;

	public ListDeplacement() {
		this.list = new ArrayList<>();
	}

	public void add(ICoordonee element) {
		list.add(element);
	}

	public void add(ListDeplacement list) {
		for (ICoordonee element : list.getListDeplacement())
			add(element);
	}

	/**
	 * @return the listDeplacement
	 */
	public List<ICoordonee> getListDeplacement() {
		return list;
	}

	public Boolean contientCaseDestination(Case c2) {
		for (ICoordonee element : list) {
			if (element.getX() == c2.getX() && element.getY() == c2.getY())
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
