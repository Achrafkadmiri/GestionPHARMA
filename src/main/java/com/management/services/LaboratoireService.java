package com.management.services;

import com.management.entities.Laboratoire;

import java.util.List;

public interface LaboratoireService {
    Laboratoire saveLaboratoire(Laboratoire p);
    Laboratoire updateLaboratoire(Laboratoire p);
    Laboratoire getLaboratoire(Long id);
    List<Laboratoire> getAllLaboratoires();
    void  deleteLaboratoireById(Long id);
    void  deleteAllLaboratoires();
}
