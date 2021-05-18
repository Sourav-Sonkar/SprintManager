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
	Integer empid;

	public Team() {

	}

	public Team(Integer teamid, String teamname, Integer empid) {
		super();
		this.teamid = teamid;
		this.teamname = teamname;
		this.empid = empid;
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

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	@Override
	public String toString() {
		return "Team [teamid=" + teamid + ", teamname=" + teamname + ", empid=" + empid + "]";
	}

	
	
	

}
