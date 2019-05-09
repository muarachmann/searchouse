package com.searchhouse.searchhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.searchhouse.searchhouse.entities.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
}
