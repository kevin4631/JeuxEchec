package backEnd.echiquier;

import backEnd.ICoordonee;

public class Vecteur implements ICoordonee {
	private int x;
	private int y;

	public Vecteur(int x, int y) {
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
}
