package batailleNavale;

public class GrilleNavale {
	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;

	public GrilleNavale(int taille, int[] taillesNavires) {
		this.taille = taille;
		
		// nb navire = taille du tableau de navires
		this.nbNavires = 0;//taillesNavires.length; 

		// initialisation des tirs reçus à 0
		this.nbTirsRecus = 0; 
		
		// mona: besoin pour methode tirs
		this.tirsRecus = new Coordonnee[taille*taille]; 
		// this.tirsRecus = new Coordonnee[(taille*taille)]; // Nb de coups
		// possible = taille de la grille
		this.navires = new Navire[taillesNavires.length];
	
		
		// commenter si on ne veut pas du placement automatique
		placementAuto(taillesNavires);
	}

	public GrilleNavale(int taille, int nbNavires) {
		this.taille = taille;
		this.navires = new Navire[nbNavires];
		this.nbNavires = 0;
		this.tirsRecus = new Coordonnee[0];

		// antoine: besoin pour methode tirs
		//this.tirsRecus = new Coordonnee[taille*taille]; 
		//this.nbTirsRecus = 0;

	}
	
//	public void placementAuto(int[] taillesNavires) {
//		for (int i = 0; i < taillesNavires.length; i++) {
//
//			// marche jusqu'à 10
//			Coordonnee al = new Coordonnee((int) (Math.random() * (taille - taillesNavires[i]))+1,(int) (Math.random() * (taille - taillesNavires[i])+1));
//
//			Navire n = new Navire(al, taillesNavires[i], Math.random() < 0.5);
//			ajouteNavire(n);
//		}
//	}
//	
	
	public void placementAuto(int[] taillesNavires) {		
		int i = 0;
		while(i < taillesNavires.length) {
			int nbNaviresInit = this.nbNavires;	// Nomre de navires avant la cr�ation d'un nouveau navire qui sera plac� al�atoirement
			boolean estVertical = (Math.random() < 0.5);
			Coordonnee c = new Coordonnee((int)(Math.random() * (taille - taillesNavires[i])), (int)(Math.random() * (taille - taillesNavires[i])));
			Navire n = new Navire(c, taillesNavires[i], estVertical);
			this.ajouteNavire(n);
			if(this.nbNavires > nbNaviresInit)
				i++;
}
	}

	/*
	 * La StringBufer va créer une chaine de caractere contenant les coordonnées pour avoir les infos sur les 
	 * bateaux et formater la grille avec les indices de lignes et de colone et les retour à la ligne
	 * On bufferise des cases en vérifiant leur état.
	 * La coordonnée parcourue est récupérée via les indices de parcourt des boucles for
	 */
	public String toString() {
		
		int coteGrille = this.taille;
		StringBuffer superGrille = new StringBuffer();
		Coordonnee coordCourante = new Coordonnee(0,0);	// <0,0> coordonnée arbitraire
		
		// assurer la capacité de la taille totale de la grille: n*n+(2n+1)
		superGrille.ensureCapacity(coteGrille*coteGrille+(2*coteGrille+1)); 		

		// Décalage des lettres
		superGrille.append(" ");
		
		// Affichage des lettres
		for (int i = 0; i < coteGrille; i++) {
			char c = (char) (i + 'A');
			superGrille.append("\t"+c);
		}
		
		
		for (int ligneParc = 0; ligneParc < coteGrille; ligneParc++) {
			// retour chariot + N°ligne
			superGrille.append("\n"+(ligneParc+1));
				
			for (int colParc = 0; colParc < coteGrille; colParc++) {
				boolean dejaTire = false;
				coordCourante = new Coordonnee(ligneParc+1, colParc+1);
				
				// TirRecu ? ->  oui
				if(estDansTirsRecus(coordCourante)){
					if (estALEau(coordCourante)) {
						dejaTire = true;
						superGrille.append("\to");	
						
					}else if(estTouche(coordCourante)){
						dejaTire = true;
						superGrille.append("\tX");
					}
				// TirRecu ? -> non
				} else {
					// Sinon si on est pas dans tirReçu  
					for (int i = 0; i < nbNavires; i++) {
						// On parcourt le tableau des coorodnnées des bateaux
						if(navires[i].contient(coordCourante) && dejaTire == false){
							dejaTire = true;
							superGrille.append("\t#");
							break;
							}
					}
					
					if(dejaTire==false){
						superGrille.append("\t.");
					}
				}
			} // end for colParc
		}	// end for ligneParc
		
		String s = superGrille+"";
		return s;
	}
	
	public boolean ajouteNavire(Navire n) {
		
		if(navires.length == nbNavires){
			System.out.println(" Tableau plein");
			return false;
		}

		if (!estDansGrille(n.getDebut()) || !estDansGrille(n.getFin())) { //si n hors grille :nop
			return false;
		}
		else{
			if(this.nbNavires==0){
				this.navires[0]=n;
				this.nbNavires+=1;
			}else{
		
				System.out.println("nbnavire:"+ this.nbNavires);
				System.out.println("case:"+ this.navires.length);
				
				for (int i = 0; i < this.nbNavires; i++) { // si touche ou chevauche: nop
					System.out.println("nBnavires: "+ nbNavires);
					System.out.println("navires: "+ navires[i]);
					if((this.navires[i].chevauche(n) || this.navires[i].touche(n))){
						//throw new Exception("Erreur de coordonnées: le navire touche ou chevauche !");
						return false;
					}
				}
				navires[nbNavires] = n;
				nbNavires++;
			}
				//System.out.println("Le navire '" +this.nbNavires+ "' a été ajouté !");
		return true;
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
		for (int i = 0; i < nbTirsRecus; i++) {
			if (estDansGrille(c) && (c.equals(this.tirsRecus[i]))) {
				return true;
			}
		}
		return false;
}
	
	
	private boolean ajouteDansTirsRecus(Coordonnee c) {
		

		if (!estDansTirsRecus(c)) {		
			this.tirsRecus[nbTirsRecus] = c;
			nbTirsRecus+=1;
			return true; // this est modifié, on renvoie true
		}
			return false;
		
}
	

	/*
	 * Ajoute c aux tirs reçus de this si nécessaire. Retourne true si et seulement si c ne
	 * correspondait pas déjà à un tir reçu et a permis de toucher un navire de  this.
	 */
	public boolean recoitTir(Coordonnee c) {
		
		//On verifie si un tir n'a pas déja été effectué a ces coordonnées
		//if(estDansTirsRecus(c))throw new IllegalArgumentException("Tir déjà effectué à cette coordonnee");
		if(!estDansGrille(c))throw new IllegalArgumentException("Tir en dohors de la grille");
		
		// si il n'a pas encore était touché en c
		if (!estTouche(c)) {
			boolean touche=false;

			ajouteDansTirsRecus(c);

			//on update le tableau partiesTouchees du navire
			for (int i = 0; i < this.nbNavires; i++){
				if (this.navires[i].recoitTir(c)) {
					touche=true;
				}
			}
	
//			ajouteDansTirsRecus(c);
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
		
		return (!this.estTouche(c));
	}

	public boolean estCoule(Coordonnee c) {
		
		if (this.estTouche(c)) {
			for (int i = 0; i < this.navires.length; i++) {
				if (this.navires[i].estTouche(c) && this.navires[i].estCoule()) {
					return true;
				}
			}
		}
		return false;
}
	
	
	public boolean perdu() {
		for(int i = 0; i < this.navires.length; i++){
			if(!this.navires[i].estCoule())
				return false;
			//renvoie vrai si tous les bateaux de navires sont coules
		}
		return true;
}
	
	
	public static void main(String[] args) {
		

		System.out.println("PARTIE TEST DU BRO-GRAMMEUR");
		int [] tabTaillesNaviresBro = {2};
		
//		GrilleNavale grilleBro = new GrilleNavale(5, tabTaillesNaviresBro);
		GrilleNavale grilleBro2 = new GrilleNavale(5, 1);
		
		Coordonnee coorBro = new Coordonnee("B2");
		Coordonnee coorTirSurBro = new Coordonnee("C2");
		Coordonnee coorBro1 = new Coordonnee(1,1); //A1
		Coordonnee coorBro2 = new Coordonnee(2,2); //B2
		Coordonnee coorBro3 = new Coordonnee(4,3); //D3
//		
		Coordonnee videTouche = new Coordonnee("C1"); // C1
		Coordonnee tirSurBro = new Coordonnee("C2");
//		
		Navire navBro = new Navire(coorBro, 2, false);
		
//		System.out.println("la coordonnée estDansGrille? " + grilleBro.estDansGrille(videTouche)+"\n");
		System.out.println("la coordonnée estDansGrille? " + grilleBro2.estDansGrille(videTouche)+"\n");
		
		
//		System.out.println("Tir sur une case vide: "+grilleBro.recoitTir(videTouche));
//		System.out.println("Tir sur une case vide N2: "+grilleBro.recoitTir(videTouche));
		
//		System.out.println("Tir sur une case vide N2: "+grilleBro.recoitTir(coorBro));
		
//		System.out.println("on ajoute un navire: " + grilleBro.ajouteNavire(navBro)+"\n");
		System.out.println("on ajoute un navire: " + grilleBro2.ajouteNavire(navBro)+"\n");
//		System.out.println("on tir sur le bateau en C2: "+ grilleBro2.recoitTir(coorTirSurBro)+"\n");
		

		
		
//		System.out.println(grilleBro.toString()+"\n");
		System.out.println(grilleBro2.toString()+"\n");
		
		System.out.println();
//		System.out.println(" /*****************************************/ ");
				
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