package batailleNavale;

public class Navire {
	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees;

	public Navire(Coordonnee debut, int longueur, boolean estVertical) {
		this.debut = debut;
		if (estVertical) {
			longueur = this.fin.getColonne() - this.debut.getColonne();
		} else {
			longueur = this.fin.getLigne() - this.debut.getLigne();
		}
	}

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
		// On compare les colonnes dans un premier temps
		if (c.getColonne() - this.debut.getColonne() <= 0) {
			// La colonne de c est egale ou inferieure a celle du debut de this
			if (c.getColonne() - this.fin.getColonne() >= 0) {
				// La colonne de c est egale ou superieure a celle de la fin de
				// this
				return true;
			}
		}
		// On compare les lignes si jamais les colonnes ne sont pas equivalentes
		else if (c.getLigne() - this.debut.getLigne() >= 0) {
			// La ligne est la meme ou inferieure
			if (c.getLigne() - this.fin.getLigne() >= 0) {
				return true;
			}

		}
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
		// TODO Auto-generated method stub
		Coordonnee A = new Coordonnee(2,3);
		Coordonnee B = new Coordonnee(4,5);
		Coordonnee C = new Coordonnee(2,3);
		Coordonnee D = new Coordonnee(6,8);
		Coordonnee E = new Coordonnee(6,9);
		Coordonnee F = new Coordonnee(3,1);
	}

}
