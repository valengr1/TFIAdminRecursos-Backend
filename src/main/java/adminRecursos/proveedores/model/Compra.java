package adminRecursos.proveedores.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity @ToString @NoArgsConstructor @AllArgsConstructor
public class Compra {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long id;
    
    @Column @Getter @Setter
    private Date fechaCompra;
    
    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> detallesCompra;

    @ManyToOne @JoinColumn(name = "encargadoCompra_fk", nullable = false,updatable = false) @Getter @Setter
    private EncargadoCompras encargadoCompras;

    @ManyToOne @JoinColumn(name = "proveedor_fk", nullable = false,updatable = false) @Getter @Setter
    private Proveedor proveedor;

    public Double getTotal(){
        Double total = 0.0;
        for (DetalleCompra detalleCompra: detallesCompra) {
            total += detalleCompra.getSubtotal();
        }
        return total;
    }
    
}
