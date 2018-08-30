package com.groupfive.InsideEdge.POJO;

public class MatchPojo {
	private String TeamA;
	private String TeamB;
	private String ScoreA;
	private String ScoreB;
	
	
	public MatchPojo(String teamA, String teamB, String scoreA, String scoreB) {
		//super();
		this.TeamA = teamA;
		this.TeamB = teamB;
		this.ScoreA = scoreA;
		this.ScoreB = scoreB;
	}


	public String getTeamA() {
		return TeamA;
	}


	public void setTeamA(String teamA) {
		TeamA = teamA;
	}


	public String getTeamB() {
		return TeamB;
	}


	public void setTeamB(String teamB) {
		TeamB = teamB;
	}


	public String getScoreA() {
		return ScoreA;
	}


	public void setScoreA(String scoreA) {
		ScoreA = scoreA;
	}


	public String getScoreB() {
		return ScoreB;
	}


	public void setScoreB(String scoreB) {
		ScoreB = scoreB;
	}


	@Override
	public String toString() {
		return "[" + TeamA + " v/s " + TeamB + " "+TeamA+": " + ScoreA + " "+ TeamB +": " + ScoreB + "]";
	}
	
	
	

}
