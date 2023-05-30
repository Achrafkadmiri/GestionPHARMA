package com.management.repositories;

import com.management.entities.DetailOrdonnance;
import com.management.entities.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetailRepository extends JpaRepository<DetailOrdonnance, Long> {
    @Query("SELECT d FROM DetailOrdonnance d  WHERE d.ordonnance.idOrdonnance =?1 ")
    List<DetailOrdonnance> findByOrdonance(Long id);
}
