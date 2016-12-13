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
		}
		else {
			longueur = this.fin.getLigne() - this.debut.getLigne();
		}
	}
	
	public String toString() {
//		if (estVertical) {
//			return "Navire("+ debut + ", " + fin.getColonne - debut.getColonne + ", " + " vertical)"; 
//		}
//		return "Navire("+ debut + ", " + fin - debut + ", "); 
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
			if (c.getColonne() - this.fin.getColonne() >=0) {
				// La colonne de c est egale ou superieure a celle de la fin de this 
				return true;
			}
		}
		// On compare les lignes si jamais les colonnes ne sont pas equivalentes
		else if (c.getLigne() - this.debut.getLigne() >= 0 ) {
			// La ligne est la meme ou inferieure
			if (c.getLigne() - this.fin.getLigne() >= 0) {
				return true;
			}
			
		}
		return false;
	}
	public boolean touche(Navire n) {
		
	}
	public boolean chevauche(Navire n) {
		
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

	}

}
