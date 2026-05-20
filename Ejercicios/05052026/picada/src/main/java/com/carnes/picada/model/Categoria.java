package com.carnes.picada.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Categoria extends Segura {

    @Column(name = "nombre", length = 100, nullable = false)
    public String name;

    @Column(name = "cantidadDisponible", nullable = false)
    public int stock;

    @Column(name = "tipoCategoria", nullable = false)
    public String type;


    public Categoria() {
    }
    

    public Categoria(String name, int stock, String type) {
        this.name = name;
        this.stock = stock;
        this.type = type;
    }

       public Categoria(Long id, boolean isActive) {
        super(id, isActive);
    }

    public Categoria(Long id, boolean isActive, String name, int stock, String type) {
        super(id, isActive);
        this.name = name;
        this.stock = stock;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
