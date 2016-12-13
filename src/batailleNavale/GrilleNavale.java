package batailleNavale;

public class GrilleNavale  { // extends Navire
	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;
	
	public GrilleNavale(int taille, int[] taillesNavires) {
		this.taille = taille;
		taillesNavires = new int [nbNavires];
		navires = new Navire [taillesNavires.length];
		tirsRecus = new Coordonnee [0];
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
	
	
	
	public String toString() {
		for (int i = 0; i < taille; i++) {
			char c = (char) (i + 'A');
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
			Navire n = new Navire(al, taillesNavires[i], Math.random() < 0.5);
				while (taillesNavires[i] > 0){
					ajouteNavire(n); // ajouter a droite ou bas ou jsais pas quoi en fonction de vertOUhoriz
					i--;
				}
		}	
	}
	*/
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
		
		//Navire n1 = new Navire("C5", 2, true);
		//g1.ajouteDansTirsRecus(n1);

	}

}
