package adminRecursos.proveedores.controller;

import adminRecursos.proveedores.model.Compra;
import adminRecursos.proveedores.model.DetalleCompra;
import adminRecursos.proveedores.repository.CompraRepository;
import adminRecursos.proveedores.repository.DetalleCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController @CrossOrigin("http://localhost:5173/")
public class CompraController {
    @Autowired
    CompraRepository repository;

    @Autowired
    DetalleCompraRepository detalleComprarepository;

    @GetMapping("/getCompras")
    public List<Compra> getCompras(){
        return repository.findAll();
    }

    @GetMapping("/getIdCompra/{idCompra}")
    public Long getCompraById(@PathVariable("idCompra") Long idCompra){
        Compra compra =  repository.findById(idCompra).get();
        return compra.getId();
    }

    @GetMapping("/getComprasByidProveedor/{idProveedor}")
    public ArrayList<Compra> getDetalleCompraByIdProveedor(@PathVariable("idProveedor") Long idProveedor){
        List<DetalleCompra> detalleCompras = detalleComprarepository.findAll();
        ArrayList<DetalleCompra> detallesCoinciden = new ArrayList<>();
        ArrayList<Compra> comprasDelProveedor = new ArrayList<>();
        List<Compra> compras = repository.findAll();
        for (DetalleCompra detalleCompra: detalleCompras) {
            if(detalleCompra.getEquipamiento().getProveedor().getId().equals(idProveedor)){
                detallesCoinciden.add(detalleCompra);
            }
        }
        for (Compra compra: compras
             ) {
            for (DetalleCompra detalle: detallesCoinciden
                 ) {
                if(detalle.getCompra().getId().equals(compra.getId())){
                    comprasDelProveedor.add(compra);
                }
            }
        }
        return comprasDelProveedor;
    }
}
