package com.management.services;

import com.management.entities.DetailOrdonnance;
import com.management.entities.Medicament;
import com.management.repositories.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailImp1 implements DetailService{

    @Autowired
    DetailRepository repository;
    @Override
    public DetailOrdonnance saveDetailOrdonnance(DetailOrdonnance p) {
        return repository.save(p);
    }

    @Override
    public DetailOrdonnance updateDetailOrdonnance(DetailOrdonnance p) {
        return repository.save(p);
    }



    @Override
    public DetailOrdonnance getDetail(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<DetailOrdonnance> getAllDetails() {
        return repository.findAll();
    }

    @Override
    public void deleteDetailById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllDetails() {
        repository.deleteAll();
    }


   /* public List<DetailOrdonnance> findByOrdonnance(Long id) {
        return repository.findByOrdonance(id);
    }*/



}
