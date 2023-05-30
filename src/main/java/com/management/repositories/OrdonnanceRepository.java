package com.management.repositories;

import com.management.entities.Ordonnance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//car il s'agit d'une interface
public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long> {

}
