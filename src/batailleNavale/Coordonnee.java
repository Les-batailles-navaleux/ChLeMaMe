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
		this.ligne = Integer.parseInt(s.substring(0, 1));
		this.colonne = Integer.parseInt(s.substring(1));
	}

	public String toString() {
		
		String lettre[] = ['A','B',"C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
		String coord = "" + ligne + colonne + "";
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
	//return ((this.ligne == c.ligne-1 && this.colonne == c.colonne)||(this.ligne == c.ligne+1 && this.colonne == c.colonne) || (this.colonne == c.colonne-1 && this.ligne == c.ligne) || (this.colonne == c.colonne+1 && this.ligne == c.ligne));
		
		if ((this.ligne == c.ligne-1 && this.colonne == c.colonne)||(this.ligne == c.ligne+1 && this.colonne == c.colonne) || (this.colonne == c.colonne-1 && this.ligne == c.ligne) || (this.colonne == c.colonne+1 && this.ligne == c.ligne)){
			return true;
		}else		
		return false;	
	}
	
	/* Renvoie un nombre < 0 si coord A est inférieur à coord B => A.compareTo(B)
	 * Sinon renvoie 1 
	*/
	public int  compareTo(Coordonnee c) {
		
		int res = 1;
		
		if ((this.ligne - c.ligne) == 0) {
			res = (this.colonne -c.colonne);
		}
		
		// Si A < B , on renvoie 1
		if ((this.ligne - c.ligne) < 0) {
			res = 1;
		} 
		
		if ((this.ligne - c.ligne) > 0) {
			res = this.ligne - c.ligne;
		}
		
		return res;
		
		// Si la différence des colones == 0, n renvoie la différence des lignes
//		if((this.colonne - c.colonne) == 0){
//			return(this.ligne - c.ligne);
//		}
//		
//		
//		// Si même ligne ou inférireure et colone inferieure
//		if (((this.ligne - c.ligne) <= 0) && ((this.colonne - c.colonne) < 0 )){
//			return (-1);			
//		}
//		
//		// Si même ligne ou inférieure et colone supérieure
//		if (((this.ligne - c.ligne) <= 0) && ((this.colonne - c.colonne) > 0 )) {
//			return (-1);
//		}
//		
//		// Si ligne supérieure et colonne inférieure
//		if (((this.ligne - c.ligne) > 0) && ((this.colonne - c.colonne) < 0 )) {
//			return (1);
//		}
//		
//		// Si ligne supérieure et colone supérireure
//		if (((this.ligne - c.ligne) > 0) && ((this.colonne - c.colonne) > 0 )) {
//			return (1);
//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Coordonnee A = new Coordonnee(2, 3);
		Coordonnee B = new Coordonnee(4, 5);
		
		
		
	}

}
