package batailleNavale;
import java.util.Scanner;

public class JoueurAuto extends Joueur {
	
	public JoueurAuto(GrilleNavale g, String nom) {
		super(g, nom);
	}
	
	protected void perdu() {
		System.out.println(this.getNom() + ", superlooser !");
	}
	
	protected void gagne() {
		System.out.println(this.getNom() + ", you win!");
	}
	
	protected void retourAttaque(Coordonnee c, int etat) {
		System.out.println("Grille Attaquant : \n" + this.getGrille());
//		if(etat == TOUCHE) {
//			etat = TOUCHE;
//			System.out.println("tu m'as touché  mais pas coulé");
//		} else if (etat == COULE) {
//			System.out.println("tu m'as touché coulé");
//		} else if (etat == A_L_EAU) { 
//			System.out.println("tu m'as loupé ! dans la flotte..");
//		} else {
//			System.out.println("là");
//		}
//		debutAttaque();
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		System.out.println(this.getNom() + " est attaqué ! ");
//		if(this.getGrille().recoitTir(c) && (!(this.getGrille().estCoule(c)))) {
//			etat = TOUCHE;
//		} else if (this.getGrille().recoitTir(c) && (this.getGrille().estCoule(c))) {
//			etat = COULE;
//		}else {
//			etat = A_L_EAU;
//		}
//		retourAttaque(c, etat);
	}
	
	public void debutAttaque() {
		//int [] tabTaillesNavs = {2, 2, 3, 3, 4, 4};
		//GrilleNavale mygrid = new GrilleNavale(10, tabTaillesNavs);
		//mygrid.placementAuto(tabTaillesNavs); //grid du joueur auto avec nav placés
        
        // this attaque 
        // Coordonnee attaqueMilieu = new Coordonnee(5, 5);
		System.out.println("Vas y attaque " + this.getNom() + " !");
		Coordonnee al = new Coordonnee((int) Math.random() * 10, (int) Math.random() * 10); 
      	while (this.getGrille().recoitTir(al)) {
      		al = new Coordonnee((int) Math.random() * 10, (int) Math.random() * 10);  //attaque sur une case aléatoire
      	}
      		this.attaque(al);
      	}
        
//		int etatInit = 0; 
//		retourDefense(coordSaisie, etatInit);
	

	public static void main(String[] args) {
		//Grille + joueur 1
		int[] tailleNav = {1};
		GrilleNavale gj1 = new GrilleNavale(10, tailleNav);
		Coordonnee c = new Coordonnee(3,3);
		Navire n = new Navire(c, 2, true);
		gj1.ajouteNavire(n);
		System.out.println("Grille joueur 1 : \n" + gj1 + "\n");
		Joueur java = new JoueurAuto(gj1, "java");
		// Grille + joueur 2
		GrilleNavale gj2 = new GrilleNavale(10, tailleNav);
		Coordonnee c0 = new Coordonnee(5,5);
		Navire n0 = new Navire(c0, 2, true);
		gj2.ajouteNavire(n0);
		System.out.println("Grille joueur 2 : \n" + gj2 + "\n");
		Joueur ruby = new JoueurAuto(gj1, "ruby");
		
		java.jouerAvec(ruby);
		java.debutAttaque();
		
	}
}
	

