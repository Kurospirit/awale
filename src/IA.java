/**
 * Classe représentant une IA et son alogrithme minimax. L'IA sera définie avec
 * une profondeur de recherche.
 * 
 * Son heuristique va être smple: essayer de faire le plus de différence entre
 * ses gains et les gains adverses. Donc même si un coup donne 5 points à
 * l'adversaire, mais qu'on en gagne 8 après, on jouera ce coup, sauf si ça fait
 * gagner l'adversaire. Stratégie offensive plutôt que défensive qui
 * consisterait à minimiser les gains adversaires au maximum mais qui nous
 * empêcherai d'en gagner car on prendrait moins de risques.
 * 
 * Elle va donc analyser chacune des branches possibles et comparer à chaque
 * fois les gains obtenus par chacun des joueurs. Elle jouera ensuite sur la
 * branche la plus rentable.
 * 
 * @author 21101243 - Davy Cavalli
 *
 */
public class IA
{
	String side;
	int score;
	String name;
	int profondeur;

	public IA(String side, int profondeur)
	{
		this.side = side;
		this.name = "IA-" + side;
		this.score = 0;
		this.profondeur = profondeur;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public int getScore()
	{
		return this.score;
	}

	public void addScore(int value)
	{
		setScore(getScore() + value);
	}

	public void jouer(Plateau plateau)
	{

	}

}
