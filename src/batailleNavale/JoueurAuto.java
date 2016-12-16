package batailleNavale;

import java.util.Scanner;

public class JoueurAuto extends Joueur {
	
	public JoueurAuto(GrilleNavale g, String nom) {
		super(g, nom);
		nom = "Ordinateur";
	}
	
	protected void perdu() {
	
	
	}
	
	protected void gagne() {
		
	}
	
	protected void retourAttaque(Coordonnee c, int etat) {
		if(etat == TOUCHE) {
			etat = TOUCHE;
			System.out.println("this a touché j mais l'a pas coulé");
		} else if (etat == COULE) {
			System.out.println("this a touché j et coulé");
		} else if (etat == A_L_EAU) { 
			System.out.println("this a mis j a l'eau");
		} else {
			System.out.println("GameOver");
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
		//Coordonnee attaqueMilieu = new Coordonnee(5, 5);
		//this.attaque(attaqueMilieu); //attaque sur une case aléatoire
		
		System.out.println("En quelle cooronnées voulez-vous attaquer ?");
		Scanner sc = new Scanner(System.in);
		String chaine = sc.nextLine();
        Coordonnee coordSaisie = new Coordonnee(chaine);
		int et = 0; // ? jsais pas
		retourDefense(coordSaisie, et);
	}
	
}
