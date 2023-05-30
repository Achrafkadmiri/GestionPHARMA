package com.management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity//car il s'agit d'une entité
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordonnance {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//générer dans SGBD
    private Long idOrdonnance;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOrdonnance;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;


}
