package adminRecursos.proveedores.controller;

import adminRecursos.proveedores.model.Proveedor;
import adminRecursos.proveedores.model.Tecnico;
import adminRecursos.proveedores.repository.ProveedorRepository;
import adminRecursos.proveedores.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173/")
public class TecnicoController {
    @Autowired
    TecnicoRepository repository;

    @Autowired
    ProveedorRepository proveedorRepository;

    @GetMapping("/getTecnicos")
    public List<Tecnico> getTecnicos(){
        return repository.findAll();
    }

    @PostMapping("/agregarTecnico/{idProveedor}")
    public String agregarTecnico(@RequestBody Tecnico tecnico, @PathVariable("idProveedor") Long idProveedor){
        Proveedor proveedor = proveedorRepository.findById(idProveedor).get();
        tecnico.setProveedor(proveedor);
        repository.save(tecnico);
        return "Tecnico agregado";
    }
}
