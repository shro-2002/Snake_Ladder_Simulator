package com.bridgelabs.master;

import com.bridgelabs.usecase2.RollingDice;
import com.bridgelabs.usecase3.CheckOption;

public class PlayerTurn {

	/*
	 * @params: void
	 * 
	 * @return: void
	 * 
	 * @description: UC-8: if a Player gets a Ladder then plays again.
	 */

	public static int playerTurn(int position, String playerName) {
		int die;
		int option;

		do {
			System.out.println(playerName+" Plays");
			die = RollingDice.rollDie();
			System.out.println("Die rolled: " + die);
			option = CheckOption.checkOption();
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
		} while (option == 1 && position < 100);
		if (position < 0) {
			position = 0;
		}

		System.out.println(playerName + " is at position: " + position);
		System.out.println();
		return position;
	}

}
