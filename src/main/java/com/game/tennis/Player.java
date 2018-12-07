package com.game.tennis;

public class Player {
	private String firstName;
	private Integer gameScore;
	private Integer tennisSetScore;
	private Integer tennisMatchScore;
	private String gameScoreDescription;
	
	public Player(String firstName) {
		this.firstName = firstName;
		this.gameScore = 0;
		this.tennisMatchScore = 0;
		this.tennisSetScore = 0;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Integer getGameScore() {
		return gameScore;
	}
	public void setGameScore(Integer gameScore) {
		this.gameScore = gameScore;
		
		switch (gameScore.intValue()) {
		case 0 :
			this.gameScoreDescription = "0";
			break;
		case 1 :
			this.gameScoreDescription = "15";
			break;
		case 2 :
			this.gameScoreDescription = "30";
			break;
		case 3 :
			this.gameScoreDescription = "40";
			break;

		default:
//			System.out.println("default score : " + this.gameScore);
			break;
		}
	}
	public String getGameScoreDescription() {
		return this.gameScoreDescription;
	}
	public void setGameScoreDescription(String gameScoreDescription) {
		this.gameScoreDescription = gameScoreDescription;
	}
	
	
	
	public Integer getTennisSetScore() {
		return tennisSetScore;
	}
	public void setTennisSetScore(Integer tennisSetScore) {
		this.tennisSetScore = tennisSetScore;
	}
	
	public Integer getTennisMatchScore() {
		return tennisMatchScore;
	}

	public void setTennisMatchScore(Integer tennisMatchScore) {
		this.tennisMatchScore = tennisMatchScore;
	}

	@Override
	public String toString() {
		return this.firstName + " score : " + this.gameScore;
	}
	
	/**
	 * Add a point to the score if a player wins a ball
	 */
	public void winBall() {
		this.setGameScore(this.gameScore + 1);
	}
	
	public void winSet() {
		this.setTennisSetScore(this.tennisSetScore + 1);
	}
}
