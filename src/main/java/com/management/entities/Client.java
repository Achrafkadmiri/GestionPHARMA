package com.management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity//car il s'agit d'une entité
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//générer dans SGBD
    private Long idClient;
    private String nomClient;
    private String prenomClient;
    private Integer telClient;
    private String addressClient;


}
