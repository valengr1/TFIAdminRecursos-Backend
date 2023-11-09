package adminRecursos.proveedores.controller;

import adminRecursos.proveedores.model.Compra;
import adminRecursos.proveedores.model.DetalleCompra;
import adminRecursos.proveedores.repository.CompraRepository;
import adminRecursos.proveedores.repository.DetalleCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController @CrossOrigin("http://localhost:5173/")
public class DetalleCompraController {
    @Autowired
    DetalleCompraRepository repositoryDetalleCompra;
    CompraRepository repositoryCompra;

    @GetMapping("/getDetallesCompra")
    public List<DetalleCompra> getDetallesCompra(){
        return repositoryDetalleCompra.findAll();
    }

    @GetMapping("/getDetalleCompraByIdCompra/{idCompra}")
    public ArrayList<DetalleCompra> getDetalleCompraByIdCompra(@PathVariable("idCompra") Long idCompra){
        List<DetalleCompra> detallesCompra = repositoryDetalleCompra.findAll();
        ArrayList<DetalleCompra> detalles = new ArrayList<>();
        for (DetalleCompra detalle: detallesCompra) {
            if (idCompra.equals(detalle.getCompra().getId())){
                 detalles.add(detalle);
            }
        }
        return detalles;
    }


}
