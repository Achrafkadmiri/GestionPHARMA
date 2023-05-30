package com.management.services;
import com.management.entities.Medicament;
import com.management.entities.Ordonnance;
import com.management.repositories.OrdonnanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdonnanceServiceImpl  implements OrdonnanceService {
    @Autowired
    OrdonnanceRepository ordonnanceRepository;
    @Override
    public Ordonnance saveOrdonnance(Ordonnance ordonnance) {
        return ordonnanceRepository.save(ordonnance);
    }

    @Override
    public Ordonnance updateOrdonnance(Ordonnance ordonnance) {

        return ordonnanceRepository.save(ordonnance);
    }
    @Override
    public Ordonnance getOrdonnance(Long id) {
        return ordonnanceRepository.findById(id).get();
    }
    @Override
    public Ordonnance getOrdonnanceById(Long id) {

        return ordonnanceRepository.findById(id).get();
    }

    @Override
    public List<Ordonnance> getAllOrdonnances() {

        return ordonnanceRepository.findAll();
    }


    @Override
    public void deleteOrdonnanceById(Long id) {
        ordonnanceRepository.deleteById(id);
    }

    @Override
    public void deleteAllOrdonnances() {
        ordonnanceRepository.deleteAll();
    }
}

