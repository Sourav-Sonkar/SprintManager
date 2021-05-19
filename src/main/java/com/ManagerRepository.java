package com;

import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<Manager, Integer> {
	Manager findByempid(Integer empid);
}
