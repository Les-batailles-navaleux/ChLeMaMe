package batailleNavale;

public class GrilleNavale {
	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;

	public GrilleNavale(int taille, int[] taillesNavires) {
		this.taille = taille;
		this.nbNavires = taillesNavires.length; // nb navire = taille du tableau
												// de navires
		this.nbTirsRecus = 0; // initialisation des tirs reçus à 0
		tirsRecus = new Coordonnee[0]; // mona: besoin pour methode tirs
		// this.tirsRecus = new Coordonnee[(taille*taille)]; // Nb de coups
		// possible = taille de la grille
		this.navires = new Navire[this.nbNavires];
		for (int i = 0; i < this.nbNavires; i++) {
			this.navires[i] = new Navire(new Coordonnee("A1"), taillesNavires[i],true /* placementAuto(taillesNavires); */);
		}
	}

	public GrilleNavale(int taille, int nbNavires) {
		this.taille = taille;
		this.nbNavires = nbNavires;
	}
	
	/*
	 * Le but de la version StrinBufer est de créer une "super" chaine de caractere contenant les coordonnées
	 * pour avoir les infos sur les bateaux et en dernier, formater la grille pour qu'elle soit humainement lisible
	 * 1) On bufferise des cases libre qui correspondent aux coordonnées comme par exemple avec une grille de 5x5:
	 * Ce qui donne sans espace entre les points:
	 * System.out.println(superGrille);  renvoie:  ".     .     .     .     .     .     .     . ................."  
	 * Chaque point correspont à une coordonné:	  <0,0> <0,1> <0,2> <0,3> <0,4> <1,0> <1,1> <1,2> etc..       <5,4>
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		int coteGrille = this.taille;
		StringBuffer superGrille = new StringBuffer();
		Coordonnee coordCourante = new Coordonnee(0,0);	// <0,0> coordonnée arbitraire
		
		// assurer une capacité d'au minimum la taille de la grille.
		superGrille.ensureCapacity(coteGrille*coteGrille+(2*coteGrille)); 		

		
		// ********** TODO boucle for de test à supprimer quandd code dev est finit  **********//
		// On bufferise les String "." dans un StringBufferà chaque itération
//		for (int i = 0; i < (this.taille*this.taille); i++) {	
//			tmp = ".";
//			superGrille.append(tmp);
//		}
//		System.out.println(superGrille);
		// ***********************  Fin boucle test *****************************//
		
		
		// *********************************************** code de dev ************************************** //
		int largeurGrille = 0;
		int colonne = 1;	
		int ligne = 1;
		
		// Décalage des lettres
		superGrille.append(" ");
		
		// Affichage des lettres
		for (int i = 0; i < coteGrille; i++) {
			char c = (char) (i + 'A');
			superGrille.append(c);
		}
		
		
		for (int ligneParc = 0; ligneParc < coteGrille; ligneParc++) {
			// retour chariot + N°ligne
			superGrille.append("\n"+(ligneParc+1));
				
			for (int colParc = 0; colParc < coteGrille; colParc++) {
												
				coordCourante = new Coordonnee(ligneParc+1, colParc+1); 
				
			
				if(estTouche(coordCourante)){
					superGrille.append("X");
				} 
				
				else if (!estDansTirsRecus(coordCourante) && !estALEau(coordCourante)){
					superGrille.append("#");
				} 
				
				else if (estDansTirsRecus(coordCourante) && estALEau(coordCourante)){
					superGrille.append("o");	
				}
				
				else if (!estDansTirsRecus(coordCourante) && estALEau(coordCourante)){
					superGrille.append(".");
				}

			} // end for colParc
			
		}	// end for ligneParc
		
//		// end TODO
//		}
		
		

		
		// ************************************ fin code dev ************************************** //	
		
		String s = superGrille+"";
		

//						//On parcourt le tableau de navire
//						for (int k = 0; k < navires.length; k++) {
//							// SI on rencontre un bateau non touché
//							if (this.navires[k].contient(currentCoord)){
//								System.out.print(" # ");
//							}
//							else{
//
//							}
//						}
					

					
				
//=======
//		for (int i = 0; i < taille; i++) { // affichage  Coordonnee colonnes (A, B, C,...)
//			char c = (char) (i + 'A');
//			System.out.print("  " + c);
//		}
//		System.out.println();
//		int chiffre = 1;
//		for (int i = 0; i < this.taille; i++) {
//			for (int j = 0; j <= this.taille; j++) {
//				Coordonnee k = new Coordonnee(i, j-1);
//				if (j == 0) { // Affichage numero des lignes
//					System.out.print(chiffre);
//					chiffre++;
//				} else if (estTouche(k)){ // case occupee par navire et touché
//					System.out.print(" X ");
//				} else if ((estDansTirsRecus(k)) && (!estTouche(k))){ // case libre mais touchee
//					System.out.print(" O ");
//				} else if ((!(estDansTirsRecus(k))) && (!estTouche(k))){ //case libre et non touchee
//					System.out.print(" # ");
//				} else { // case non libre et touchee par un bateau
//					System.out.print(" . ");
//				}
//>>>>>>> master
//			}
//			s=s+"\n";
//		}


		return s;
		}
	
	public boolean ajouteNavire(Navire n) {


		Navire[] n2 = new Navire[navires.length + 1];
	
		for (int i = 0; i < this.navires.length; i++) { // si touche ou chevauche: nop
			if((this.navires[i].chevauche(n) || this.navires[i].touche(n))){
				
				System.out.println("Erreur de coordonnées: le navire touche ou chevauche !");
				return false;
				}
			}
		
		if (!estDansGrille(n.getDebut()) || !estDansGrille(n.getFin())) { //si n hors grille :nop
			System.out.println("Erreur de coordonnées: le navire sort de la grille !");
			return false;
		} else { // sinon ajout de n dans navires
		
			int j;
			for (j = 0; j < n2.length - 1; j++) {
				n2[j] = navires[j];
			
			}
			n2[j] = n;
			navires = n2;
			nbNavires++;
		}
		System.out.println("Le navire '" +this.nbNavires+ "' a été ajouté !");
		return true;
	}
	
	public void placementAuto(int[] taillesNavires) {
		for (int i = 0; i < taillesNavires.length; i++) {
			Coordonnee al = new Coordonnee(((int)(Math.random()*(10-1))+1), ((int)(Math.random()*(10-1))+1)); 
		
			Navire n = new Navire(al, taillesNavires[i], Math.random() < 0.5);
			ajouteNavire(n);
		}
}
	
	/*
	 *  methode OK
	 */
	private boolean estDansGrille(Coordonnee c) {
		return ((c.getLigne() <= taille) && (c.getColonne() <= taille) && 
				(c.getLigne() > 0) && (c.getColonne() > 0)); //ligne >0 et colone >0
	}
	

	private boolean estDansTirsRecus(Coordonnee c) {
		for (int i = 0; i < tirsRecus.length; i++) {
			if (estDansGrille(c) && (c.equals(this.tirsRecus[i]))) {
				return true;
			}
		}
		return false;
}
	
	
	private boolean ajouteDansTirsRecus(Coordonnee c) {
		if (estDansTirsRecus(c)) {
			return false;
		} else {
			// creation tableau plus grand
			Coordonnee[] tabPlusC = new Coordonnee[tirsRecus.length + 1]; 
			int i;
			
			for (i = 0; i < tirsRecus.length; i++) {
				tabPlusC[i] = tirsRecus[i]; // recopie de l'ancien tableau
			}
		
			tabPlusC[i] = c; // insere nouveau navire
			tirsRecus = tabPlusC; // reassigne le nv tableau à l'ancien
			nbTirsRecus++;
			return true;
		}
}
	
	


	/*
	 * Ajoute c aux tirs reçus de this si nécessaire. Retourne true si et seulement si c ne
	 * correspondait pas déjà à un tir reçu et a permis de toucher un navire de  this.
	 */
	public boolean recoitTir(Coordonnee c) {
		
		//On verifie si un tir n'a pas déja été effectué a ces coordonnées
		if(estDansTirsRecus(c))throw new IllegalArgumentException("Tir déjà effectué à cette coordonnee");
		if(!estDansGrille(c))throw new IllegalArgumentException("Tir en dohors de la grille");
		
		// si il n'a pas encore était touché en c
		if (!estTouche(c)) {
			boolean touche=false;
			//on update le tableau partiesTouchees du navire
			for (int i = 0; i < this.nbNavires; i++){
				if (this.navires[i].recoitTir(c)) {
					touche=true;
				}
			}
			
			ajouteDansTirsRecus(c);
			return touche;
		}
		return false;
	}
	
	
	
	public boolean estTouche(Coordonnee c) {

		for (int i = 0; i < navires.length; i++) {
			if ((navires[i].estTouche(c))) {
				return true;
			}
		}
		return false;
}
	
	
	public boolean estALEau(Coordonnee c) { // en cours
		
		return (!estTouche(c));
	}

	public boolean estCoule(Coordonnee c) {
		boolean b = false;
		if (estTouche(c)) {
			for (int i = 0; i < nbNavires; i++) {
				if (navires[i].estTouche(c) && navires[i].estCoule()) {
					b = true;
				}
			}
		}
		return b;
}
	
	
	public boolean perdu() {
		for(int i = 0; i < nbNavires; i++){
			if(!navires[i].estCoule())
				return false;
			//renvoie vrai si tous les bateaux de navires sont coules
		}
		return true;
}
	
	
	public static void main(String[] args) {
		

		System.out.println("PARTIE TEST DU BRO-GRAMMEUR");
		int [] tabTaillesNaviresBro = {};
		
		GrilleNavale grilleBro = new GrilleNavale(5, tabTaillesNaviresBro);
		Coordonnee coorBro = new Coordonnee("B2");
		Coordonnee coorBro1 = new Coordonnee(1,1); //A1
		Coordonnee coorBro2 = new Coordonnee(2,2); //B2
		Coordonnee coorBro3 = new Coordonnee(4,3); //D3
		
		Coordonnee videTouche = new Coordonnee("C1"); // C2
		
		Navire navBro = new Navire(coorBro, 2, false);
		
		System.out.println("la coordonnée estDansGrille? " + grilleBro.estDansGrille(videTouche)+"\n");
		
		System.out.println("Tir sur une case vide: "+grilleBro.recoitTir(videTouche));
//		System.out.println("Tir sur une case vide N2: "+grilleBro.recoitTir(videTouche));
		
		System.out.println("Tir sur une case vide N2: "+grilleBro.recoitTir(coorBro));
		System.out.println("on ajoute un navire: " + grilleBro.ajouteNavire(navBro)+"\n");	
		
//		grilleBro.recoitTir(coorBro2);
		
//		System.out.println("La grille reçoit un tir: "+ grilleBro.recoitTir(coorBro1)+"\n");
//		System.out.println("La grille reçoit un tir: "+ grilleBro.recoitTir(coorBro2)+"\n");
//		System.out.println("La grille reçoit un tir: "+ grilleBro.recoitTir(coorBro3)+"\n");
		
		
		System.out.println(grilleBro.toString()+"\n");
		System.out.println();
		
		
		System.out.println(" /*****************************************/ ");
				
//		System.out.println("PARTIE TEST DES BRO-GRAMMEUSES");
//		int[] tabTaillesNavires = { 3, 2, 4 };
//		GrilleNavale g1 = new GrilleNavale(10, tabTaillesNavires);
//		// g1.toString();
//		Coordonnee c1 = new Coordonnee("C3");
//		Coordonnee c2 = new Coordonnee("C4"); // hors grille
//		Coordonnee c3 = new Coordonnee("C5");
//		Coordonnee c4 = new Coordonnee("C6");
//		// System.out.println("c1: " + c1);
//		// System.out.println("c1 estDansGrille: " + g1.estDansGrille(c1));
//		Navire n1 = new Navire(c1, 5, true);
//		Navire n2 = new Navire(c2, 2, true); // hors grille
//		Navire n3 = new Navire(c3, 5, true); // touche
//		Navire n4 = new Navire(c4, 5, false); // chevauche
//		System.out.println("ajoutNav: " + g1.ajouteNavire(n1)); // ok: renvoie
//																// vrai
//
//		System.out.println("case touche : " + g1.estTouche(c1));
//		System.out.println("case touche : " + g1.estTouche(c2));
//		System.out.println("case touche : " + g1.estTouche(c4));
//		System.out.println("case coule : " + g1.estCoule(c3));

		// System.out.println("ajoutNav: " + g1.ajouteNavire(n2)); //ok: hors
		// grille: renvoie false
		// System.out.println("ajoutNav: " + g1.ajouteNavire(n3)); //ok: touche:
		// false
		// System.out.println("ajoutNav: " + g1.ajouteNavire(n4)); //ok:
		// chevauche: false
		// // System.out.println("estDansTirsRecus: " +
		// g1.estDansTirsRecus(c1)); //ok: renvoie faux
		// System.out.println("estDansTirsRecus: " + g1.estDansTirsRecus(c2));
		// //faudrait lever une exception car hors cadre de tte facon
		// System.out.println("estTouchéc1: " + g1.estTouche(c1)); // ok: y a
		// un nav et retourne true
		// System.out.println("estTouchéc5: " + g1.estTouche(c5)); // ok: y a
		// pas de nav et retourne false
		// System.out.println("recoitTirc1: " + g1.recoitTir(c1)); // ok:
		// retourne vrai car estTouche pour la 1ere fois
		// System.out.println("recoitTirc1: " + g1.recoitTir(c1)); // ok:
		// retourne faux car c1 a déjà été touché
		// System.out.println("recoitTirc5: " + g1.recoitTir(c5)); // ok:
		// retourne faux car pas nav

		// g1.toString();
		// System.out.println("n1 ajouteNavire: " + g1.ajouteNavire(n1));
		// g1.toString();
		// g1.placementAuto(tabTaillesNavires);
		// g1.toString();
		// System.out.println("estDansTirsRecus: " + g1.estDansTirsRecus(c1));
		// System.out.println("ajouteDansTirsRecus: " +
		// g1.ajouteDansTirsRecus(c1));
		// System.out.println("estDansTirsRecus: " + g1.estDansTirsRecus(c1));
		// g1.recoitTir(c1);

		// Coordonnee c1 = new Coordonnee("C3");
		// Navire n1 = new Navire(c1, 2, true);
		// g1.ajouteNavire(n1);
		//
		// System.out.println("c1 estDansGrille: " + g1.estDansGrille(c1));
		// System.out.println("on ajoute un navire: " + g1.ajouteNavire(n1));
		//
		// g1.toString();

		// g1.toString();

		// System.out.println("estDansTirsRecus: " + g1.estDansTirsRecus(c1));
		// System.out.println("ajouteDansTirsRecus: " +
		// g1.ajouteDansTirsRecus(c1));
		// System.out.println("estDansTirsRecus: " + g1.estDansTirsRecus(c1));
		// g1.toString();
		// System.out.println("tabTirsRecus" + g1.tirsRecus[0]);
		// g1.recoitTir(c1);

		// g1.placementAuto(tabTaillesNavires);
		// g1.toString();

	}
}