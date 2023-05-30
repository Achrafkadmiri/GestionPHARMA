package com.management.services;

import com.management.entities.Laboratoire;
import com.management.entities.Medicament;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MedicamentService {
    Medicament saveMedicament(Medicament p);
    Medicament updateMedicament(Medicament p);
    Medicament getMedicament(Long id);
    List<Medicament> getAllMedicaments();
    void  deleteMedicamentById(Long id);
    void  deleteAllMedicaments();
}
