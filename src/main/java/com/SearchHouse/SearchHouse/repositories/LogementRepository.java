package com.searchhouse.searchhouse.repositories;

import com.searchhouse.searchhouse.entities.Logement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface LogementRepository extends JpaRepository<Logement, Long> {

    }
