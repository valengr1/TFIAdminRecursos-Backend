package adminRecursos.proveedores.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
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

    @OneToMany(mappedBy = "equipamiento")
    private List<DetalleCompra> detallesCompra;

}
