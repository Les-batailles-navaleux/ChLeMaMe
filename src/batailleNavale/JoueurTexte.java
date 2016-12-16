package batailleNavale;

import java.util.Scanner;

public class JoueurTexte extends Joueur {
	private Scanner sc;

	public JoueurTexte(GrilleNavale g, String nom) {
		super(g, nom);
	}

	public void jouerAvec(Joueur j) {
		super.jouerAvec(j);
		
	}

	protected void perdu() {
		System.out.println("Vous avez perdu !");
	}

	protected void gagne() {
		System.out.println("Vous avez gagne !");
	}

	protected void retourAttaque(Coordonnee c, int etat) {
//			System.out.println("Le tir de votre adversaire en " + c + " est " + etat + ".");
//		else if (this.getGrille().estCoule(c))
//			System.out.println("Vous avez coule l'adversaire en " + c + ".");
//		else if (this.getGrille().estALEau(c))
//			System.out.println("Vous etes a l'eau en " + c + ".");
//		else if (this.getGrille().perdu())
//			this.gagne();
		
		System.out.println("Votre tir en " + c + " est " + etat + ".");
		System.out.println("Grille Attaquant : \n" + this.getGrille());
	}

	protected void retourDefense(Coordonnee c, int etat) {
//		if (this.getGrille().estTouche(c))
//			System.out.println("Vous avez ete touchee en " + c + ".");
//		else if (this.getGrille().estCoule(c))
//			System.out.println("Vous avez ete coule en " + c + ".");
//		else if (this.getGrille().estALEau(c))
//			System.out.println("Vous avez ete touche dans l'eau en " + c + ".");
//		else if (this.getGrille().perdu())
//			this.perdu();
		
		System.out.println("Le tir de votre adversaire en " + c + " est " + etat + ".");
		System.out.println("Grille Attaqu� : \n" + this.getGrille());
	}

	public void debutAttaque() {	
		System.out.println("A votre tour d'attaquer !" + this.getNom());
		
		sc = new Scanner(System.in);
		System.out.println("Saisir une coordonnee a attaquer : ");
		String attaque = sc.next();
		Coordonnee attack = new Coordonnee(attaque); 
		
		attaque(attack);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrilleNavale g = new GrilleNavale(10, 6);
		Coordonnee a1 = new Coordonnee("D4");
		Navire n1 = new Navire(a1, 4, true);
		g.ajouteNavire(n1);
		JoueurTexte j = new JoueurTexte(g, "DBardou");
		j.debutAttaque();
		
		
	}

}
