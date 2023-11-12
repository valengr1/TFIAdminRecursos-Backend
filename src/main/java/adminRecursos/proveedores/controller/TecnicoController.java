package adminRecursos.proveedores.controller;

import adminRecursos.proveedores.model.Tecnico;
import adminRecursos.proveedores.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController @CrossOrigin("http://localhost:5173/")
public class TecnicoController {
    @Autowired
    TecnicoRepository repository;

    @PostMapping("/agregarTecnico")
    public String agregarTecnico(@RequestBody Tecnico tecnico){
        repository.save(tecnico);
        return "Tecnico agregado";
    }
}
