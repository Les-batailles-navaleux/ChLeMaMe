package batailleNavale;

import javax.swing.*;

public class JoueurGraphique extends Joueur implements CaseClickListener {
	private GrilleGraphique grilleTirs;
	private boolean tirActif;
	
	public JoueurGraphique(GrilleNavaleGraphique grilleDefense,GrilleGraphique grilleTirs, String nom) {
//		super(grilleDefense, grilleTirs, nom); I DONT UNDERSTAND
	}
	private void setTirActif(boolean b) {
		
	}
	public GrilleNavaleGraphique getGrille() {
		this.getGrille();
		
	}
	public void jouerAvec(Joueur j) {
		
	}
	public void debutAttaque() {
		
	}
	protected void retourDefense(Coordonnee c, int etat) {
		if (etat==COULE ) {
			JOptionPane.showMessageDialog(grilleTirs, "Dommage, votre navire a été coulé en "+c);
		}
	}
	protected void perdu() {
		
	}
	protected void gagne() {
		
	}
	protected void retourAttaque(Coordonnee c, int etat) {
		
	}
	public void caseClick(Coordonnee c) {
		if (tirActif) {
			setTirActif(false);
			this.attaque(c);
		}
	}
}
