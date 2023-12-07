package backEnd.enumPackges;

public enum ENomPiece {
	PION("P"), TOUR("T"), CAVALIER("C"), FOU("F"), DAMME("D"), ROI("R");

	private final String nom;

	ENomPiece(String nom) {
		this.nom = nom;
	}

	public String diminutif() {
		return nom;
	}
}
