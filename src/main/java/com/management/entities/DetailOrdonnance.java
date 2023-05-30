package com.management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetailOrdonnance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetail;
    private int qteMedicament;

    @ManyToOne(fetch = FetchType.LAZY)
    private Medicament medicament;
    @ManyToOne(fetch = FetchType.LAZY)
    private Ordonnance ordonnance;


}
