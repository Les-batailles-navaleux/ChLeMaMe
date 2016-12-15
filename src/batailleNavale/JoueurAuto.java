package batailleNavale;
import java.util.Scanner;

public class JoueurAuto extends Joueur {
	
	public JoueurAuto(GrilleNavale g, String nom) {
		super(g, nom);
	}
	
	protected void perdu() {
		System.out.println("GameOver");
	}
	
	protected void gagne() {
		System.out.println(this.getNom() + "win!");
	}
	
	protected void retourAttaque(Coordonnee c, int etat) {
		if(etat == TOUCHE) {
			etat = TOUCHE;
			System.out.println("tu m'as touché  mais pas coulé");
		} else if (etat == COULE) {
			System.out.println("tu m'as touché coulé");
		} else if (etat == A_L_EAU) { 
			System.out.println("tu m'as loupé ! dans la flotte..");
		} else {
			System.out.println("là");
		}
		debutAttaque();
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		if(this.getGrille().recoitTir(c) && (!(this.getGrille().estCoule(c)))) {
			etat = TOUCHE;
		} else if (this.getGrille().recoitTir(c) && (this.getGrille().estCoule(c))) {
			etat = COULE;
		}else {
			etat = A_L_EAU;
		}
		retourAttaque(c, etat);
	}
	
	public void debutAttaque() {
		//int [] tabTaillesNavs = {2, 2, 3, 3, 4, 4};
		//GrilleNavale mygrid = new GrilleNavale(10, tabTaillesNavs);
		//mygrid.placementAuto(tabTaillesNavs); //grid du joueur auto avec nav placés
        
        // this attaque 
        // Coordonnee attaqueMilieu = new Coordonnee(5, 5);
		Coordonnee al = new Coordonnee((int) Math.random() * 10, (int) Math.random() * 10); 
      	this.attaque(al); //attaque sur une case aléatoire
        
//		int etatInit = 0; 
//		retourDefense(coordSaisie, etatInit);
	}
	
}
