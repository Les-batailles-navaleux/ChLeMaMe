package batailleNavale;

public abstract class Joueur {
	public final static int TOUCHE = 1;
	public final static int COULE = 2;
	public final static int A_L_EAU = 3;
	private Joueur adversaire;
	private GrilleNavale grille;
	private String nom;

	public Joueur(GrilleNavale g, String nom) {
		this.grille = g;
		this.nom = nom;
	}

	public GrilleNavale getGrille() {
		return this.grille;
	}

	public String getNom() {
		return this.nom;
	}

	public void jouerAvec(Joueur j) {
		this.adversaire = j;
		j.adversaire = this;
	}

	public void attaque(Coordonnee c) {
		if (adversaire.defense(c)) {
			adversaire.debutAttaque();
		}
	}

	public boolean defense(Coordonnee c) {
		int etat = 0;
		boolean b = false;

		this.grille.recoitTir(c); // on interroge la grille, true si qqch a
									// �t� touch�;..

		if (this.grille.perdu()) {
			this.perdu();
			adversaire.gagne();
			b = false;
		} else if (this.grille.estTouche(c)) {
			etat = TOUCHE;
			b = true;
		} else if (this.grille.estCoule(c)) { //&& !this.grille.perdu()) {
			etat = COULE;
			b = true;
		} else if (this.grille.estALEau(c)) {
			etat = A_L_EAU;
			b = true;
		} 

		retourDefense(c, etat);
		adversaire.retourAttaque(c, etat);

		return b;
	}

	protected abstract void perdu();

	protected abstract void gagne();

	protected abstract void retourAttaque(Coordonnee c, int etat);

	protected abstract void retourDefense(Coordonnee c, int etat);

	public abstract void debutAttaque();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
