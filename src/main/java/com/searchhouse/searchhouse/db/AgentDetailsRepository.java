package com.searchhouse.searchhouse.db;

import com.searchhouse.searchhouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AgentDetailsRepository extends JpaRepository<User, Long> {

}
