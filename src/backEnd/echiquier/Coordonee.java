package backEnd.echiquier;

import backEnd.ICoordonee;

public class Coordonee implements ICoordonee {

	private int x;
	private int y;

	public Coordonee(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}

}
