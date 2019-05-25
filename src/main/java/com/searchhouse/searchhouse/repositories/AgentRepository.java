package com.searchhouse.searchhouse.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.searchhouse.searchhouse.entities.Agent;



@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    @Query(value ="SELECT * FROM agent WHERE  userName=?1 AND  psswd =?2",nativeQuery =true)
     Agent connexionAgent(String name, String psswd);


    @Query(value ="Select * from agent where userName=?1" , nativeQuery=true)

    Agent creationAgent(String username);


}
