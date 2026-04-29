package com.colanta.distribucion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Perro {
    
    @Id
    private int id;
    
    @Column(name = "Nombre")
    private String name;
    
    @Column(name = "Edad")
    private int age; 
    
    @Column(name = "Color")
    private int color; 
    
    @Column(name = "Raza")
    private int raza; 

}
