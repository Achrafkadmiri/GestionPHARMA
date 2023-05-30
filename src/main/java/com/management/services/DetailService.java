package com.management.services;

import com.management.entities.DetailOrdonnance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetailService {

        DetailOrdonnance saveDetailOrdonnance(DetailOrdonnance p);
        DetailOrdonnance updateDetailOrdonnance(DetailOrdonnance p);
        DetailOrdonnance getDetail(Long id);
        List<DetailOrdonnance>  getAllDetails();
        void  deleteDetailById(Long id);
        void  deleteAllDetails();
        List<DetailOrdonnance> findByOrdonnance(Long id);

}
