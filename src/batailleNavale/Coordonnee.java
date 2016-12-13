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
		
		this.ligne = Integer.parseInt(s.substring(0,1));
		this.colonne = Integer.parseInt(s.substring(1));
	}

	public String toString() {
		// Affichage coordonnées colone en lettre + num Ligne
		String lettre[] = {"","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String coord = "" + lettre[colonne] + ligne + "";
		return coord;
	}

	
	public int getLigne() {
		
		return ligne;
	}
	

	public int getColonne() {
		
		return colonne;
	}
	

	public boolean equals(Object obj) {
		
		return (this == obj);
	}
	
	
	public boolean voisine(Coordonnee c) {
	
		return ((this.ligne == c.ligne-1 && this.colonne == c.colonne)||
			(this.ligne == c.ligne+1 && this.colonne == c.colonne) ||
			(this.colonne == c.colonne-1 && this.ligne == c.ligne) ||
			(this.colonne == c.colonne+1 && this.ligne == c.ligne)
			);
		
			//		if ((this.ligne == c.ligne-1 && this.colonne == c.colonne)||(this.ligne == c.ligne+1 && this.colonne == c.colonne) || (this.colonne == c.colonne-1 && this.ligne == c.ligne) || (this.colonne == c.colonne+1 && this.ligne == c.ligne)){
			//			return true;
			//		}else		
			//		return false;	
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
		
		Coordonnee A = new Coordonnee(2,3);
		Coordonnee B = new Coordonnee(4,5);
		Coordonnee C = new Coordonnee(2,3);
		Coordonnee D = new Coordonnee(6,8);
		Coordonnee E = new Coordonnee(6,9);
		Coordonnee F = new Coordonnee(3,1);
		
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
