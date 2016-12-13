package batailleNavale;

public class GrilleNavale  { // extends Navire
	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;
	
	public GrilleNavale(int taille, int[] taillesNavires) {
		this.taille = taille;
		// placementAuto(taillesNavires);
	}
	
	public GrilleNavale(int taille, int nbNavires) {
		this.taille = taille;
		this.nbNavires = nbNavires;
	}
	
	
	public String toString() {
		for (int i = 0; i < taille; i++) {
			char c = (char) (i + 'A');
			System.out.print(c + " ");
		}
		
		for (int i = 1; i < this.taille; i++) {
			for (int j = 1; j < this.taille; j++) {
				Coordonnee k = new Coordonnee(i, j);
			
				if (estTouche(k)) { // case occupée et touchée
				System.out.print("#");
				} else if (contient(k)){  // case occupée mais non touchée
				System.out.print("X");
				}
				else if (estDansTirsRecus(k)){ // case libre + deja tirée
				System.out.print("O");
				}
				else { // libre + aucun tir
				System.out.print(".");
				}
			}
		}
	} // TODO: compte des lignes
	
	
	public boolean ajouteNavire(Navire n) {
		GrilleNavale gn = new GrilleNavale(taille, nbNavires);
		if ((this.touche(n))||(this.chevauche(n))||(n.getLigne() > gn.taille)||(n.getColonne() > gn.taille)){
			return false;
		}
		// ajouter navire ? -> devient '#'
		return true;
	}
	
	public void placementAuto(int[] taillesNavires) {
		for (int i = 0; i < taillesNavires.length; i++) {
			Coordonnee al = new Coordonnee((int)Math.random() * 10, (int)Math.random() * 10);
			Navire n = new Navire(al, taillesNavires[i], Math.random() < 0.5);
				while (taillesNavires[i] > 0){
					ajouteNavire(n); // ajouter a droite ou bas ou jsais pas quoi en fonction de vertOUhoriz
					i--;
				}
		}	
	}
	
	private boolean estDansGrille(Coordonnee c) {
		return ((c.getLigne() < taille) && (c.getColonne() < taille));
	}
	

	private boolean estDansTirsRecus(Coordonnee c) {
		boolean b = false;
		for (int i = 0; i < tirsRecus.length; i++) {
			if (c == tirsRecus[i]){
				b = true;
			} 
		}
		return b;
	}
	
	private boolean ajouteDansTirsRecus(Coordonnee c) {
		if (estDansTirsRecus(c)) {
			nbTirsRecus++;
			return false;
		} else {
			Coordonnee [] tab = new Coordonnee [tirsRecus.length + 1];
			int i;
			for (i = 0; i < tirsRecus.length; i++) {
				tab[i] = tirsRecus[i];
			}
			i++;
			tab[i] = c;
			tirsRecus = tab;
			nbTirsRecus++;
			return true;
		}
	}
	public boolean recoitTir(Coordonnee c) {
		nbTirsRecus++;
		// verifier position navire
	}
	public boolean estTouche(Coordonnee c) {
		
	}
	public boolean estALEau(Coordonnee c) {
		
	}
	public boolean estCoule(Coordonnee c) {
		
	}
	public boolean perdu() {
		
	}
	
	
	
	public static void main(String[] args) {
		int [] t = {3, 2, 4};
		GrilleNavale g1 = new GrilleNavale(10, t);
		GrilleNavale g2 = new GrilleNavale(10, 5);
		g1.toString();
		//g2.toString();
		//Navire n1 = new Navire("C5", 2, true);
		//g1.ajouteDansTirsRecus(n1);

	}

}
