package batailleNavale;

public class GrilleNavale {
	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;
	
	public GrilleNavale(int taille, int[] taillesNavires) {
		this.taille = taille;

		this.nbNavires = taillesNavires.length;			        // nb navire = taille du tableau de navires
		this.nbTirsRecus = 0;								                // initialisation des tirs reçus à 0
		tirsRecus = new Coordonnee[0]; // mona: besoin pour methode tirs
		//this.tirsRecus = new Coordonnee[(taille*taille)]; 	// Nb de coups possible = taille de la grille
		
		this.navires = new Navire[this.nbNavires];
		
		for (int i = 0; i < this.nbNavires; i++) {
			// remplacer true par le placement automatique par la suite...
			this.navires[i] = new Navire(new Coordonnee("A1"), taillesNavires[i], true /*placementAuto(taillesNavires);*/); 
		}

		//taillesNavires = new int [nbNavires];
		//navires = new Navire [taillesNavires.length];
		//tirsRecus = new Coordonnee [0];

	}
	
	public GrilleNavale(int taille, int nbNavires) {
		this.taille = taille;
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
    
// <<<<<<< Debut dev Antoine ( car pas sur de ce qu'il faut garder ou non )
/*		
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
				
*/
    
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
// ======= Fin dev Antoine
        
		for (int i = 0; i < taille; i++) { // affichage  Coordonnee colonnes (A, B, C,...)
			char c = (char) (i + 'A');
			System.out.print("  " + c);
		}
		System.out.println("");
		int chiffre = 1;
		for (int i = 0; i < this.taille; i++) {
			for (int j = 0; j <= this.taille; j++) {
				Coordonnee k = new Coordonnee(i, j-1);
				if (j == 0) { // Affichage chiffre numero des lignes
					System.out.print(chiffre);
					chiffre++;
				} else if (estTouche(k)){ // case occupee par navire et touché
					System.out.print(" X ");
				} else if ((estDansTirsRecus(k)) && (!estTouche(k))){ // case libre mais touchee
					System.out.print(" O ");
				} else if ((!(estDansTirsRecus(k))) && (!estTouche(k))){ //case libre et non touchee
					System.out.print(" # ");
				} else { // case non libre et touchee par un bateau
					System.out.print(" . ");
				}
			}
			System.out.println("");
		}
		return "";
	}
	
	
	public boolean ajouteNavire(Navire n) {
		GrilleNavale gn = new GrilleNavale(taille, nbNavires);
		
		if (!estDansGrille(n.getDebut()) || !estDansGrille(n.getDebut())) { //si n hors grille
			return false;
		} /*else if ((touche(n))||(chevauche(n))){ //si n touche ou chevauche
			return false;
		} */else { // ajout de n dans navires
			for (int i = 0; i < navires.length; i++) {
				if (navires[i] == null) { 
				navires[i]= n;
				break;
				}
			}
		}
		return true;
	}
	
	
	public void placementAuto(int[] taillesNavires) {
		for (int i = 0; i < taillesNavires.length; i++) {
			Coordonnee al = new Coordonnee((int)Math.random() * 10, (int)Math.random() * 10); // marche jusqu'à 10 :x
			Navire n = new Navire(al, taillesNavires[i], Math.random() < 0.5);	
			ajouteNavire(n);
		}
	}
	
	private boolean estDansGrille(Coordonnee c) {
		return ((c.getLigne() < taille) && (c.getColonne() < taille));
	}
	

	private boolean estDansTirsRecus(Coordonnee c) {
		boolean b = false;
		for (int i = 0; i < tirsRecus.length; i++)  {
			if (estDansGrille(c) && (c.equals(tirsRecus[i]))){
				b = true;
			} 
		}
		return b;
	}
	
	
	private boolean ajouteDansTirsRecus(Coordonnee c) {
		if (estDansTirsRecus(c)) {
			//nbTirsRecus++;
			return false;
		} else {
			Coordonnee [] tabPlusC = new Coordonnee [tirsRecus.length + 1];
			int i;
			for (i = 0; i < tirsRecus.length; i++) {
				tabPlusC[i] = tirsRecus[i];
			}
			tabPlusC[i] = c;
			tirsRecus = tabPlusC;
			// System.out.println("tirsRecusLong " +tirsRecus[0]);
			nbTirsRecus++;
			return true;
		}
	}
	
	
	public boolean recoitTir(Coordonnee c) {
		if (estDansTirsRecus(c)) {
			return true;
		} else  {
			ajouteDansTirsRecus(c);
			return false;
		}
	}
	
	
	public boolean estTouche(Coordonnee c) { // en cours
		//doit ajouterDansTirs
		if ((recoitTir(c)) && (this.estTouche(c))) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean estALEau(Coordonnee c) { //en cours
		recoitTir(c);
		if ((estDansTirsRecus(c)) && !(estTouche(c))) {
			return true;
		} else {
			return false;
		}
	}
	
	
	//public boolean estCoule(Coordonnee c) {
		//recoitTir(c);
		//if ((estDansTirsRecus(c)) && (estTouche(c)) && ()) {
		//	return true;
		//} else {
		//	return false;
		//}
		
	//}
	
	/*
	public boolean perdu() {
		
	}
	*/
	
	public static void main(String[] args) {
		int [] tabTaillesNavires = {3, 2, 4};
		GrilleNavale g1 = new GrilleNavale(10, tabTaillesNavires);
		g1.toString();
		
		Coordonnee c1 = new Coordonnee(3, 3);
		System.out.println("c1: " + c1);
		System.out.println("c1 estDansGrille: " + g1.estDansGrille(c1));
		
		// Navire n1 = new Navire(c1, 2, true);
		//System.out.println("n1 ajouteNavire: " + g1.ajouteNavire(n1));
		// g1.toString();
		// g1.placementAuto(tabTaillesNavires);
		// g1.toString();
		
		System.out.println("estDansTirsRecus: " + g1.estDansTirsRecus(c1));
		System.out.println("ajouteDansTirsRecus: " + g1.ajouteDansTirsRecus(c1));
		System.out.println("estDansTirsRecus: " + g1.estDansTirsRecus(c1));
		
		
		
		g1.toString();
		// System.out.println("tabTirsRecus" + g1.tirsRecus[0]);
		//g1.recoitTir(c1);

	}

}