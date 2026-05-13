package org.gyl.crudgyl.repository.producto;

import org.gyl.crudgyl.entity.Producto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombre(String nombre);
}
