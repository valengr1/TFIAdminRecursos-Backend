package adminRecursos.proveedores.controller;

import adminRecursos.proveedores.model.EncargadoCompras;
import adminRecursos.proveedores.model.Proveedor;
import adminRecursos.proveedores.repository.EncargadoComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @CrossOrigin("http://localhost:5173/")
public class EncargadoComprasController {
    @Autowired
    EncargadoComprasRepository repository;

    @GetMapping("/getEncargadoAndCheck/{legajo}/{contraseña}")
    public Boolean getEncargadoCompras(@PathVariable Long legajo, @PathVariable String contraseña){
        EncargadoCompras encargadoCheck =  repository.findById(legajo).get();
        if(encargadoCheck.getContraseña().equals(contraseña)){
            return true;
        } else{
            return false;
        }
    }

    @GetMapping("/getEncargado/{legajo}")
    public EncargadoCompras getEncargado(@PathVariable Long legajo){
        return repository.findById(legajo).get();

    }


}
