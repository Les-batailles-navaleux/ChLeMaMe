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
		this.fin = !estVertical ? new Coordonnee(this.debut.getLigne(), this.debut.getColonne() + longueur - 1): // horizontal
								 new Coordonnee(this.debut.getLigne() + longueur-1, this.debut.getColonne()); 	// estVertical
		
		this.partiesTouchees = new Coordonnee[longueur];
		this.nbTouchees = 0;
	}
	
//	public String toString() {
//
////		String s1 = "";
////		String s2 ="";
//
//		String sDeb = "Navire (" + this.debut.toString() + ", ";
//		String sFin = "Navire (" + this.fin.toString();
//		
//		// opérateur ternaire OP
//		String s2 = this.debut.getColonne()==this.fin.getColonne() ?((this.fin.getLigne() - (this.debut.getLigne()) + 1)) + ", Vertical)" :
//															((this.fin.getColonne() - (this.debut.getColonne()) + 1)) + ", Horizontal)";
//		

//		// si le début et la fin de la colone son la même lettre alors vertical, sinon horizontal
//		if (this.debut.getColonne() == this.fin.getColonne()) {
//			// +1 pour compenser le longueur -1 incompris du constructeur Navire()
//			s2 = ((this.fin.getLigne() - (this.debut.getLigne()) + 1)) + ", Vertical)";
//		} else {			
//			
//			s2 = ((this.fin.getColonne() - (this.debut.getColonne()) + 1)) + ", Horizontal)";
//		}
//			return (sDeb+s2);
//		
//	}
	
	public String toString(){
		String str="Navire (";
		String inclinaison="";
		int lg;
		if(this.fin.getLigne()!=this.debut.getLigne()){
			inclinaison="Vertical";
			lg=(this.fin.getLigne()-this.debut.getLigne()+1);
			}
		else{inclinaison="Horizontal";
		lg=(this.fin.getColonne()-this.debut.getColonne()+1);
		}
		str=str+this.debut+","+fin+","+lg+","+inclinaison+")";
		return(str);
		
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
			// il faut ajouter les valeurs au tableau
			for (int i = 0; i < partiesTouchees.length; i++) {
				// on parcours le tableau pour trouver s'il y a c
				if (partiesTouchees[i] == null) {
					partiesTouchees[i] = c;
					nbTouchees++;
					return true;
				}
			}
			return true;
		}
		else {
			return false; // ok
		}
	}

//	public boolean estTouche(Coordonnee c) {
//		if (this.contient(c)) {
//			return true;
//		}
//		return false;
//	}
	
	public boolean estTouche(Coordonnee c) {		// Est-ce que le tir en coordonnées c touche le navire ?
		// On cherche a savoir si c existe dans partiesTouchees
		for(int i = 0; i < this.nbTouchees; i++) {
			if(this.partiesTouchees[i] != null) 
				if(this.partiesTouchees[i].equals(c))
					return true;
		}
		return false;
}

	
//	public boolean estTouche() {
//		return (this.nbTouchees > 0);
//}
	
	public boolean estTouche() {
		// parcourir le tableau partiesTouchees pour trouver this
		for (int i = 0; i < partiesTouchees.length; i++) { 
			if ((partiesTouchees[i].getColonne() >= this.debut.getColonne()) && (partiesTouchees[i].getLigne() <= this.debut.getLigne()) || (partiesTouchees[i].getColonne() >= this.fin.getColonne()) && (partiesTouchees[i].getLigne() <= this.fin.getLigne()) ) {
				return true;
			}
		}
		return false;
	}

	public boolean estCoule() {
		if (this.debut.getLigne() == this.fin.getLigne()) {
			System.out.println("Le bateau est horizontal");
			// On a marque que la longueur de partiesTouchees est egale a la longueur
			int longueur = this.fin.getColonne() - this.debut.getColonne() + 1;
			System.out.println("nombre de touches : " + nbTouchees);
			System.out.println("longueur du bateau : " + longueur);
			if (nbTouchees == longueur) {
				return true;
			}
			return false;
		}
		else if (this.debut.getColonne() == this.fin.getColonne()) {
			//System.out.println("Le bateau est vertical");
			int longueur = this.fin.getLigne() - this.debut.getLigne() + 1;
			if (nbTouchees == longueur) {
				return true;
			}
			return false;
		}
		return false;
	}

	public static void main(String[] args) {
/////////////// TESTS DE CONTIENT
		Coordonnee Nav1 = new Coordonnee(3,3);
		Navire test1 = new Navire(Nav1, 9, false);
		Coordonnee touch7 = new Coordonnee (3,3); // D3
		if (test1.contient(touch7) != true) {
			System.out.println("La methode contient a un probleme");
		}
/////////////// FIN TESTS DE CONTIENT
/////////////// TESTS DE RECOITTIR
		if (test1.recoitTir(touch7) != true) {
			System.out.println("La methode recoitTir a un probleme");
		}
		Coordonnee touch8 = new Coordonnee (3,4); // D3
		Coordonnee touch9 = new Coordonnee (2,1); // B1
		if (test1.recoitTir(touch8) != true) {
			System.out.println("La methode recoitTir a un probleme");
		}
		if (test1.recoitTir(touch9) == true) {
			System.out.println("La methode recoitTir a un probleme");
		}
/////////////// FIN TESTS DE RECOITTIR
/////////////// TESTS DE ESTTOUCHE
		test1.recoitTir(touch7);
		if (test1.estTouche(touch7) != true) {
			System.out.println("La methode estTouche(coordonnees c) a un probleme");
		}
		if (test1.estTouche() != true) {
			System.out.println("La methode estTouche() a un probleme");
		}
/////////////// FIN TESTS DE ESTTOUCHE
/////////////// TESTS DE ESTCOULE
//		Coordonnee touch22 = new Coordonnee(3,3);
//		Coordonnee touch2 = new Coordonnee (3,4);
//		System.out.println(touch2.toString());
//		Coordonnee touch3 = new Coordonnee (3,5);
//		Coordonnee touch4 = new Coordonnee (3,6);
//		Coordonnee touch5 = new Coordonnee (3,7);
//		System.out.println(touch3.toString());
//		test1.recoitTir(touch22);
//		System.out.println("Le bateau recoit le tir : " + test1.recoitTir(touch22));
//		test1.recoitTir(touch2);
//		test1.recoitTir(touch3);
//		test1.recoitTir(touch4);
//		test1.recoitTir(touch5);
//		System.out.println("Coule ? " + test1.estCoule()); // true
/////////////// FIN TESTS DE ESTCOULE
	
		Coordonnee A = new Coordonnee(2,3);
		Coordonnee B = new Coordonnee(4,5);
		Coordonnee C = new Coordonnee(2,3);

		Coordonnee D = new Coordonnee("J8");
		Coordonnee E = new Coordonnee("G8");
		Coordonnee F = new Coordonnee(3,1);
		
		Navire n = new Navire(D, 5, true);
		Navire nav = new Navire(E, 4, false);
		Navire nav2 = new Navire(F, 4, false);
		
		System.out.println("nav2: "+nav2.toString());
		
		System.out.println(n.toString());
		System.out.println(nav.toString());
		System.out.println(n.chevauche(nav));
		System.out.println(n.touche(nav));
		System.out.println("F: "+ F.toString());
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
