package com.management.services;

import com.management.entities.Laboratoire;
import com.management.repositories.LaboratoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LaboratoireImp1 implements LaboratoireService{

    @Autowired
    LaboratoireRepository repository;
    @Override
    public Laboratoire saveLaboratoire(Laboratoire p) {
        return repository.save(p);
    }

    @Override
    public Laboratoire updateLaboratoire(Laboratoire p) {
        return repository.save(p);
    }

    @Override
    public Laboratoire getLaboratoire(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Laboratoire> getAllLaboratoires() {
        return repository.findAll();
    }

    @Override
    public void deleteLaboratoireById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllLaboratoires() {
        repository.deleteAll();
    }

}
