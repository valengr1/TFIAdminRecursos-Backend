package adminRecursos.proveedores.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @ToString @NoArgsConstructor @AllArgsConstructor
public class EncargadoCompras {

    @Id @Getter @Setter
    private Long legajo;

    @Column @Getter @Setter
    private String nombre;

    @Column @Getter @Setter
    private String apellido;

    @Column @Getter @Setter
    private Long dni;

    @Column @Getter @Setter
    private String contraseña;

    @OneToMany(mappedBy = "encargadoCompras")
    private List<Compra> compras;
}
