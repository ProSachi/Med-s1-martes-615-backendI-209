package com.visual.studio.repository;

import com.visual.studio.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    List<DetalleVenta> findByVenta_Id(Long ventaId);
    List<DetalleVenta> findByname(Long ventaId);

}
