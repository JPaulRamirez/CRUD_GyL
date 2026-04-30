package org.gyl.crudgyl.repository.Cliente;

import org.gyl.crudgyl.entity.Cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
