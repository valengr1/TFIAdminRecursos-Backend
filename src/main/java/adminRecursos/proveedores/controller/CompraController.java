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

    @GetMapping("/getCompras")
    public List<Compra> getCompras(){
        return repository.findAll();
    }

    @GetMapping("/getComprasByidProveedor/{idProveedor}")
    public ArrayList<Compra> getDetalleCompraByIdProveedor(@PathVariable("idProveedor") Long idProveedor){
        List<Compra> compras= repository.findAll();
        ArrayList<Compra> comprasCoinciden = new ArrayList<>();
        for (Compra compra: compras) {
            if(idProveedor.equals(compra.getProveedor().getId())){
                comprasCoinciden.add(compra);
            }
        }
        return comprasCoinciden;
    }
}
