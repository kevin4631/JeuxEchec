package echiquier;

import java.util.ArrayList;
import java.util.List;

import joueur.Joueur;
import joueur.JoueurBlanc;
import joueur.JoueurNoir;

public class Echiquier {
	private int nbLigne = 8;
	private int nbColonne = 8;
	private List<List<Case>> tableuCase = new ArrayList<>();
	private Joueur joueurBlanc;
	private Joueur joueurNoir;

	public Echiquier() {
		// TODO Auto-generated constructor stub
	}

	public void initialiserEchiquier() {

		joueurBlanc = new JoueurBlanc();
		joueurNoir = new JoueurNoir();

		initialiserCase();
	}

	private void initialiserCase() {
		for (int y = 0; y < nbLigne; y++) {
			tableuCase.add(new ArrayList<>());
			for (int x = 0; x < nbColonne; x++) {
				tableuCase.get(y).add(new Case(x, y));
			}
		}
	}

	public Case getCase(int x, int y) {
		return tableuCase.get(y).get(x);
	}

	public Joueur getJoueurBlanc() {
		return joueurBlanc;
	}

	public Joueur getJoueurNoir() {
		return joueurNoir;
	}

}
