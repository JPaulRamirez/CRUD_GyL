package org.gyl.crudgyl.repository.TipoProducto;

import org.gyl.crudgyl.entity.TipoProducto.TipoProducto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto,Long>{
}
