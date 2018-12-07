package com.game.tennis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import com.game.tennis.Player;
import com.game.tennis.TennisGame;

public class TennisGameTest {

	private Player adam;
	private Player eve;
	private TennisGame game;

	@Before
	public void beforeGameTest() {
		this.adam = new Player("Adam");
		this.eve = new Player("Eve");
		this.game = new TennisGame(adam, eve);
	}

	/**
	 * Game Score should be "ADV" when both players score is higher than 3 and
	 * one player has one point higher than the other
	 * 
	 */
	@Test
	public void gameAdvantageTest() {
		for (int index = 1; index <= 3; index++) {
			adam.winBall();
		}
		for (int index = 1; index <= 3; index++) {
			eve.winBall();
		}
		assertNotEquals(this.game.getGameScore(), "ADV " + this.game.player1.getFirstName());
		adam.winBall();
		assertEquals(this.game.getGameScore(), "ADV " + this.game.player1.getFirstName());
	}

	/**
	 * Game score should be deuce when the score of both player is equal and
	 * higher than 4.
	 */
	@Test
	public void gameDuceTest() {
		for (int index = 1; index <= 3; index++) {
			adam.winBall();
		}
		for (int index = 1; index <= 3; index++) {
			eve.winBall();
		}
		assertEquals(this.game.getGameScore(), "DEUCE");
		adam.winBall();
		assertNotEquals(this.game.getGameScore(), "DEUCE");
		eve.winBall();
		assertEquals(this.game.getGameScore(), "DEUCE");
	}

	/**
	 * First player to reach at least 4 points and two points higher than his
	 * opponent wins the game
	 */
	@Test
	public void firstPlayerToWinTest() {
		for (int index = 1; index <= 4; index++) {
			adam.winBall();
		}
		for (int index = 1; index <= 3; index++) {
			eve.winBall();
		}
		assertNotEquals(this.game.getGameScore(), this.game.player1.getFirstName() + " won game");
		assertNotEquals(this.game.getGameScore(), this.game.player2.getFirstName() + " won game");
		adam.winBall();
		assertEquals(this.game.getGameScore(), this.game.player1.getFirstName() + " won game");

	}

	/**
	 * When the two players reach an equal score of 6 the tie break is activated,
	 * the fist player who gets 2 points of score set's higher than his opponent
	 * will win the sets.
	 */
	@Test
	public void winSetByTieBreakTest() {
		for (int index = 1; index <= 6; index++) {
			adam.winSet();
		}
		for (int index = 1; index <= 5; index++) {
			eve.winSet();
		}

		assertEquals(this.game.getSetScore(), adam.getTennisSetScore() + ", " + eve.getTennisSetScore());
		assertNotEquals(this.game.getSetScore(),
				"TIE BREAK RULE Activated: " + adam.getTennisSetScore() + ", " + eve.getTennisSetScore());
		eve.winSet();
		assertEquals(this.game.getSetScore(),
				"TIE BREAK RULE Activated: " + adam.getTennisSetScore() + ", " + eve.getTennisSetScore());
		eve.winSet();
		adam.winSet();
		adam.winSet();
		adam.winSet();
		assertEquals(this.game.getSetScore(),
				adam.getFirstName() + " Won Set " + adam.getTennisSetScore() + ", " + eve.getTennisSetScore());
	}
	
	/**
	 * First player to reach 6 points and two point higher 
	 * than his opponent wins the sets
	 */
	@Test
	public void winSetTest() {
		for (int index = 1; index <= 5; index++) {
			adam.winSet();
		}
		for (int index = 1; index <= 4; index++) {
			eve.winSet();
		}
		assertNotEquals(this.game.getSetScore(),
				adam.getFirstName() + " Won Set " + adam.getTennisSetScore() + ", " + eve.getTennisSetScore());
		adam.winSet();
		assertEquals(this.game.getSetScore(),
				adam.getFirstName() + " Won Set " + adam.getTennisSetScore() + ", " + eve.getTennisSetScore());
	}
	

}
