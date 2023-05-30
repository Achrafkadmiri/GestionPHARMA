package com.management.services;
import com.management.entities.Medicament;
import org.springframework.stereotype.Service;
import com.management.entities.Ordonnance;

import java.util.List;

@Service
public interface OrdonnanceService {
    Ordonnance saveOrdonnance(Ordonnance ordonnance);
    Ordonnance updateOrdonnance(Ordonnance ordonnance);
    Ordonnance getOrdonnanceById(Long id);
    Ordonnance getOrdonnance(Long id);
    List<Ordonnance> getAllOrdonnances();
    void deleteOrdonnanceById(Long id);
    void deleteAllOrdonnances();
}
