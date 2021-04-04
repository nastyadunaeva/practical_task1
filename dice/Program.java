package dice;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of players:  ");
		int n = in.nextInt();
		System.out.print("Enter number of cubes:  ");
		int k = in.nextInt();
		
		Dice dice = new Dice();
		dice.setCubes(k);
		Players players = new Players(n);
		/*
		 * Цикл игры, пока кто-то не выиграл 7 раз
		 */
		while (players.isSomeoneWins() == 0) {
			players.updateZeros();
			int max = 0;
			int max_winner = 1;
			for (int j = players.lastWinner; j < players.lastWinner + players.players; j++) {
				int i = 0;
				if (j <= players.players) {
					i = j;
				} else {
					i = j - players.players;
				}
				System.out.print("Player " + i + ": ");
				int sum = dice.roll();
				players.points[i-1] = sum;
				if (sum > max) {
					max = sum;
					max_winner = i;
				}
			}
			players.lastWinner = max_winner;
			players.wins[max_winner-1]++;
			System.out.println(">Player " + max_winner + " won");
			System.out.println();
			
		}
		System.out.println("Player " + players.lastWinner + " won the game!");
		in.close();
	}
}
