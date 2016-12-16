package batailleNavale;

import java.awt.*;

public class GrilleNavaleGraphique extends GrilleNavale {
	private GrilleGraphique grille;
	
	public GrilleNavaleGraphique(int taille) {
		// On initialise le 2e argument a 0 car on ne peut pas rien mettre
		super(taille, 10);
		this.grille = new GrilleGraphique(taille);
	}
	
	public GrilleGraphique getGrilleGraphique() {
		return this.grille;
	}
	
	public boolean ajouteNavire(Navire n) {
		// on utilise le ajouteNavire de la classe mere
	 if (super.ajouteNavire(n)) {
		 this.grille.colorie(n.getDebut(), n.getFin(), Color.GREEN);
		 // colorie green
	 }
		return false;
	}
	public boolean recoitTir(Coordonnee c) {
		if (super.recoitTir(c)) {
			// Touche
			this.grille.colorie(c, Color.RED);
			return true;
		}
		else {
			// A l'eau
			this.grille.colorie(c, Color.BLUE);
			return false;
		}
		
	}
}