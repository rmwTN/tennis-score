package com.game.tennis;

/**
 * We will try to put the result into the console.
 * We are using random results for the score of each game
 * PS: So far we only manage
 * games and sets The matches will be managed in the next sprint
 * 
 */
public class Startup {

	public static void main(String[] args) {

		Player john = new Player("John");
		Player adam = new Player("Adam");
		TennisGame tennis = new TennisGame(john, adam);
		int setScore = 0;

		while (!tennis.endSet) {
			System.out.println("---- new set ---- ");
			System.out.println("\t" + tennis.player1.getFirstName() + " , " + tennis.player2.getFirstName());
			tennis.player1.setGameScore(0);
			tennis.player2.setGameScore(0);
			while (!tennis.endGame) {
				System.out.println("\t ____________ ");
				int gameScore = randomScore();
				if(gameScore == 1) {
					tennis.player1.winBall();
				} else {
					tennis.player2.winBall();
				}
				System.out.println("\t " + tennis.getGameScore());
			}
			System.out.println("\t ____________ ");
			setScore = tennis.getGameLeadPlayer().equals(tennis.player1) ? 1 : 0;
			tennis.endGame = false;
			
			System.out.println("\n");
			
			if(setScore == 1) {
				tennis.player1.winSet();
			} else {
				tennis.player2.winSet();
			}
			System.out.println("Set score :  " + tennis.getSetScore());
			System.out.println("---- End set ---- ");
			System.out.println("\n");
		}
	}

	static int randomScore() {
		return (int) Math.round(Math.random());
	}

}
