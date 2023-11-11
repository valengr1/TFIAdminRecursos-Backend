package adminRecursos.proveedores.controller;
import adminRecursos.proveedores.model.Equipamiento;
import adminRecursos.proveedores.repository.EquipamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController @CrossOrigin("http://localhost:5173/")
public class EquipamientoController {
    @Autowired
    EquipamientoRepository repository;

    @GetMapping("/getEquipamientos")
    public List<Equipamiento> getEquipamientos(){
        return repository.findAll();
    }
}
