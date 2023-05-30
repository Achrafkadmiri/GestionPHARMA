package com.management.repositories;

import com.management.entities.DetailOrdonnance;
import com.management.entities.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetailRepository extends JpaRepository<DetailOrdonnance, Long> {
    //@Query("SELECT * FROM DetailOrdonnance d  WHERE d.ordonnance=?1 ")
    //List<DetailOrdonnance> findByOrdonance(Long id);
}
