package org.gyl.crudgyl.entity.TipoProductoEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="tipo_producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_tipo_producto;

    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 100)
    private String descripcion;



}
