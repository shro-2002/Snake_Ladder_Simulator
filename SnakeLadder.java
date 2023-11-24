package com.bridgelabs.master;

public class SnakeLadder {

	public static void main(String[] args) {
		System.out.println("Welcome to Snake and Ladder Game");
		Player();
		System.out.println(rollDie());
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
}
