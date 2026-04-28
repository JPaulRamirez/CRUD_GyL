package org.gyl.crudgyl.repository;

import org.gyl.crudgyl.entity.TipoProducto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto,Long>{
}
