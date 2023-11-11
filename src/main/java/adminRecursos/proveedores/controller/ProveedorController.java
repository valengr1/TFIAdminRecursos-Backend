package adminRecursos.proveedores.controller;

import adminRecursos.proveedores.model.DetalleCompra;
import adminRecursos.proveedores.model.Proveedor;
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
    @GetMapping("/getProveedores")
    public List<Proveedor> getProveedores(){
        return repository.findAll();
    }

    /*@GetMapping("/getProveedoresYSuCalificacion")
    public List<DetalleCompra> getProveedoresYSuCalificacion(){
        List<DetalleCompra> detalles = detalleCompraRepository.findAll();
        Double acierto = 0.0;
        for (DetalleCompra detalle:
             detalles) {
            if(detalle.getFechaEntrega().equals(detalle.getFechaEsperada())){
                acierto++;
            }
            detalle.getEquipamiento().getProveedor()
                    .setCalificacion(acierto);
        }
        return detalles;

    }*/

    @PostMapping("/agregarProveedor")
    public String agregarProveedor(@RequestBody Proveedor proveedor){
        repository.save(proveedor);
        return "Proveedor agregado";
    }

    @DeleteMapping("/eliminarProveedor/{id}")
    public String eliminarProveedor(@PathVariable("id") Long id) {
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
