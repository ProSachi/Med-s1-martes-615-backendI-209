package com.carnes.picada.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto")
public class Productos extends Segura {

    @Column(name = "nombre", length = 100, nullable = false)
    public String name;

    @Column(name = "cantidadDisponible", nullable = false)
    public int stock;
    
    @Column(name = "descripcion", length = 250, nullable = true)
    public String description;
   
    public Productos(Long id, boolean isActive, String name, int stock, String description) {
        super(id, isActive);
        this.name = name;
        this.stock = stock;
        this.description = description;
    }

    public Productos(String name, int stock, String description) {
        this.name = name;
        this.stock = stock;
        this.description = description;
    }

        public Productos(Long id, boolean isActive) {
        super(id, isActive);
    }

    public Productos() {
    }   
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
 
    
    
}
