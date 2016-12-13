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
	
	
	public String toString() {
//		if (estVertical) {
//			return "Navire("+ debut + ", " + fin.getColonne - debut.getColonne + ", " + " vertical)"; 
//		}
//		return "Navire("+ debut + ", " + fin - debut + ", "); 
		
		String s= "";
		return s;
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
		return true;

	}

	public boolean chevauche(Navire n) {
//		int lgh = n.fin.getLigne() - n.debut.getLigne();
//		int lgv = n.fin.getColonne() - n.debut.getColonne();
//
//		if (lgh == 0) {
//			if (!n.fin.equals(this) || n.debut.contient()) {
//				return false;
//			}
//
//		} else {
//
//		}
		return true;
	}
//	public boolean recoitTir(Coordonnee c) {
//		
//	}
//	public boolean estTouche(Coordonnee c) {
//		
//	}
//	public boolean estTouche() {
//		
//	}
//	public boolean estCoule() {
//		
//	}
	
	public static void main(String[] args) {
		
//		Coordonnee Nav1 = new Coordonnee(3, 3);
//		System.out.println(Nav1.toString());true
//		Navire test1 = new Navire(Nav1, 3, false);

		Coordonnee c1 = new Coordonnee("B3");
		Navire titatic = new Navire(c1, 3, true);
		
		System.out.println("Vertical = vrai");
		System.out.println("DEBUT: "+ titatic.debut);
		System.out.println("FIN: "+ titatic.fin);
	}

}
