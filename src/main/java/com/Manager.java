package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "manager")
public class Manager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer mangid;
	Integer empid;
	Integer taskid;
	
	
	public Manager() {
	}


	public Manager(Integer mangid, Integer empid, Integer taskid) {
		
		this.mangid = mangid;
		this.empid = empid;
		this.taskid = taskid;
	}


	public Integer getMangid() {
		return mangid;
	}


	public void setMangid(Integer mangid) {
		this.mangid = mangid;
	}


	public Integer getEmpid() {
		return empid;
	}


	public void setEmpid(Integer empid) {
		this.empid = empid;
	}


	public Integer getTaskid() {
		return taskid;
	}


	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}


	@Override
	public String toString() {
		return "Manager [mangid=" + mangid + ", empid=" + empid + ", taskid=" + taskid + "]";
	}
	
	
	
	

}
