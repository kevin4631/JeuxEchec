package piece.enumPackges;

public enum NomPiece {
	PION("P"), TOUR("T"), CAVALIER("C"), FOU("F"), DAMME("D"), ROI("R");

	private final String nom;

	NomPiece(String nom) {
		this.nom = nom;
	}

	public String diminutif() {
		return nom;
	}
}
