package batailleNavale;

public class GrilleNavale  { // extends Navire
	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;
	
	public GrilleNavale(int taille, int[] taillesNavires) {
		this.taille = taille;
		this.nbNavires = taillesNavires.length;				// nb navire = taille du tableau de navires
		this.nbTirsRecus = 0;								// initialisation des tirs reçus à 0
		this.tirsRecus = new Coordonnee[(taille*taille)]; 	// Nb de coups possible = taille de la grille
		
		this.navires = new Navire[this.nbNavires];
		
		for (int i = 0; i < this.nbNavires; i++) {
			// remplacer true par le placement automatique par la suite...
			this.navires[i] = new Navire(new Coordonnee("A1"), taillesNavires[i], true /*placementAuto(taillesNavires);*/); 
		}
	}
	
	public GrilleNavale(int taille, int nbNavires) {
		this.taille = taille;
		this.nbNavires = navires.length;
	}
	
	
//	public GrilleNavale(int taille, int[] taillesNavires) {
//		this.taille = taille;
//		taillesNavires = new int [nbNavires];
//		navires = new Navire [taillesNavires.length];
//		tirsRecus = new Coordonnee [0];
//	}
//	
//	public GrilleNavale(int taille, int nbNavires) {
//		this.taille = taille;
//		this.nbNavires = nbNavires;
//	}
	
	public String toString() {
		
		String s1 ="";
		String s2 ="";
		
		for (int i = 0; i < this.taille; i++) {
			char c = (char) (i + 'A'); 			// i + code ASCII
			s1 = s1 + Character.toString(c);	// affichage de la lettre +  ... le reste
		}
		
		System.out.println(s1);
		
		int chiffre = 1;
		
		// Afficher les lettre dans une 1ere boucle for
		for (int i = 0; i < this.taille; i++){
			
			s2 = s2 + Integer.toString(chiffre); // Affichage du nombre + ... le reste
			
			// Afficher les chiffres dans une deuxieme boulce for
			for (int j = 0; j <= this.taille; j++) {
				
				
//				Coordonnee k = new Coordonnee(i, j);
				
//				if (j == 0) {
//					System.out.print(chiffre);
//					chiffre++;
//				} else if (estDansTirsRecus(k) == true ){
//					System.out.print("là");
//				
//				} else {
//					System.out.print(estDansTirsRecus(k) + " ");
//					//System.out.print(" . ");
//				}
			
				/*
				if (estTouche(k)) { // case occupée et touchée
				System.out.print("#");
				} else if (contient(k)){  // case occupée mais non touchée
				System.out.print("X");
				}
				else if (estDansTirsRecus(k)){ // case libre + deja tirée
				System.out.print("O");
				}
				else { // libre + aucun tir
				System.out.print(".");
				}
				*/
			}
			System.out.println("");
		}
		return "";
	}
	
	
	public boolean ajouteNavire(Navire n) {
		GrilleNavale gn = new GrilleNavale(taille, nbNavires);
		
//		if ((this.touche(n))||(this.chevauche(n))||(n.getLigne() > gn.taille)||(n.getColonne() > gn.taille)){
//			return false;
//		}
//		// ajouter navire ? -> devient '#'
		return true;
	}
	
	
	public void placementAuto(int[] taillesNavires) {
		for (int i = 0; i < taillesNavires.length; i++) {
			Coordonnee al = new Coordonnee((int)Math.random() * 10, (int)Math.random() * 10);
			// 1 chance sur 2 d'avoir vrai ou faux
			Navire n = new Navire(al, taillesNavires[i], Math.random() < 0.5);
				while (taillesNavires[i] > 0){
					ajouteNavire(n); // ajouter a droite ou bas ou jsais pas quoi en fonction de vertOUhoriz
					i--;
				}
		}	
	}
	
	private boolean estDansGrille(Coordonnee c) {
		return ((c.getLigne() < this.taille) && (c.getColonne() < this.taille));
	}
	

	private boolean estDansTirsRecus(Coordonnee c) {
		boolean b = false;
		for (int i = 0; i < tirsRecus.length; i++) {
			if (c == tirsRecus[i]){
				b = true;
			} 
		}
		return b;
	}
	
	private boolean ajouteDansTirsRecus(Coordonnee c) {
		if (estDansTirsRecus(c)) {
			nbTirsRecus++;
			return false;
		} else {
			Coordonnee [] tab = new Coordonnee [tirsRecus.length + 1];
			int i;
			for (i = 0; i < tirsRecus.length; i++) {
				tab[i] = tirsRecus[i];
			}
			i++;
			tab[i] = c;
			tirsRecus = tab;
			nbTirsRecus++;
			return true;
		}
	}
	
//	
//	public boolean recoitTir(Coordonnee c) {
//		nbTirsRecus++;
//		// verifier position navire
//	}
//	public boolean estTouche(Coordonnee c) {
//		
//	}
//	public boolean estALEau(Coordonnee c) {
//		
//	}
//	public boolean estCoule(Coordonnee c) {
//		
//	}
//	public boolean perdu() {
//		
//	}
	
	
	
	public static void main(String[] args) {
		int []t = {3, 2, 4};
		GrilleNavale g1 = new GrilleNavale(10, t);
		GrilleNavale g2 = new GrilleNavale(10, 5);
		
//		GrilleNavale tailleTest = new GrilleNavale(taille, taillesNavires)
		g1.toString();
		//g2.toString();
		//Navire n1 = new Navire("C5", 2, true);
		//g1.ajouteDansTirsRecus(n1);

	}

}