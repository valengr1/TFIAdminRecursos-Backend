package adminRecursos.proveedores.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Proveedor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long id;

    @Column @Getter @Setter
    private Long CUIT;

    @Column @Getter @Setter
    private String razonSocial;

    @Column @Getter @Setter
    private String direccion;

    @Column @Getter @Setter
    private Long telefono;

    @Column @Getter @Setter
    private Double calificacion;

    @OneToMany(mappedBy = "proveedor")
    private List<Compra> compras;
}
