package batailleNavale;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FenetreJoueur extends JFrame {

	private JPanel contentPane;
	private GrilleGraphique	grilleTirs;
	private	GrilleNavaleGraphique grilleDefense;

	public FenetreJoueur() {
		this("Nom du joueur", 10);
	}
	
	public FenetreJoueur(String nom, int taille) {
	
	} 
	
	public GrilleGraphique getGrilleTirs() {
	
	}
	
	public GrilleNavaleGraphique getGrilleDefense() {
	
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

	/**
	 * Create the frame.
	 */
	public FenetreJoueur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
