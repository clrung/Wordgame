import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordgameDriver {
	public static void main(String[] args) {
		Scanner scanner = null;
		if (args.length == 0) {
			System.out.println("ERROR! usage: WordgameDriver [dictionary file]");
			System.exit(0);
		}

		try {
			scanner = new Scanner(new File(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}

		Wordgame game = new Wordgame();

		System.out.print("Building graph...");
		game.buildGraph(scanner);
		System.out.println("done");

		int gameResponse = 0;
		String playAgainResponse;
		scanner = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			do {
				System.out.println("\nWhich game would you like to play? Please input 1 or 2.");
				System.out.println("\t1) Find all of the neighbors of a five letter word.");
				System.out.println("\t2) Find the distance between two five letter words.");
				System.out.print("Choice: ");
				if (scanner.hasNextInt())
					gameResponse = scanner.nextInt();
				else
					System.out.println("Error! Please input 1 or 2.");
				
				// consume the newline token
				scanner.nextLine();

				if (gameResponse == 1)
					game.startNeighborGame();
				else if (gameResponse == 2)
					game.startDistanceGame();
			} while (!(gameResponse == 1 || gameResponse == 2));
			
			do {
				System.out.print("\nWould you like to play again? (Y/N): ");
				playAgainResponse = scanner.next();
			} while (!(playAgainResponse.equalsIgnoreCase("Y") || playAgainResponse.equalsIgnoreCase("N")
					|| playAgainResponse.equalsIgnoreCase("YES") || playAgainResponse.equalsIgnoreCase("NO")));

			if (playAgainResponse.equalsIgnoreCase("N") || playAgainResponse.equalsIgnoreCase("NO"))
				loop = false;
		}

		scanner.close();
		System.out.println("Thanks for playing!");
	}
}
