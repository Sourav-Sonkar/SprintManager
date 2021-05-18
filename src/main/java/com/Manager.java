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
	
	
	public Manager() {
	}


	public Manager(Integer mangid, Integer empid) {
		
		this.mangid = mangid;
		this.empid = empid;
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


	@Override
	public String toString() {
		return "Manager [mangid=" + mangid + ", empid=" + empid + "]";
	}



	
	

}
