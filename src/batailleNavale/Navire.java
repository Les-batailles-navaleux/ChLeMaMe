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
//		}
//		if(!estVertical){
//			this.fin = new Coordonnee(this.debut.getLigne(), this.debut.getColonne() + longueur - 1);
//		}
//		
		// la puissance ternaire en 1 ligne .. ou presque
		this.fin = estVertical ? new Coordonnee(this.debut.getLigne() + longueur-1, this.debut.getColonne()) : //  estVertical
								 new Coordonnee(this.debut.getLigne(), this.debut.getColonne() + longueur - 1);// !estVertical
		
		this.partiesTouchees = new Coordonnee[longueur];
		this.nbTouchees = 0;
	}
	

	
//	public String toString() {
////		if (estVertical) {
////			return "Navire("+ debut + ", " + fin.getColonne - debut.getColonne + ", " + " vertical)"; 
////		}
////		return "Navire("+ debut + ", " + fin - debut + ", "); 
//	}
	
	}
// lequel toString est le bon ?
	public String toString() {
		// if (estVertical) {
		// return "Navire("+ debut + ", " + fin.getColonne - debut.getColonne +
		// ", " + " vertical)";
		// }
		// return "Navire("+ debut + ", " + fin - debut + ", ");
	}

	public Coordonnee getDebut() {
		return debut;
	}

	public Coordonnee getFin() {
		return fin;
	}

	public boolean contient(Coordonnee c) {
		if ((c.getColonne() - this.debut.getColonne() == 0) || (c.getColonne() - this.fin.getColonne() == 0)) {
			// c et this sont sur la meme colonne et this est vertical 
			if (c.getLigne() - this.debut.getLigne() == 0) {
				// c est EXACTEMENT au debut de this
				return true;
			}
			else if (c.getLigne() - this.fin.getLigne() == 0) {
				// c est EXACTEMENT a la fin de this
				return true;
			}
			else {
//				for (int i = this.debut.getLigne(); i < this,fin.getLigne(); i++) {
					// DO STUFF
				}
			}
//		}
		return false;
	}


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
//	}

	public boolean chevauche(Navire n) {
		if ((n.debut.getLigne() <= this.debut.getLigne()) 
			&& (n.fin.getLigne() >= this.fin.getLigne()) 
			&& (n.debut.getColonne() >= this.debut.getColonne()) 
			&& (n.fin.getColonne() <= this.fin.getColonne()))
			return true;
		return false;
	}

	public boolean recoitTir(Coordonnee c) {
		if (this.contient(c)) {
			int i = partiesTouchees.length + 1;
			// on initialise une variable intermediaire a la longueur du tableau + 1
			partiesTouchees[i] = c;
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
		Coordonnee Nav1 = new Coordonnee(3, 3);
//		System.out.println(Nav1.toString());
		Navire test1 = new Navire(Nav1, 3, false);
		Coordonnee touch1 = new Coordonnee (3,2); // C2
		Coordonnee touch2 = new Coordonnee (4,4); // D4
		Coordonnee touch3 = new Coordonnee (2,3); // B3
		Coordonnee touch4 = new Coordonnee (3,6); // C6
		Coordonnee touch5 = new Coordonnee (3,4); // C4
		Coordonnee touch6 = new Coordonnee (3,3); // C3
		Coordonnee touch7 = new Coordonnee (3,5); // C5
		System.out.println(test1.getDebut());
		System.out.println(test1.getFin());
		System.out.print(touch1.toString() + " : ");
		System.out.println(test1.contient(touch1)); // faux
		System.out.print(touch2.toString() + " : ");
		System.out.println(test1.contient(touch2)); // faux
		System.out.print(touch3.toString() + " : ");
		System.out.println(test1.contient(touch3)); // faux
		System.out.print(touch4.toString() + " : ");
		System.out.println(test1.contient(touch4)); // faux
		System.out.print(touch5.toString() + " : ");
		System.out.println(test1.contient(touch5)); // faux
		System.out.print(touch6.toString() + " : ");
		System.out.println(test1.contient(touch6)); // true
		System.out.print(touch7.toString() + " : ");
		System.out.println(test1.contient(touch7)); // true
		// TODO Auto-generated method stub
		Coordonnee A = new Coordonnee(2,3);
		Coordonnee B = new Coordonnee(4,5);
		Coordonnee C = new Coordonnee(2,3);
		Coordonnee D = new Coordonnee(6,8);
		Coordonnee E = new Coordonnee(6,9);
		Coordonnee F = new Coordonnee(3,1);

	}

}
