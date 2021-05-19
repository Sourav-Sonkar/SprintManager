package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "team")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer teamid;
	String teamname;
	Integer taskid;

	public Team() {

	}

	public Team(Integer teamid, String teamname, Integer taskid) {
		super();
		this.teamid = teamid;
		this.teamname = teamname;
		this.taskid = taskid;
	}

	public Integer getTeamid() {
		return teamid;
	}

	public void setTeamid(Integer teamid) {
		this.teamid = teamid;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	@Override
	public String toString() {
		return "Team [teamid=" + teamid + ", teamname=" + teamname + ", taskid=" + taskid + "]";
	}

	
	
	
	

}
