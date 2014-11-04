import java.util.Scanner;

/**
 * Classe principale qui permet de jouer au jeu Awalé
 * 
 * @author 21101243 - Davy Cavalli
 *
 */
public class Awale
{
	public static void main(String[] args)
	{

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String nomJ1;
		String nomJ2;

		System.out.println("Entrez un nom de Joueur pour le J1");
		nomJ1 = sc.nextLine();
		Joueur j1 = new Joueur(nomJ1, "J1");

		System.out.println("Entrez un nom de Joueur pour le J2");
		nomJ2 = sc.nextLine();
		Joueur j2 = new Joueur(nomJ2, "J2");

		System.out.println("\nInitialise plateau");
		Plateau jeu = new Plateau();
		System.out.println();
		jeu.MonString();

		int NbTotalGraines = jeu.NbGraines();
		System.out.println("\nValeur du plateau : " + NbTotalGraines + "\n");

		System.out.println(j1.toString());
		System.out.println(j2.toString());
		

		// Boucle qui permet de jouer au tour par tour
		while (NbTotalGraines > 6 && j1.getScore() < 25 && j2.getScore() < 25)
		{
			// ////////////////////////////////////////
			// ------------ Tour J1 --------------- //
			// ////////////////////////////////////////
			System.out.println("\nJ1 choisissez la cellule à répartir\n");
			int cellule = Integer.parseInt(sc.nextLine());
			while (cellule > 5 || cellule < 0)
			{
				System.out.println("Choisissez un nombre entre 0 et 5\n");
				cellule = Integer.parseInt(sc.nextLine());
			}

			int value = jeu.jouerCoup(cellule, "J1");

			while (value < 0)
			{
				if (value == -1)
					System.out.println("J1 : choisissez une case non vide\n");
				if (value == -2)
					System.out
							.println("J1 : vous devez nourrir le plateau adverse");
				if(value == -3){
					j1.addScore(jeu.NbGraines(0));
					j2.addScore(jeu.NbGraines(1));
					NbTotalGraines = 0;
					break;
				}
				cellule = Integer.parseInt(sc.nextLine());
				while (cellule > 5 || cellule < 0)
				{
					System.out.println("Choisissez un nombre entre 0 et 5\n");
					cellule = Integer.parseInt(sc.nextLine());
				}
				value = jeu.jouerCoup(cellule, "J1");
			}

			j1.addScore(value);
			// ////////////////////////////////////////

			// ------------ Affiche plateau --------------- //
			jeu.MonString();

			// ------------ Vérifie nombre de graines sur le plateau
			// --------------- //
			NbTotalGraines = jeu.NbGraines();
			System.out
					.println("\nValeur du plateau : " + NbTotalGraines + "\n");

			// ------------ Affiche joueurs --------------- //
			System.out.println(j1.toString());
			System.out.println(j2.toString());
			
			// ------------ Affiche coups possibles ------- //
			System.out.println(jeu.coupPossiblesToString(jeu.coupPossibles()));

			// Si il reste plus assez de graines ou que le j1 vient de faire un
			// coup gagnant on sort de la boucle
			if (NbTotalGraines <= 6 || j1.getScore() >= 25)
				break;
			
			
			// ////////////////////////////////////////
			// ------------ Tour J2 --------------- //
			// ////////////////////////////////////////
			System.out.println("J2 choisissez la cellule à répartir\n");
			cellule = Integer.parseInt(sc.nextLine());
			while (cellule > 5 || cellule < 0)
			{
				System.out.println("Choisissez un nombre entre 0 et 5\n");
				cellule = Integer.parseInt(sc.nextLine());
			}
			value = jeu.jouerCoup(cellule, "J2");

			while (value < 0)
			{
				if (value == -1)
					System.out.println("J2 : choisissez une case non vide\n");
				if (value == -2)
					System.out
							.println("J2 : vous devez nourrir le plateau adverse");
				if(value == -3){
					j1.addScore(jeu.NbGraines(0));
					j2.addScore(jeu.NbGraines(1));
					NbTotalGraines = 0;
					break;
				}
				cellule = Integer.parseInt(sc.nextLine());
				while (cellule > 5 || cellule < 0)
				{
					System.out.println("Choisissez un nombre entre 0 et 5\n");
					cellule = Integer.parseInt(sc.nextLine());
				}
				value = jeu.jouerCoup(cellule, "J2");
			}

			j2.addScore(value);
			// ////////////////////////////////////////

			// ------------ Affiche plateau --------------- //
			jeu.MonString();

			// ------------ Vérifie nombre de graines sur le plateau
			// --------------- //
			NbTotalGraines = jeu.NbGraines();
			System.out
					.println("\nValeur du plateau : " + NbTotalGraines + "\n");

			// ------------ Affiche joueurs --------------- //
			System.out.println(j1.toString());
			System.out.println(j2.toString());
		}

		if (j1.getScore() > j2.getScore())
			System.out.println("J1 l'emporte");
		else if (j1.getScore() < j2.getScore())
			System.out.println("J2 l'emporte");
		else
			System.out.println("Egalité");
	}
}
