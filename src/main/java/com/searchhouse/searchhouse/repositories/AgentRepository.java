package com.searchhouse.searchhouse.repositories;

import com.searchhouse.searchhouse.entities.Logement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.searchhouse.searchhouse.entities.Agent;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {


}
