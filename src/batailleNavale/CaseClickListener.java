package batailleNavale;

/**
 * Interface qu'un �couteur de clic sur une grille doit impl�menter
 * @author jerome.david@upmf-grenoble.fr
 *
 */
public interface CaseClickListener {

	/**
	 * M�thode appel�e lorsqu'un clic sur une grille a �t� fait
	 * @param c la coordonn�e de la case cliqu�e
	 */
	public void caseClick(Coordonnee c);
}
