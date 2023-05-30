package com.management.repositories;


import com.management.entities.Laboratoire;
import com.management.entities.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long> {
}
