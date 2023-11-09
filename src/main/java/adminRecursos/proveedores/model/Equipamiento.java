package adminRecursos.proveedores.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity @ToString @AllArgsConstructor @NoArgsConstructor
public class Equipamiento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long id;

    @Column @Getter @Setter
    private String descripcion;

    @Column @Getter @Setter
    private Double costo;

    @Column @Getter @Setter
    private Date garantia;

    @ManyToOne @JoinColumn(name = "proveedor_fk", nullable = false, updatable = false) @Getter @Setter
    private Proveedor proveedor;

    @OneToMany(mappedBy = "equipamiento")
    private List<DetalleCompra> detallesCompra;

}
