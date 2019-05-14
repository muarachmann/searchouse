package com.searchhouse.searchhouse.repositories;

import com.searchhouse.searchhouse.entities.Logement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface LogementRepository extends JpaRepository<Logement, Long> {

    @Query(value = "select distinct * FROM logement l where  l.ville=?1", nativeQuery =true)
    List<Logement> findLogementByVill(String q);
    }
