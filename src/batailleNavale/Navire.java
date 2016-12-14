package batailleNavale;

public class Navire {
	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees;

	public Navire(Coordonnee debut, int longueur, boolean estVertical) {
		this.debut = debut;
		longueur = 4;
		// TODO si le navire estVertical
		Coordonnee fin = new Coordonnee(debut.getColonne(), longueur + 1);
		this.fin = fin;
		estVertical = true;
//		PROBLEME 
//		if (estVertical) {
//			longueur = this.fin.getColonne() - this.debut.getColonne();
//		}
//		else {
//			longueur = this.fin.getLigne() - this.debut.getLigne();
//		}
	}
	
//	public String toString() {
////		if (estVertical) {
////			return "Navire("+ debut + ", " + fin.getColonne - debut.getColonne + ", " + " vertical)"; 
////		}
////		return "Navire("+ debut + ", " + fin - debut + ", "); 
//	}
	
//	}

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
			// c et this sont sur la meme colonne
			if (c.getLigne() - this.debut.getLigne() == 0) {
				// c est EXACTEMENT au debut de this
				return true;
			}
			else if (c.getLigne() - this.fin.getLigne() == 0) {
				// c est EXACTEMENT a la fin de this
				return true;
			}
			else if ((c.getLigne() > this.debut.getLigne()) && (c.getLigne() < this.fin.getLigne())) {
				return true;
			}
		}
		else if ((c.getLigne() - this.debut.getLigne() == 0) || (c.getLigne() - this.fin.getLigne() == 0)) {
//			c et this sont sur la meme ligne
			if (c.getColonne() - this.debut.getColonne() == 0) {
				return true;
			}
			else if (c.getColonne() - this.fin.getColonne() == 0) {
				return true;
			}
			else if ((c.getColonne() > this.debut.getColonne()) && (c.getColonne() < this.fin.getColonne())) {
				// Si colonne de c est entre la colonne de debut de this et la colonne de fin
				return true;
			}
		}
		return false;
	}
			// il faut faire un for pour le milieu du navire
//			return false;
//		else {
//			int longueurNavire = this.fin.getColonne() - this.debut.getColonne() + 1; // + 1 car fin est inclus dans le bateau
//			for (int i = this.debut.getColonne(); i < longueurNavire; i++) {
//				if (c.getColonne() == i) {
//					return true;
//				}
//				i = i +1;
//			}
//		}

	public boolean touche(Navire n) {
		if ((n.debut.getLigne() < this.fin.getLigne() && n.fin.getLigne() > this.debut.getLigne() && n.fin.getColonne() + 1 == this.debut.getColonne()) || (n.fin.getLigne() < this.debut.getLigne() && n.debut.getLigne() > this.fin.getLigne() && n.debut.getColonne() + 1 == this.fin.getColonne()) || (n.debut.getColonne() < this.fin.getColonne() && n.fin.getColonne() > this.debut.getColonne() && n.fin.getLigne() + 1 == this.debut.getLigne()) || (n.fin.getColonne() < this.debut.getColonne() && n.debut.getColonne() > this.fin.getColonne() && n.debut.getLigne() + 1 == this.fin.getLigne()))
			return true;
		return false;
	}
	public boolean touche(Navire n) {
		int lgh = n.fin.getLigne() - n.debut.getLigne();
		int lgv = n.fin.getColonne() - n.debut.getColonne();

		if (lgh == 0) {
			if (n.debut.voisine(this.debut) || n.fin.voisine(this.debut) || n.fin.voisine(this.fin)) {
				return true;
			}
			Coordonnee i = n.debut;
			while(i.compareTo(n.debut) < 0){
				//blabla
			} 
		}
	}

	public boolean chevauche(Navire n) {
		if ((n.debut.getLigne() <= this.debut.getLigne() && n.fin.getLigne() >= this.fin.getLigne() && n.debut.getColonne() >= this.debut.getColonne() && n.fin.getColonne() <= this.fin.getColonne())||(n.fin.getLigne() <= this.fin.getLigne() && n.debut.getLigne() >= this.debut.getLigne() && n.fin.getColonne() >= this.fin.getColonne() && n.debut.getColonne() <= this.debut.getColonne()))
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
/////////////// TESTS DE CONTIENT
//		Coordonnee Nav1 = new Coordonnee(3, 3);
//		Navire test1 = new Navire(Nav1, 3, false);
//		Coordonnee touch7 = new Coordonnee (3,5); // C5
//		System.out.println("Debut de test1 : " + test1.getDebut());
//		System.out.println("Fin de test1 : " +test1.getFin());
//		System.out.print("7 " + touch7.toString() + " : ");
//		System.out.println(test1.contient(touch7)); // true
///////////////////////////////////
	}

}
