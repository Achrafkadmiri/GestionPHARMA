package com.management.repositories;

import com.management.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//car il s'agit d'une interface
public interface ClientRepository extends JpaRepository<Client, Long> {
}
