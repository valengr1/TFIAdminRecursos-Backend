package adminRecursos.proveedores.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Tecnico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long id;

    @Column @Getter @Setter
    private String nombre;

    @Column @Getter @Setter
    private String apellido;

    @Column @Getter @Setter
    private String servicio;

    @ManyToOne @JoinColumn(name = "proveedor_fk", nullable = false, updatable = false)
    private Proveedor proveedor;

}
