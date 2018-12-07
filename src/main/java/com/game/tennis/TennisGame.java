package com.game.tennis;

public class TennisGame {
	public Player player1;
	public Player player2;
	public boolean endGame;
	public boolean endSet;

	public TennisGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.endGame = false;
		this.endSet = false;
	}

	/**
	 * Manage Game Score
	 */
	public String getGameScore() {
		if (player1.getGameScore() >= 3 && player2.getGameScore() >= 3) {
			if (Math.abs(player2.getGameScore() - player1.getGameScore()) >= 2) {
				// Go to the next game
				this.endGame = true;
				return getGameLeadPlayer().getFirstName() + " won game";
			} else if (player1.getGameScore() == player2.getGameScore()) {
				player1.setGameScoreDescription("DEUCE");
				player2.setGameScoreDescription("DEUCE");
				return "DEUCE";
			} else {
				getGameLeadPlayer().setGameScoreDescription("ADV");
				return "ADV " + getGameLeadPlayer().getFirstName();
			}
		} else if((player1.getGameScore() > 3 || player2.getGameScore() > 3) && Math.abs(player2.getGameScore() - player1.getGameScore()) >= 2){
			this.endGame = true;
			return getGameLeadPlayer().getFirstName() + " won game";
		}else {
			return player1.getGameScoreDescription() + ", " + player2.getGameScoreDescription();
		}
	}

	public Player getGameLeadPlayer() {
		return (player1.getGameScore() > player2.getGameScore()) ? player1 : player2;
	}

	/**
	 * Manage Sets Score
	 */
	public String getSetScore() {
		if (player1.getTennisSetScore() >= 6 || player2.getTennisSetScore() >= 6) {
			if (Math.abs(player2.getTennisSetScore() - player1.getTennisSetScore()) >= 2) {
				// Go to the next match
				this.endSet = true;
				return getSetLeadPlayer().getFirstName() + " Won Set " + player1.getTennisSetScore() + ", "
						+ player2.getTennisSetScore();
			} else if (player2.getTennisSetScore() == 6 && player1.getTennisSetScore() == 6) {
				return "TIE BREAK RULE Activated: " + player1.getTennisSetScore() + ", " + player2.getTennisSetScore();
			} else {
				return player1.getTennisSetScore() + ", " + player2.getTennisSetScore();
			}
		} else {
			return player1.getTennisSetScore() + ", " + player2.getTennisSetScore();
		}
	}

	public Player getSetLeadPlayer() {
		return (player1.getTennisSetScore() > player2.getTennisSetScore()) ? player1 : player2;
	}

	/**
	 * Manage Match Score
	 */
	public String getMatchScore() {
		return "";
	}

	public void goToNextSet() {
		this.endSet = true;

	}
}
