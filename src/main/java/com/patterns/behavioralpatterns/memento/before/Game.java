package com.patterns.behavioralpatterns.memento.before;

import java.io.Serializable;

import com.patterns.behavioralpatterns.memento.after.GameSave;

public class Game implements Serializable{

	private int redTeamScore;
	private int blueTeamScore;
	
	public int getRedTeamScore() {
		return redTeamScore;
	}
	public void setRedTeamScore(int redTeamScore) {
		this.redTeamScore = redTeamScore;
	}
	public int getBlueTeamScore() {
		return blueTeamScore;
	}
	public void setBlueTeamScore(int blueTeamScore) {
		this.blueTeamScore = blueTeamScore;
	}
	
	public GameSave save() {
		return new GameSave(this.blueTeamScore, this.redTeamScore);
	}
	
	public void restore(GameSave gameSave) {
		this.blueTeamScore = gameSave.getBlueTeamScore();
		this.redTeamScore = gameSave.getRedTeamScore();
	} 
	
}
