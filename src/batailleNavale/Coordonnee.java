package batailleNavale;

public class Coordonnee {
	private int ligne;
	private int colonne;

	public Coordonnee(int ligne, int colonne) {

//		if ( (ligne < 1 || ligne > 26) || (colonne < 1 || colonne > 26 )) {
//			throw new IllegalArgumentException("Pour les lignes et les colonnes, entrez un chiffre entre 1 et 26");
//		}

		
		

		this.ligne = ligne;
		this.colonne = colonne;
	}

	public Coordonnee(String s){
				
		// Si s est null
		if (s.equals(null)) {
			throw new IllegalArgumentException("Erreur: la chaine entrée vaut NULL.");
		}
		// Si s = ""
		if (s.isEmpty()) {
			throw new IllegalArgumentException("Erreur: la chaine entrée est vide.");
		}
		
		// Si la lettre est bien majuscule
		if(!s.equals(s.toUpperCase()) ){
			throw new IllegalArgumentException("Erreur: la lettre n'est pas majuscule.");
		}
		
		// Si la premiere lettre est bien une lettre
		char c = s.charAt(0);
		if(!Character.isLetter(c)){
			throw new IllegalArgumentException("Partie alphabetique de la chaine incorrecte: lettre entre A et Z.");
		} else {
			this.colonne = c - 'A' + 1;
		}

		// test de la partie Numérique
		try {
			this.ligne = Integer.parseInt(s.substring(1));
			
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Partie numérique de la chaine incorrecte: entier entre 1 et 25.");
		}
			

	}
	
	

	public String toString() {
		// Affichage coordonnées colone en lettre + num Ligne
		char c = (char)(this.colonne + 'A' - 1);
		String coord = "" + c + ligne + "";

		return coord;
	}

	public int getLigne() {
		
		return (this.ligne);

	}

	public int getColonne() {
		
		return (this.colonne);

	}

	public boolean equals(Object obj) {
		return (this.getLigne() == ((Coordonnee)obj).getLigne() && (this.getColonne() == ((Coordonnee)obj).getColonne()));
		
	}
	
	public boolean voisine(Coordonnee c) {

	
		return ((this.ligne == c.ligne-1 && this.colonne == c.colonne)||
			(this.ligne == c.ligne+1 && this.colonne == c.colonne) ||
			(this.colonne == c.colonne-1 && this.ligne == c.ligne) ||
			(this.colonne == c.colonne+1 && this.ligne == c.ligne)
			);
	}
	
	
	/* Renvoie un nombre un négatif si coord A est inférieur à coord B => A.compareTo(B)
	 * Sinon renvoie 1 
	*/
	public int  compareTo(Coordonnee c) {
		
		int res = 0;
		
		if ((this.ligne - c.ligne) <= 0) {
			res = (this.colonne -c.colonne);
		
		}else{ //if ((this.ligne - c.ligne) > 0) {
			res = (this.ligne - c.ligne);

		}
		return res;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		// INPUT(LIGNES,COL) => DISPLAY(COL,LIGNES) !!!
		Coordonnee A = new Coordonnee(2,3);
		Coordonnee B = new Coordonnee(4,5);
		Coordonnee C = new Coordonnee(2,3);
		Coordonnee D = new Coordonnee(6,8);
		Coordonnee E = new Coordonnee(6,9);
		Coordonnee F = new Coordonnee(3,1);
		
		Coordonnee s1 = new Coordonnee("Z2");
		Coordonnee s2 = new Coordonnee("E22");
		Coordonnee s3 = new Coordonnee("A0");
		
		System.out.println("methode toString");
		System.out.println(A.toString());
		System.out.println(B.toString());
		System.out.println(C.toString());
		System.out.println(D.toString());
		
		System.out.println("methode equals");
		System.out.println(A.equals(B));
		System.out.println(C.equals(A)); 
		System.out.println(C.toString().equals(A.toString()));
		
		System.out.println("methode compareTo");
		System.out.println(A.compareTo(B));
		System.out.println(D.compareTo(B));
		System.out.println(B.compareTo(D));
		
		System.out.println("methode estVoisin:");
		System.out.println(D.voisine(E));
		System.out.println(E.voisine(F));

	}

}
