package batailleNavale;

import com.sun.prism.paint.Color;

public class GrilleNavaleGraphique extends GrilleNavale {
	private GrilleGraphique grille;
	
	public GrilleNavaleGraphique(int taille) {
		// On initialise le 2e argument a 0 car on ne peut pas rien mettre
		super(taille, 0);
	}
	
	public GrilleGraphique getGrilleGraphique() {
		return this.grille;
	}
	
	public boolean ajouteNavire(Navire n) {
		// on utilise le ajouteNavire de la classe mere
	 if (super.ajouteNavire(n) == true) {
		 // colorie green
	 }
		return true;
	}
	public boolean recoitTir(Coordonnee c) {
		
	}
}