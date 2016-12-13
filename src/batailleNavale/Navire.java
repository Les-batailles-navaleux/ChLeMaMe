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
		if ((n.debut.getLigne() < this.fin.getLigne() && n.fin.getLigne() > this.debut.getLigne() && n.fin.getColonne() + 1 == this.debut.getColonne()) || (n.fin.getLigne() < this.debut.getLigne() && n.debut.getLigne() > this.fin.getLigne() && n.debut.getColonne() + 1 == this.fin.getColonne()) || (n.debut.getColonne() < this.fin.getColonne() && n.fin.getColonne() > this.debut.getColonne() && n.fin.getLigne() + 1 == this.debut.getLigne()) || (n.fin.getColonne() < this.debut.getColonne() && n.debut.getColonne() > this.fin.getColonne() && n.debut.getLigne() + 1 == this.fin.getLigne()))
			return true;
		return false;
	}

	public boolean chevauche(Navire n) {
		if ((n.debut.getLigne() <= this.debut.getLigne() && n.fin.getLigne() >= this.fin.getLigne() && n.debut.getColonne() >= this.debut.getColonne() && n.fin.getColonne() <= this.fin.getColonne())||(n.fin.getLigne() <= this.fin.getLigne() && n.debut.getLigne() >= this.debut.getLigne() && n.fin.getColonne() >= this.fin.getColonne() && n.debut.getColonne() <= this.debut.getColonne()))
		return false;	
	}

	public boolean recoitTir(Coordonnee c) {

	}

	public boolean estTouche(Coordonnee c) {

	}

	public boolean estTouche() {

	}

	public boolean estCoule() {

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
