package adminRecursos.proveedores.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity @ToString @AllArgsConstructor @NoArgsConstructor
public class DetalleCompra {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long id;

    @Column @Getter @Setter
    private int cantidad;

    @Column @Getter @Setter
    private Date fechaEsperada;

    @Column @Getter @Setter
    private Date fechaEntrega;

    @ManyToOne @JoinColumn(name = "equipamiento_fk", nullable = false, updatable = false) @Getter @Setter
    private Equipamiento equipamiento;

    @ManyToOne @JoinColumn(name = "compra_fk",nullable = false,updatable = false) @Getter @Setter
    private Compra compra;

    public Double getSubtotal(){
        return cantidad * equipamiento.getCosto();
    }
}
