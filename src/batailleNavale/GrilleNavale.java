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
			this.navires[i] = new Navire(new Coordonnee("A1"), taillesNavires[i],
					true /* placementAuto(taillesNavires); */);
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
		String tmp="";
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
		
		for (int i = 1; i < ((coteGrille*coteGrille)+1); i++) {
			
			// nouvelle référence vers l'objet à chaque itération (éco de mémoire)
			coordCourante = new Coordonnee(ligne, colonne); 
			
			if (i == largeurGrille+coteGrille) {
				largeurGrille += coteGrille;
				colonne++;
				ligne = 0;
				}
			ligne++;
			
			//test de vérification d'affichage/formatage des objets Coordonnées 
			//System.out.println("coord: "+coordCourante);
			
			// On va maintenant travailler avec l'objet coordCourante et modifier la chaine superGrille en fonction
			// des valeurs retournées par les méthodes.
			
			
		// TODO implémenter tous le bordel de test: tirRecu?bateau? etc ..			
			// condition: coordCourante contenue dans tir reçus ?
//			if(estDansTirsRecus(coordCourante)){
//				superGrille.insert(i,"O");
//			};
//			
			
			
			
			
			
			// condition: coordCourante est bateau?
			// Si oui bateau endommagé ?
						
					
			// sinon, si les test précédent sont négatif, c'est une case vide		
			tmp = ".";
			superGrille.append(tmp);
		// end TODO
		}
		
		
		// Insertion des retour à la ligne, on part de la fin de la chaine
		// TODO possibilité d'intégrer cette boucle dans la précédente. ou pas ?!
		int kTmp = coteGrille*coteGrille;
		for (int k = coteGrille*coteGrille; k >= 0; k--) {
			
			if(k==kTmp-coteGrille){
								
				// Insertion à lindice k, un \n et le numero de la ligne				
				superGrille.insert(k,"\n"+((k+coteGrille)/coteGrille));
				kTmp -= coteGrille;
			}
			
			if (k==0) {
				for (int i = coteGrille; i > 0; i--) {
					char c = (char) (i-1 + 'A');
					superGrille.insert(k,c);
				}
			}
		}
		superGrille.insert(0," "); // ajouter un espace pour le décallage des lettre des colones
		
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
			// marche jusqu'à 10
			Coordonnee al = new Coordonnee((int) Math.random() * 10, (int) Math.random() * 10); 
			Navire n = new Navire(al, taillesNavires[i], Math.random() < 0.5);
			ajouteNavire(n);
		}
}
	
	/*
	 *  methode OK
	 */
	private boolean estDansGrille(Coordonnee c) {
		return ((c.getLigne() < taille) && (c.getColonne() < taille)); 
//		return ((c.getLigne() <= this.taille) && (c.getColonne() <= this.taille));
	}
	

	private boolean estDansTirsRecus(Coordonnee c) {
		for (int i = 0; i < tirsRecus.length; i++) {
			if (estDansGrille(c) && (c.equals(tirsRecus[i]))) {
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
	
	
	public boolean recoitTir(Coordonnee c) {
		boolean b = false;
		for (int i = 0; i < navires.length; i++) {
			if ((!(estDansTirsRecus(c))) && (navires[i].estTouche(c))) {
				ajouteDansTirsRecus(c);
				b = true;
			} else {
				b = false;
			}
		}
		return b;
}
//		boolean b = false;
//		for (int i = 0; i < navires.length; i++)
//			if ((navires[i].recoitTir(c)) && (!(estDansTirsRecus(c)))) {
//				ajouteDansTirsRecus(c);
//				b = true;
//			} else if ((navires[i].recoitTir(c)) && ((estDansTirsRecus(c)))) {
//				b = false;
//			} else {
//				ajouteDansTirsRecus(c);
//				b = false;
//			}
//		return b;
	
	
	
	public boolean estTouche(Coordonnee c) {
		boolean b = false;
		for (int i = 0; i < navires.length; i++) {
			if ((navires[i].estTouche(c))) {
				b = true;
			}
		}
		return b;
}
	
	
	public boolean estALEau(Coordonnee c) { // en cours
		if(estTouche(c)){
			return false;
		}
		return true;
	}

	public boolean estCoule(Coordonnee c) {
		boolean b = false;
		if (estTouche(c)) {
			for (int i = 0; i < nbNavires; i++) {
				if (navires[i].estCoule()) {
					b = true;
					;
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
		int [] tabTaillesNavires1 = {3, 2, 4};
		GrilleNavale gToine = new GrilleNavale(5, tabTaillesNavires1);
		
		
		Coordonnee cToine = new Coordonnee("B5");
		Navire nToine = new Navire(cToine, 2, true);
		gToine.ajouteNavire(nToine);
		
		System.out.println("la coordonnée estDansGrille? " + gToine.estDansGrille(cToine));
		System.out.println("on ajoute un navire: " + gToine.ajouteNavire(nToine));
		
		System.out.println(gToine.toString());
		System.out.println(" /*****************************************/");
		
		
		System.out.println("PARTIE TEST DES BRO-GRAMMEUSES");
		int[] tabTaillesNavires = { 3, 2, 4 };
		GrilleNavale g1 = new GrilleNavale(10, tabTaillesNavires);
		// g1.toString();
		Coordonnee c1 = new Coordonnee("C3");
		Coordonnee c2 = new Coordonnee("C4"); // hors grille
		Coordonnee c3 = new Coordonnee("C5");
		Coordonnee c4 = new Coordonnee("C6");
		// System.out.println("c1: " + c1);
		// System.out.println("c1 estDansGrille: " + g1.estDansGrille(c1));
		Navire n1 = new Navire(c1, 5, true);
		Navire n2 = new Navire(c2, 2, true); // hors grille
		Navire n3 = new Navire(c3, 5, true); // touche
		Navire n4 = new Navire(c4, 5, false); // chevauche
		System.out.println("ajoutNav: " + g1.ajouteNavire(n1)); // ok: renvoie
																// vrai

		System.out.println("case touche : " + g1.estTouche(c1));
		System.out.println("case touche : " + g1.estTouche(c2));
		System.out.println("case touche : " + g1.estTouche(c4));
		System.out.println("case coule : " + g1.estCoule(c3));

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