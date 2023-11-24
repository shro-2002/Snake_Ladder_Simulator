package com.bridgelabs.master;

import com.bridgelabs.usecase2.RollingDice;
import com.bridgelabs.usecase3.CheckOption;
import com.bridgelabs.usecase7.PlayerTurn;

public class SnakeLadder {

	public static void main(String[] args) {
		System.out.println("Welcome to Snake and Ladder Game");
		twoPlayers();
	}

	/*
	 * @params: void
	 * 
	 * @return: void
	 * 
	 * @description: UC-1: Snake and Ladder game played with single player at start
	 * position 0
	 */
	public static void Player() {
		int position = 0;
		System.out.println("Player is at position: " + position);
	}

	/*
	 * @params: void
	 * 
	 * @return: int
	 * 
	 * @description: method to roll a die
	 */
	public static int rollDie() {
		int die = (int) (Math.random() * 6) + 1;
		return die;
	}

	// UC-3: Player then checks for a option

	/*
	 * @params: void
	 * 
	 * @return: int
	 * 
	 * @description: UC-3: Player then checks for a option
	 */
	public static int checkOption() {
		int option = (int) (Math.random() * 3);

		return option;
	}

	// UC-4: Repeat till the Player reaches the winning position 100
	/*
	 * @params: void
	 * 
	 * @return: void
	 * 
	 * @description:UC-4: Repeat till the Player reaches the winning position 100
	 */
	public static void repeatTillWin() {
		int position = 0;
		while (position < 100) {
			int die = RollingDice.rollDie();
			System.out.println("Die rolled: " + die);
			int option = CheckOption.checkOption();
			switch (option) {
			case 0:
				System.out.println("No Play");
				break;
			case 1:
				System.out.println("Ladder");
				position += die;
				break;
			case 2:
				System.out.println("Snake");
				position -= die;
				break;
			}
			if (position < 0) {
				position = 0;
			}
			System.out.println("Player is at position: " + position);
		}
	}

	// UC-5: Ensure the player gets to exact winning position 100

	/*
	 * @params: void
	 * 
	 * @return: int
	 * 
	 * @description: UC-5: Ensure the player gets to exact winning position 100
	 */

	public static int exactWin(int position) {

		while (position < 100) {
			int die = RollingDice.rollDie();
			System.out.println("Die rolled: " + die);
			int option = CheckOption.checkOption();
			switch (option) {
			case 0:
				System.out.println("No Play");
				break;
			case 1:
				System.out.println("Ladder");
				if (position + die <= 100) {
					position += die;
				}
				break;
			case 2:
				System.out.println("Snake");
				position -= die;
				break;
			}
			if (position < 0) {
				position = 0;
			}
			System.out.println("Player is at position: " + position);

		}
		return position;
	}

	// UC-6: Report the number of times the dice was played to win the game and also
	// the position after every die role

	/*
	 * @params: void
	 * 
	 * @return: int
	 * 
	 * @description: UC-6: Report the number of times the dice was played to win the
	 * game and also the position after every die role
	 */
	public static int report() {
		int position = 0;
		int count = 0;
		while (position < 100) {
			int die = RollingDice.rollDie();
			System.out.println("Die rolled: " + die);
			int option = CheckOption.checkOption();
			switch (option) {
			case 0:
				System.out.println("No Play");
				break;
			case 1:
				System.out.println("Ladder");
				if (position + die <= 100) {
					position += die;
				}
				break;
			case 2:
				System.out.println("Snake");
				position -= die;
				break;
			}
			if (position < 0) {
				position = 0;
			}
			System.out.println("Player is at position: " + position);
			count++;
		}
		System.out.println("Number of times the dice was played to win the game: " + count);

		return count;
	}

	/*
	 * @params: void
	 * 
	 * @return: void
	 * 
	 * @description: UC-7: Play the game with 2 players In this case if a Player
	 * gets a Ladder then plays again.Finally report which UC 7 Player won the game
	 */

	public static void twoPlayers() {
		int position1 = 0;
		int position2 = 0;
		int count = 0;

		while (position1 < 100 && position2 < 100) {

			position1 = PlayerTurn.playerTurn(position1, "Player 1");

			if (position1 < 100)

				position2 = PlayerTurn.playerTurn(position2, "Player 2");

			count++;
		}
		System.out.println("Number of times the dice was played to win the game: " + count);
		if (position1 == 100) {
			System.out.println("Player 1 won");
		} else {
			System.out.println("Player 2 won");
		}
	}

}
