package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer empid;
	@Column(unique = true)
	String empname;
	String empaddress;
	Integer empage;
	String empemail;
	String emppassword;
	String empcontact;
	String emptype;
	Integer teamid;
	Integer mangid;
	
	public Employee() {

	}

	public Employee(Integer empid, String empname, String empaddress, Integer empage, String empemail,
			String emppassword, String empcontact, String emptype, Integer teamid, Integer mangid) {
		
		this.empid = empid;
		this.empname = empname;
		this.empaddress = empaddress;
		this.empage = empage;
		this.empemail = empemail;
		this.emppassword = emppassword;
		this.empcontact = empcontact;
		this.emptype = emptype;
		this.teamid = teamid;
		this.mangid = mangid;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpaddress() {
		return empaddress;
	}

	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}

	public Integer getEmpage() {
		return empage;
	}

	public void setEmpage(Integer empage) {
		this.empage = empage;
	}

	public String getEmpemail() {
		return empemail;
	}

	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}

	public String getEmppassword() {
		return emppassword;
	}

	public void setEmppassword(String emppassword) {
		this.emppassword = emppassword;
	}

	public String getEmpcontact() {
		return empcontact;
	}

	public void setEmpcontact(String empcontact) {
		this.empcontact = empcontact;
	}

	public String getEmptype() {
		return emptype;
	}

	public void setEmptype(String emptype) {
		this.emptype = emptype;
	}

	public Integer getTeamid() {
		return teamid;
	}

	public void setTeamid(Integer teamid) {
		this.teamid = teamid;
	}

	public Integer getMangid() {
		return mangid;
	}

	public void setMangid(Integer mangid) {
		this.mangid = mangid;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empaddress=" + empaddress + ", empage=" + empage
				+ ", empemail=" + empemail + ", emppassword=" + emppassword + ", empcontact=" + empcontact
				+ ", emptype=" + emptype + ", teamid=" + teamid + ", mangid=" + mangid + "]";
	}

	
	

}
