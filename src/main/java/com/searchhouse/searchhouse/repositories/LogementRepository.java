package com.searchhouse.searchhouse.repositories;

import com.searchhouse.searchhouse.entities.Logement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface LogementRepository extends JpaRepository<Logement, Long> {

    @Query(value = "select distinct * FROM logement l where  l.ville=?1", nativeQuery =true)
    List<Logement> findLogementByVille(String q);

    @Query(value= "SELECT DISTINCT * FROM logement WHERE statut=0 and ville LIKE %?1 OR  prix LIKE %?1 OR  type LIKE %?1 OR quartier LIKE %?1 OR piece LIKE %?1" ,
            nativeQuery =true )
    List<Logement> findLogementsByCarectiristique(String mot_cle);


    @Query(value = "SELECT * FROM logement l WHERE statut=0 and l.type=?1 AND l.ville=?2 and quartier=?3 AND l.piece=?4 and l.prix BETWEEN ?5 and ?6" ,
    nativeQuery = true)
    List<Logement> rechercheavance(String type, String ville, String quartier, String piece, Double prixm, Double prixmx);
    }
