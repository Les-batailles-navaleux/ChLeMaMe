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
		//System.out.println("Grille Attaquant : \n" + this.getGrille());
		 if(etat == TOUCHE) {
			System.out.println(this.getNom() + ", tire en " + c + ": touché");
		} else if (etat == COULE) {
			System.out.println(this.getNom() + ", tire en " + c + ": touché coulé");
		} else if (etat == A_L_EAU) { 
			System.out.println(this.getNom() + ", tire en " + c + ": loupé ! dans la flotte..");
		} else {
			System.out.println("état: " + etat);
		}
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		System.out.println(this.getNom() + " est attaqué en " + c);
		// System.out.println("Grille de this: \n" + this.getGrille());
	}
	
	public void debutAttaque() {
		//A quel endroit on place les bateaux ?
		//int [] tabTaillesNavs = {2, 2, 3, 3, 4, 4};
		//GrilleNavale myGrid = new GrilleNavale(10, tabTaillesNavs);
		//myGrid.placementAuto(tabTaillesNavs); //grid du joueur auto avec nav placés
		Coordonnee al = new Coordonnee((int) (Math.random() * 10 - 1) + 1, (int) (Math.random() * 10- 1) + 1); 
		attaque(al);
		if (this.getGrille().recoitTir(al)) { //nouvelles coord aleatoires
      		this.attaque(new Coordonnee((int) (Math.random() * 10 - 1) + 1, (int) (Math.random() * 10 - 1)  + 1));
      	} 
	}

	public static void main(String[] args) {
		
		
		//Grille joueur auto
		int[] tailleNav = {1};
		
		Coordonnee c = new Coordonnee("C3"); //C3
		Navire n = new Navire(c, 2, true);
//		GrilleNavale gj1 = new GrilleNavale(10, 1);
		GrilleNavale gj1 = new GrilleNavale(10, tailleNav);
		
		gj1.ajouteNavire(n);
		
		System.out.println("Grille java : \n" + gj1 + "\n");
		Joueur java = new JoueurAuto(gj1, "java");

		// Grille joueur texte
		Coordonnee c0 = new Coordonnee(5,5); // E5
		Navire n0 = new Navire(c0, 2, true);
		GrilleNavale gj2 = new GrilleNavale(10, tailleNav);
		
		gj2.ajouteNavire(n0);
		
		System.out.println("Grille HAumain : \n" + gj2 + "\n");
		JoueurTexte humain = new JoueurTexte(gj1, "Humain");
		
		humain.jouerAvec(java);
		humain.debutAttaque();
	}
}
	

