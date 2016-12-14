package batailleNavale;

public class Navire {
	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees;

	
	/*
	 *  Constructeur Navire: le navire est placé en fonction de son début, de la gauche vers la droite et du haut vers le bas
	 *  @param: type Coordonnée: coordonnées de début
	 *  		int longueur: longueur du bateau
	 *  		boolean estVertical: indique si le bateau doit etre placé verticalement ou horizontalement
	 */
	public Navire(Coordonnee debut, int longueur, boolean estVertical) {
		this.debut = debut;
//		if (estVertical) {
//			// -1 car on compte de 0 à n-1, a voir
//			this.fin = new Coordonnee(this.debut.getLigne() + longueur-1, this.debut.getColonne());  
//		}else{
//			this.fin = new Coordonnee(this.debut.getLigne(), this.debut.getColonne() + longueur - 1);
//		}
//		
		// la puissance ternaire en 1 ligne .. ou presque
		this.fin = estVertical ? new Coordonnee(this.debut.getLigne() + longueur-1, this.debut.getColonne()) : // estVertical
								 new Coordonnee(this.debut.getLigne(), this.debut.getColonne() + longueur - 1);// sinon horizontal
		
		this.partiesTouchees = new Coordonnee[longueur];
		this.nbTouchees = 0;
	}
	
	public String toString() {

//		String s1 = "";
//		String s2 ="";

		String s1 = "Navire (" + this.debut.toString() + ", ";
		// opérateur ternaire OP
		String s2 = this.debut.getColonne()==this.fin.getColonne() ?((this.fin.getLigne() - (this.debut.getLigne()) + 1)) + ", Vertical)" :
															((this.fin.getColonne() - (this.debut.getColonne()) + 1)) + ", Horizontal)";
		

//		// si le début et la fin de la colone son la même lettre alors vertical, sinon horizontal
//		if (this.debut.getColonne() == this.fin.getColonne()) {
//			// +1 pour compenser le longueur -1 incompris du constructeur Navire()
//			s2 = ((this.fin.getLigne() - (this.debut.getLigne()) + 1)) + ", Vertical)";
//		} else {			
//			
//			s2 = ((this.fin.getColonne() - (this.debut.getColonne()) + 1)) + ", Horizontal)";
//		}
			return (s1+s2);
		
	}

	public Coordonnee getDebut() {
		return debut;
	}

	public Coordonnee getFin() {
		return fin;
	}
	
	
	public boolean contient(Coordonnee c) {
		if ((c.getColonne() - this.debut.getColonne() == 0) || (c.getColonne() - this.fin.getColonne() == 0)) {
			// c et this sont sur la meme colonne
			if ((c.getLigne() >= this.debut.getLigne()) && (c.getLigne() <= this.fin.getLigne())) {
				// Ligne de c est est situee entre debut et fin de ligne de navire (debut et fin inclus)
				return true;
			}
		}
		else if ((c.getLigne() - this.debut.getLigne() == 0) || (c.getLigne() - this.fin.getLigne() == 0)) {
//			c et this sont sur la meme ligne
			if ((c.getColonne() >= this.debut.getColonne()) && (c.getColonne() <= this.fin.getColonne())) {
				// Colonne de c est est situee entre debut et fin de colonne de navire (debut et fin inclus)
				return true;
			}
		}
		return false;
	}

//	public boolean touche(Navire n) {
//		if (((n.fin.getLigne() + 1 == this.debut.getLigne()
//			|| n.debut.getLigne() == this.fin.getLigne() + 1)
//			&&(n.debut.getColonne() <= this.fin.getColonne() && n.fin.getColonne() >= this.debut.getColonne()))	
//			||
//			(n.fin.getColonne() + 1 == this.debut.getColonne() 
//			|| n.debut.getColonne() == this.fin.getColonne() + 1)
//			&&(n.debut.getLigne() <= this.fin.getLigne() && n.fin.getLigne() >= this.debut.getLigne()))
//			return true;
//		return false;
//	}
//	public boolean touche(Navire n) {
//		int lgh = n.fin.getLigne() - n.debut.getLigne();
//		int lgv = n.fin.getColonne() - n.debut.getColonne();
//
//		if (lgh == 0) {
//			if (n.debut.voisine(this.debut) || n.fin.voisine(this.debut) || n.fin.voisine(this.fin)) {
//				return true;
//			}
//			Coordonnee i = n.debut;
//			while(i.compareTo(n.debut) < 0){
//				//blabla
//			} 
//		}

	public boolean touche(Navire n) {
		if (((n.fin.getLigne() + 1 == this.debut.getLigne()
			|| n.debut.getLigne() == this.fin.getLigne() + 1)
			&&(n.debut.getColonne() <= this.fin.getColonne() && n.fin.getColonne() >= this.debut.getColonne()))	
			||
			(n.fin.getColonne() + 1 == this.debut.getColonne() 
			|| n.debut.getColonne() == this.fin.getColonne() + 1)
			&&(n.debut.getLigne() <= this.fin.getLigne() && n.fin.getLigne() >= this.debut.getLigne()))
			return true;
		return false;
	}

	public boolean chevauche(Navire n) {
		return ((n.debut.getLigne() <= this.fin.getLigne()) 
			&& (n.fin.getLigne() >= this.debut.getLigne()) 
			&& (n.debut.getColonne() <= this.fin.getColonne()) 
			&& (n.fin.getColonne() >= this.debut.getColonne()));
	}

	public boolean recoitTir(Coordonnee c) {
		if (this.contient(c)) {
			if (partiesTouchees.length > 0) {
				for (int i = 0; i < partiesTouchees.length; i++) {
					// on parcours le tableau parties touchees pour verifier que c n'y est pas
					if (partiesTouchees[i] == c) {
						// c est deja dans partiesTouchees
						return false;
					}
					
				}
				// on verifie que le tableau ne contient pas deja c
			}
			// il faut creer un nouveau tableau a chaque fois
			int i = partiesTouchees.length + 1;
			// on initialise une variable intermediaire a la longueur du tableau + 1
//			partiesTouchees[i] = c;
			// on ajoute c a la suite du tableau
			return true;
		}
		return false;
	}

	public boolean estTouche(Coordonnee c) {
		if (this.contient(c)) {
			return true;
		}
		return false;
	}

	public boolean estTouche() {
		// parcourir le tableau partiesTouchees pour trouver this
		for (int i = 0; i < partiesTouchees.length; i++) { 
			if ((partiesTouchees[i] == this.debut) || (partiesTouchees[i] == this.fin)) {
				return true;
			}
		}
		return false;
	}

	public boolean estCoule() {
		// Le bateau est place a l'horizontale
		if (this.debut.getLigne() == this.fin.getLigne()) {
			for (int i = this.debut.getColonne(); i < this.fin.getColonne(); i ++) {
				// Parcours des colonnes 1 a 1
				// Creer cordonnee de this pour comparer les deux dans la boucle suivante
				Coordonnee intermediaire = new Coordonnee(i, this.debut.getColonne());
				for (int j = 0; j < partiesTouchees.length; j++) {
					// Comparer coordonnes
					if (partiesTouchees[j] != intermediaire) {
						return false;
					}
					j = j + 1;
				}
				i = i + 1;
			}
			return true;
		}
		// Le bateau est place a la verticale
		else if (this.debut.getColonne() == this.fin.getColonne()) {
			for (int i = this.debut.getLigne(); i < this.fin.getLigne(); i++) {
				// Parcours desl ignes
				// Creation coordonnee de this pour comparer les deux dans la boucle suivante
				Coordonnee intermediaire = new Coordonnee(this.debut.getLigne(), i);
				for (int j = 0; i < partiesTouchees.length; j++) {
					// Comparer coordonnees
					if (partiesTouchees[j] != intermediaire) {
						return false;
					}
					j = j + 1;
				}
				i = i + 1;
			}
		}
		return true;
	}

	public static void main(String[] args) {
/////////////// TESTS DE CONTIENT
		Coordonnee Nav1 = new Coordonnee(3, 3);
		Navire test1 = new Navire(Nav1, 3, false);
		Coordonnee touch7 = new Coordonnee (3,4); // D3
//		System.out.println("Debut de test1 : " + test1.getDebut());
//		System.out.println("Fin de test1 : " +test1.getFin());
//		System.out.print("7 " + touch7.toString() + " : ");
//		System.out.println(test1.contient(touch7)); // true
///////////////////////////////////
		
		
	
		Coordonnee A = new Coordonnee(2,3);
		Coordonnee B = new Coordonnee(4,5);
		Coordonnee C = new Coordonnee(2,3);

		Coordonnee D = new Coordonnee("J8");
		Coordonnee E = new Coordonnee("G8");
		Coordonnee F = new Coordonnee(3,1);
		Navire n = new Navire(D, 5, true);
		Navire nav = new Navire(E, 4, false);
		
		System.out.println(n.toString());
		System.out.println(nav.toString());
		System.out.println(n.chevauche(nav));
		System.out.println(n.touche(nav));

//		Coordonnee touch1 = new Coordonnee (3,2); // C2
//		Coordonnee touch2 = new Coordonnee (4,4); // D4
//		Coordonnee touch3 = new Coordonnee (2,3); // B3
//		Coordonnee touch4 = new Coordonnee (3,6); // C6
//		Coordonnee touch5 = new Coordonnee (3,4); // C4
//		Coordonnee touch6 = new Coordonnee (3,3); // C3
//		Coordonnee touch7 = new Coordonnee (3,5); // C5
//		System.out.println(test1.getDebut());
//		System.out.println(test1.getFin());
//		System.out.print(touch1.toString() + " : ");
//		System.out.println(test1.contient(touch1)); // faux
//		System.out.print(touch2.toString() + " : ");
//		System.out.println(test1.contient(touch2)); // faux
//		System.out.print(touch3.toString() + " : ");
//		System.out.println(test1.contient(touch3)); // faux
//		System.out.print(touch4.toString() + " : ");
//		System.out.println(test1.contient(touch4)); // faux
//		System.out.print(touch5.toString() + " : ");
//		System.out.println(test1.contient(touch5)); // faux
//		System.out.print(touch6.toString() + " : ");
//		System.out.println(test1.contient(touch6)); // true
//		System.out.print(touch7.toString() + " : ");
//		System.out.println(test1.contient(touch7)); // true

	}

}
