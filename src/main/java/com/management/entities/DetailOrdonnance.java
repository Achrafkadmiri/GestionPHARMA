package com.management.entities;

import jakarta.persistence.*;
@Entity
public class DetailOrdonnance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetail;
    private int qteMedicament;

    @ManyToOne(fetch = FetchType.LAZY)
    private Medicament medicament;
    @ManyToOne(fetch = FetchType.LAZY)
    private Ordonnance ordonnance;

    public DetailOrdonnance(Long idDetail, int qteMedicament, Medicament medicament, Ordonnance ordonnance) {
        this.idDetail = idDetail;
        this.qteMedicament = qteMedicament;
        this.medicament = medicament;
        this.ordonnance = ordonnance;
    }

    public Long getIdDetail() {
        return idDetail;
    }

    public int getQteMedicament() {
        return qteMedicament;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public Ordonnance getOrdonnance() {
        return ordonnance;
    }

    public void setIdDetail(Long idDetail) {
        this.idDetail = idDetail;
    }

    public void setQteMedicament(int qteMedicament) {
        this.qteMedicament = qteMedicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }
}
