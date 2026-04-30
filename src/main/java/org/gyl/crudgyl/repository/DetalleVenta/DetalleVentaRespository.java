package org.gyl.crudgyl.repository.DetalleVenta;

import org.gyl.crudgyl.entity.DetalleVenta.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
}
