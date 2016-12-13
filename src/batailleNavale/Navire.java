package batailleNavale;

public class Navire {
	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees;

	public Navire(Coordonnee debut, int longueur, boolean estVertical) {

	}

	public Coordonnee getDebut() {
		return debut;
	}

	public Coordonnee getFin() {
		return fin;
	}

	public boolean contient(Coordonnee c) {

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
		int lgh = n.fin.getLigne() - n.debut.getLigne();
		int lgv = n.fin.getColonne() - n.debut.getColonne();

		if (lgh == 0) {
			if (!n.fin.equals(this) || n.debut.contient()) {
				return false;
			}

		} else {

		}
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
