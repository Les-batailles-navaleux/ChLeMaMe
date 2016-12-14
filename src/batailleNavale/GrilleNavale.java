package batailleNavale;

public class GrilleNavale {
	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;
	
	public GrilleNavale(int taille, int[] taillesNavires) {
		this.taille = taille;

		this.nbNavires = taillesNavires.length;			    // nb navire = taille du tableau de navires
		this.nbTirsRecus = 0;								// initialisation des tirs reçus à 0
		this.tirsRecus = new Coordonnee[(taille*taille)]; 	// Nb de coups possible = taille de la grille
		
		this.navires = new Navire[this.nbNavires];
		
		for (int i = 0; i < this.nbNavires; i++) {
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
        
		for (int i = 0; i < taille; i++) {
			char c = (char) (i + 'A');
			System.out.print("  " + c);
		}
		
		System.out.println();
		int chiffre = 1;
		
		// Afichage lignes 
		for (int i = 0; i < this.taille; i++) {
			
			//Affichage colones
			for (int j = 0; j <= this.taille; j++) {
				
				// On affiche les chiffres des lignes en premier
				if (j == 0) {
					System.out.print(chiffre);
					chiffre++;
				} else {
					
					// Ensuite qd j==1, on sauvegarde la coordonnée courante(i,j)
					Coordonnee currentCoord = new Coordonnee(i,j);
					
					//Si on rencontre un bateau
					for (int k = 0; k < navires.length; k++) {
						if (this.navires[k].contient(currentCoord)) {
							System.out.println("#");
						}else{
							System.out.print(" . ");
							}
						}
					}
				
				
				
//				else if (estDansTirsRecus(k)){
//				
//					System.out.print(k);
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

//		Coordonnee coordDebN = new Coordonnee(n.getDebut().toString());
//		Coordonnee coordFinN = new Coordonnee(n.getDebut().toString());
		
		if (!estDansGrille(n.getDebut()) || !estDansGrille(n.getFin())) { //si n hors grille
			return false;
//		} else if ((touche(n))||(chevauche(n))){ //si n touche ou chevauche
//			return false;
		} else { // ajout de n dans navires
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
			Coordonnee al = new Coordonnee((int)Math.random() * 10, (int)Math.random() * 10);
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
			nbTirsRecus++;
			return false;
		} else {
			Coordonnee [] tabPlusC = new Coordonnee [tirsRecus.length + 1];
			int i;
			for (i = 0; i < tirsRecus.length; i++) {
				tabPlusC[i] = tirsRecus[i];
			}
			tabPlusC[i] = c;
			tirsRecus = tabPlusC;
			nbTirsRecus++;
			return true;
		}
	}
	
	
	public boolean recoitTir(Coordonnee c) { // en cours
		//if (!(estDansTirsRecus(c)) && ) {
			
		//}
		ajouteDansTirsRecus(c);
		return true;
	}
	
	
	public boolean estTouche(Coordonnee c) {
		recoitTir(c);
		if ((estDansTirsRecus(c)) && (estTouche(c))) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean estALEau(Coordonnee c) {
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
		
		
		Coordonnee c1 = new Coordonnee("C3");
		Navire n1 = new Navire(c1, 2, true);
		g1.ajouteNavire(n1);
		
		System.out.println("c1 estDansGrille: " + g1.estDansGrille(c1));
		System.out.println("on ajoute un navire: " + g1.ajouteNavire(n1));
		
		g1.toString();
		
		
		//g1.toString();
		
//		System.out.println("estDansTirsRecus: " + g1.estDansTirsRecus(c1));
//		System.out.println("ajouteDansTirsRecus: " + g1.ajouteDansTirsRecus(c1));
//		System.out.println("estDansTirsRecus: " + g1.estDansTirsRecus(c1));
//		g1.toString();
//		System.out.println("tabTirsRecus" + g1.tirsRecus[0]);
		//g1.recoitTir(c1);

		
	
//		g1.placementAuto(tabTaillesNavires);
//		g1.toString();

	}

}