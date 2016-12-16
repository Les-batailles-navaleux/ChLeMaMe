package batailleNavale;
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
		
	}
	public boolean recoitTir(Coordonnee c) {
		
	}
}