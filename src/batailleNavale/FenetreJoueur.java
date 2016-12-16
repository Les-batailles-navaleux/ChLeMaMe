package batailleNavale;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

public class FenetreJoueur extends JFrame {

	private JPanel contentPane;
	private GrilleGraphique grilleTirs;
	private GrilleNavaleGraphique grilleDefense;

	public FenetreJoueur() {
		this("Nom du joueur", 10);
	}

	public FenetreJoueur(String nom, int taille) {
		int[] navires = { 4, 4, 3, 3, 2, 2 };
		grilleDefense = new GrilleNavaleGraphique(taille);
		grilleDefense.placementAuto(navires);
		GrilleGraphique g = grilleDefense.getGrilleGraphique();

		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		grilleTirs = new GrilleGraphique();
		grilleTirs.setBorder(new TitledBorder(null, "Grille de tir", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(grilleTirs);

		g.setBorder(new TitledBorder(null, "Grille de defense", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(g);
		
		setTitle(nom);
	}

	public GrilleGraphique getGrilleTirs() {
		return grilleTirs;
	}

	public GrilleNavaleGraphique getGrilleDefense() {
		return grilleDefense;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreJoueur frame = new FenetreJoueur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
