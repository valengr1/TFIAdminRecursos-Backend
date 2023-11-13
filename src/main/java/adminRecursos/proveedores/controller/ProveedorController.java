package adminRecursos.proveedores.controller;

import adminRecursos.proveedores.model.Compra;
import adminRecursos.proveedores.model.DetalleCompra;
import adminRecursos.proveedores.model.Proveedor;
import adminRecursos.proveedores.repository.CompraRepository;
import adminRecursos.proveedores.repository.DetalleCompraRepository;
import adminRecursos.proveedores.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController @CrossOrigin("http://localhost:5173/")
public class ProveedorController {
    @Autowired
    ProveedorRepository repository;

    @Autowired
    DetalleCompraRepository detalleCompraRepository;
    @Autowired
    CompraRepository compraRepository;
    @GetMapping("/getProveedores")
    public List<Proveedor> getProveedores(){
        return repository.findAll();
    }

    @PostMapping("/agregarProveedor")
    public String agregarProveedor(@RequestBody Proveedor proveedor){
        repository.save(proveedor);
        return "Proveedor agregado";
    }

    @DeleteMapping("/eliminarProveedor/{id}")
    public String eliminarProveedor(@PathVariable("id") Long id) {
        List<Compra> compras = compraRepository.findAll();
        List<DetalleCompra> detallesCompra = detalleCompraRepository.findAll();
        ArrayList<DetalleCompra> detallesCompraDelProveedor = new ArrayList<>();
        ArrayList<Compra> comprasDelProveedor = new ArrayList<>();

        for (Compra compra: compras
             ) {
            if(compra.getProveedor().getId().equals(id)){
                comprasDelProveedor.add(compra);
            }
        }

        for (Compra compra: comprasDelProveedor
             ) {
            for (DetalleCompra detalle: detallesCompra
                 ) {
                if(compra.getId().equals(detalle.getCompra().getId())){
                    detallesCompraDelProveedor.add(detalle);
                }
            }
        }

        for (DetalleCompra detalle: detallesCompraDelProveedor
             ) {
            detalleCompraRepository.deleteById(detalle.getId());
        }

        for (Compra compra: comprasDelProveedor
             ) {
            compraRepository.deleteById(compra.getId());
        }

        repository.deleteById(id);
        return "Proveedor eliminado";
    }

    @GetMapping("/getProveedor/{id}")
    public Optional<Proveedor> getProveedorById(@PathVariable("id") Long id){
        return repository.findById(id);
    }

    @PutMapping("/modificarProveedor/{id}")
    public String modificarProveedor(@PathVariable("id") Long id, @RequestBody Proveedor proveedor){
        Proveedor updatedProveedor = repository.findById(id).get();
        updatedProveedor.setCUIT(proveedor.getCUIT());
        updatedProveedor.setId(proveedor.getId());
        updatedProveedor.setDireccion(proveedor.getDireccion());
        updatedProveedor.setTelefono(proveedor.getTelefono());
        updatedProveedor.setRazonSocial(proveedor.getRazonSocial());
        repository.save(updatedProveedor);
        return "Proveedor modificado";
    }
}
