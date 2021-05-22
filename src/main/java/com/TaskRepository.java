package com;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {

	@Query(value = "SELECT d.taskid,d.tasktitle,d.taskdesc,d.taskstatus,d.taskdate,e.teamid FROM task d Left JOIN team e ON d.taskid = e.taskid ", nativeQuery = true)
	Object[][] taskWithTeam();
	
	Task findBytaskid(Integer taskid);

}
