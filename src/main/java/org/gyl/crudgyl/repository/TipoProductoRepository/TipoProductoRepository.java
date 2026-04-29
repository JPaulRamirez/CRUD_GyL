package org.gyl.crudgyl.repository.TipoProductoRepository;

import org.gyl.crudgyl.entity.TipoProductoEntity.TipoProducto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto,Long>{
}
