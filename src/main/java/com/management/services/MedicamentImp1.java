package com.management.services;

import com.management.entities.Medicament;
import com.management.repositories.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicamentImp1 implements MedicamentService{

    @Autowired
    MedicamentRepository repository;
    @Override
    public Medicament saveMedicament(Medicament p) {
        return repository.save(p);
    }

    @Override
    public Medicament updateMedicament(Medicament p) {
        return repository.save(p);
    }

    @Override
    public Medicament getMedicament(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Medicament> getAllMedicaments() {
        return repository.findAll();
    }

    @Override
    public void deleteMedicamentById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllMedicaments() {
        repository.deleteAll();
    }

}
