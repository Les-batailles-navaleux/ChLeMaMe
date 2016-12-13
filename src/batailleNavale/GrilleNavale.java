package batailleNavale;

public class GrilleNavale  { // extends Navire
	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;
	
	public GrilleNavale(int taille, int[] taillesNavires) {
		this.taille = taille;
<<<<<<< HEAD
		taillesNavires = new int [nbNavires];
		navires = new Navire [taillesNavires.length];
		tirsRecus = new Coordonnee [0];
=======
		this.nbNavires = navires.length;					// nb navire = taille du tableau de navires
		this.nbTirsRecus = 0;								// initialisation des tirs reçus à 0
		this.tirsRecus = new Coordonnee[(taille*taille)]; 	// Nb de coups possible = taille de la grille
				
		for (int i = 0; i < this.nbNavires; i++) {
			// remplacer true par le placement automatique par la suite...
			this.navires[i] = new Navire(new Coordonnee("A1"), taillesNavires[i], true /*placementAuto(taillesNavires);*/); 
		}
>>>>>>> 45a30addeba014daadc71d0089da12b230be39b0
	}
	
	public GrilleNavale(int taille, int nbNavires) {
		this.taille = taille;
<<<<<<< HEAD
		this.nbNavires = nbNavires;
	}
//	
//	public GrilleNavale(int taille, int[] taillesNavires) {
//		this.taille = taille;
//		this.nbNavires = navires.length;					// nb navire = taille du tableau de navires
//		this.nbTirsRecus = 0;								// initialisation des tirs reçus à 0
//		this.tirsRecus = new Coordonnee[(taille*taille)]; 	// Nb de coups possible = taille de la grille
//				
//		for (int i = 0; i < this.nbNavires; i++) {
//			// remplacer true par le placement automatique par la suite...
//			this.navires[i] = new Navire(new Coordonnee("A1"), taillesNavires[i], true /*placementAuto(taillesNavires);*/); 
//		}
//	}
//	
//	public GrilleNavale(int taille, int nbNavires) {
//		this.taille = taille;
//		this.nbNavires = navires.length;
//	}
	
=======
		this.nbNavires = navires.length;
	}
>>>>>>> 45a30addeba014daadc71d0089da12b230be39b0
	
	
	public String toString() {
		for (int i = 0; i < taille; i++) {
			char c = (char) (i + 'A');
<<<<<<< HEAD
			System.out.print("  " + c);
		}
		System.out.println("");
		int chiffre = 1;
		for (int i = 0; i < this.taille; i++) {
			for (int j = 0; j <= this.taille; j++) {
				Coordonnee k = new Coordonnee(i, j);
				if (j == 0) {
					System.out.print(chiffre);
					chiffre++;
				} else if (estDansTirsRecus(k) == true ){
					System.out.print("là");
				} else {
					System.out.print(estDansTirsRecus(k) + " ");
					//System.out.print(" . ");
				}
			
=======
			System.out.print(c + " ");
		}
		System.out.println("");
		int chiffre = 0;
		for (int i = 1; i < this.taille; i++) {
			for (int j = 1; j < this.taille; j++) {
				if (j == 0) {
					System.out.println(chiffre);
				}
				Coordonnee k = new Coordonnee(i, j);
				System.out.print(". ");
>>>>>>> 45a30addeba014daadc71d0089da12b230be39b0
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
<<<<<<< HEAD
			System.out.println("");
		}
		return "";
	}
	
	/*
	public boolean ajouteNavire(Navire n) {
		GrilleNavale gn = new GrilleNavale(taille, nbNavires);
		if ((this.touche(n))||(this.chevauche(n))||(n.getLigne() > gn.taille)||(n.getColonne() > gn.taille)){
			return false;
		}
		// ajouter navire ? -> devient '#'
		return true;
	}
	
	public void placementAuto(int[] taillesNavires) {
		for (int i = 0; i < taillesNavires.length; i++) {
			Coordonnee al = new Coordonnee((int)Math.random() * 10, (int)Math.random() * 10);
=======
			//"\n";
			System.out.println("");
		}
		return " blabl ";
	} // TODO: compte des lignes
	
	
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
>>>>>>> 45a30addeba014daadc71d0089da12b230be39b0
			Navire n = new Navire(al, taillesNavires[i], Math.random() < 0.5);
				while (taillesNavires[i] > 0){
					ajouteNavire(n); // ajouter a droite ou bas ou jsais pas quoi en fonction de vertOUhoriz
					i--;
				}
		}	
	}
<<<<<<< HEAD
	*/
	private boolean estDansGrille(Coordonnee c) {
		return ((c.getLigne() < taille) && (c.getColonne() < taille));
=======
	
	private boolean estDansGrille(Coordonnee c) {
		return ((c.getLigne() < this.taille) && (c.getColonne() < this.taille));
>>>>>>> 45a30addeba014daadc71d0089da12b230be39b0
	}
	

	private boolean estDansTirsRecus(Coordonnee c) {
		boolean b = false;
<<<<<<< HEAD
		for (int i = 0; i < tirsRecus.length; i++)  {
			if (estDansGrille(c) && (c.equals(tirsRecus[i]))){
=======
		for (int i = 0; i < tirsRecus.length; i++) {
			if (c == tirsRecus[i]){
>>>>>>> 45a30addeba014daadc71d0089da12b230be39b0
				b = true;
			} 
		}
		return b;
	}
	
<<<<<<< HEAD
	
=======
>>>>>>> 45a30addeba014daadc71d0089da12b230be39b0
	private boolean ajouteDansTirsRecus(Coordonnee c) {
		if (estDansTirsRecus(c)) {
			nbTirsRecus++;
			return false;
		} else {
<<<<<<< HEAD
			Coordonnee [] tabPlusC = new Coordonnee [tirsRecus.length + 1];
			int i;
			for (i = 0; i < tirsRecus.length; i++) {
				tabPlusC[i] = tirsRecus[i];
			}
			tabPlusC[i] = c;
			tirsRecus = tabPlusC;
=======
			Coordonnee [] tab = new Coordonnee [tirsRecus.length + 1];
			int i;
			for (i = 0; i < tirsRecus.length; i++) {
				tab[i] = tirsRecus[i];
			}
			i++;
			tab[i] = c;
			tirsRecus = tab;
>>>>>>> 45a30addeba014daadc71d0089da12b230be39b0
			nbTirsRecus++;
			return true;
		}
	}
	
<<<<<<< HEAD
	
	public boolean recoitTir(Coordonnee c) {
		ajouteDansTirsRecus(c);
		// verifier position navire
		return true;
	}
	
	/*
	public boolean estTouche(Coordonnee c) {
		
	}
	public boolean estALEau(Coordonnee c) {
		
	}
	public boolean estCoule(Coordonnee c) {
		
	}
	public boolean perdu() {
		
	}
	
	*/
	
	public static void main(String[] args) {
		int [] tabTaillesNavire = {3, 2, 4};
		GrilleNavale g1 = new GrilleNavale(10, tabTaillesNavire);
		//GrilleNavale g2 = new GrilleNavale(10, 5);
		g1.toString();
		Coordonnee c1 = new Coordonnee(3,3);
		System.out.println("estDansGrille: " + g1.estDansGrille(c1));
		System.out.println("estDansTirsRecus: " + g1.estDansTirsRecus(c1));
		System.out.println("ajouteDansTirsRecus: " + g1.ajouteDansTirsRecus(c1));
		System.out.println("estDansTirsRecus: " + g1.estDansTirsRecus(c1));
		g1.toString();
		//g1.recoitTir(c1);
		//g1.toString();
		
=======
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
		int [] t = {3, 2, 4};
		GrilleNavale g1 = new GrilleNavale(10, t);
		GrilleNavale g2 = new GrilleNavale(10, 5);
		
//		GrilleNavale tailleTest = new GrilleNavale(taille, taillesNavires)
		g1.toString();
		//g2.toString();
>>>>>>> 45a30addeba014daadc71d0089da12b230be39b0
		//Navire n1 = new Navire("C5", 2, true);
		//g1.ajouteDansTirsRecus(n1);

	}

<<<<<<< HEAD
}
=======
}
>>>>>>> 45a30addeba014daadc71d0089da12b230be39b0
