package com;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Integer> {
	Team findByteamid(Integer teamid);
}
