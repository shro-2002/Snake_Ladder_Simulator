package com.bridgelabs.master;

import com.bridgelabs.usecase2.RollingDice;
import com.bridgelabs.usecase3.CheckOption;

public class SnakeLadder {

	public static void main(String[] args) {
		System.out.println("Welcome to Snake and Ladder Game");
		Player();
		repeatTillWin();
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
}
