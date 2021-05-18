package com;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	Employee findByEmpnameAndEmppassword(String empname, String emppassword);
	Employee findByEmpemailAndEmppassword(String empemail, String emppassword);
	



}
