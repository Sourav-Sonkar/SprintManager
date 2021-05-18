package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer taskid;
	String tasktitle;
	String taskdesc;
	String taskstatus;
	String taskdate;
	
	public Task() {
		
	}


	public Task(Integer taskid, String tasktitle, String taskdesc, String taskstatus, String taskdate) {
		
		this.taskid = taskid;
		this.tasktitle = tasktitle;
		this.taskdesc = taskdesc;
		this.taskstatus = taskstatus;
		this.taskdate = taskdate;
	}


	public Integer getTaskid() {
		return taskid;
	}


	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}


	public String getTasktitle() {
		return tasktitle;
	}


	public void setTasktitle(String tasktitle) {
		this.tasktitle = tasktitle;
	}


	public String getTaskdesc() {
		return taskdesc;
	}


	public void setTaskdesc(String taskdesc) {
		this.taskdesc = taskdesc;
	}


	public String getTaskstatus() {
		return taskstatus;
	}


	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}


	public String getTaskdate() {
		return taskdate;
	}


	public void setTaskdate(String taskdate) {
		this.taskdate = taskdate;
	}


	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", tasktitle=" + tasktitle + ", taskdesc=" + taskdesc + ", taskstatus="
				+ taskstatus + ", taskdate=" + taskdate + "]";
	}
	
	


	
	
	
	
	

}
