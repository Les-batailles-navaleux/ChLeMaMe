package batailleNavale;
// test

public class Coordonnee {
	private int ligne;
	private int colonne;

	public Coordonnee(int ligne, int colonne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}

	public Coordonnee(String s) {
		
	}

	public String toString() {
		String coord = ligne + colonne;
		return coord;
	}

	public int getLigne() {
		return ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public boolean equals(Object obj) {
		return this == obj;
	}
	
	public boolean voisine(Coordonnee c) {
		if ( )
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
