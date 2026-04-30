package org.gyl.crudgyl.entity.DetalleVenta;
import jakarta.persistence.*;
import lombok.*;
import org.gyl.crudgyl.entity.Producto.Producto;
import org.gyl.crudgyl.entity.Venta.Venta;

@Entity
@Table(name = "detalle_venta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle_venta;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double precio_unitario;

    @Column(nullable = false)
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;
}
