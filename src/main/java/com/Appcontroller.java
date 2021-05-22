package com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class Appcontroller {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ManagerRepository managerRepository;

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	TeamRepository teamRepository;

	@PostMapping("/signin")
	public Employee signIn(@RequestBody Employee employee) {
		try {
			Employee temp = employeeRepository.findByEmpemailAndEmppassword(employee.getEmpemail(),
					employee.getEmppassword());
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping("/signup")
	public boolean signUp(@RequestBody Employee employee) {
		Employee temp;
		try {
			temp = employeeRepository.save(employee);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@GetMapping("/employee/view")
	public List<Employee> getEmployee() {
		List<Employee> employee = (List<Employee>) employeeRepository.findAll();
		return employee;
	}

	@PostMapping("/employee/add")
	public Employee saveEmployee(@RequestBody Employee employee) {
		try {
			Employee temp = employeeRepository.save(employee);
			return temp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping("/employee/delete/{employeeId}")
	public Boolean deletePost(@PathVariable Integer employeeId) {
		try {
			employeeRepository.deleteById(employeeId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@PutMapping("/employee/updateTeam")
	public boolean updateEmployeeTeam(@RequestBody Employee e) {
		try {
			Employee temp = employeeRepository.findById(e.getEmpid()).get();
			temp.setTeamid(e.getTeamid());
			employeeRepository.save(temp);
			return true;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return false;
		}
	}

	@PutMapping("/employee/edit")
	public Employee editEmployee(@RequestBody Employee employee) {
		try {
			employee = employeeRepository.save(employee);
			return employee;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping("/isManager")
	public boolean isManager(@RequestBody Manager manager) {
		try {
			Manager temp = (Manager) managerRepository.findByempid(manager.getEmpid());
			if (temp != null)
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@GetMapping("/manager/view")
	public List<Manager> getManager() {
		List<Manager> manager = (List<Manager>) managerRepository.findAll();
		return manager;
	}

	@PostMapping("/manager/add")
	public Manager saveManager(@RequestBody Manager manager) {
		try {
			Manager temp = managerRepository.save(manager);
			return temp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping("/manager/delete/{managerId}")
	public Boolean deleteManager(@PathVariable Integer managerId) {
		try {
			managerRepository.deleteById(managerId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@PutMapping("/manager/edit")
	public Manager editManager(@RequestBody Manager manager) {
		try {
			manager = managerRepository.save(manager);
			return manager;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/task/view")
	public List<TaskwithTeam> getTask() {
		List<TaskwithTeam> s = new ArrayList<TaskwithTeam>();
		Object[][] task = taskRepository.taskWithTeam();
		for (int row = 0; row < task.length; row++) {
			TaskwithTeam temp = new TaskwithTeam();
			for (int col = 0; col < task[row].length; col++) {
				if (task[row][col] == null)
					task[row][col] = 0;
				if (col == 0)
					temp.setTaskid((int) task[row][col]);
				if (col == 1)
					temp.setTasktitle((String) task[row][col]);
				if (col == 2)
					temp.setTaskdesc((String) task[row][col]);
				if (col == 3)
					temp.setTaskstatus((String) task[row][col]);
				if (col == 4)
					temp.setTaskdate((String) task[row][col]);
				if (col == 5)
					temp.setTeamid((int) task[row][col]);
			}
			s.add(temp);
		}
		return s;
	}

	@PostMapping("/task/add")
	public boolean saveTask(@RequestBody Task task) {
		try {
			Task temp = taskRepository.save(task);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@PostMapping("/task/delete")
	public Boolean deleteTask(@RequestBody TaskwithTeam task) {
		try {
			if (task.getTeamid() != 0) {
				Team temp = teamRepository.findByteamid(task.getTeamid());
				if (temp != null) {
					temp.setTaskid(null);
					teamRepository.save(temp);
				}
			}
			taskRepository.deleteById(task.getTaskid());
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@PutMapping("/task/edit")
	public Task editTask(@RequestBody Task task) {
		try {
			task = taskRepository.save(task);
			return task;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping("/task/singleTask")
	public Task singleTask(@RequestBody Team team) {
		try {
			Team temp = teamRepository.findByteamid(team.getTeamid());
			if (temp != null) {
				Task temp1 = taskRepository.findBytaskid(temp.getTaskid());
				return temp1;
			}
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping("/task/updateStatus")
	public boolean updateTaskStatus(@RequestBody Task e) {
		try {
			Task temp = taskRepository.findById(e.taskid).get();
			temp.setTaskstatus(e.taskstatus);
			taskRepository.save(temp);
			return true;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return false;
		}
	}

	@GetMapping("/team/view")
	public List<Team> getTeam() {
		List<Team> team = (List<Team>) teamRepository.findAll();
		return team;
	}

	@PostMapping("/team/add")
	public Team saveTeam(@RequestBody Team team) {
		try {
			Team temp = teamRepository.save(team);
			return temp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping("/team/delete/{teamId}")
	public Boolean deleteTeam(@PathVariable Integer teamId) {
		try {
			teamRepository.deleteById(teamId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@PutMapping("/team/edit")
	public Team editTeam(@RequestBody Team team) {
		try {
			team = teamRepository.save(team);
			return team;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping("/team/getName")
	public Team getName(@RequestBody Team team) {
		try {
			Team temp = teamRepository.findByteamid(team.getTeamid());
			return temp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping("/team/assignTask")
	public boolean assignTask(@RequestBody Team e) {
		try {
			Team temp = teamRepository.findById(e.teamid).get();
			temp.setTaskid(e.taskid);
			teamRepository.save(temp);
			return true;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return false;
		}
	}
}
