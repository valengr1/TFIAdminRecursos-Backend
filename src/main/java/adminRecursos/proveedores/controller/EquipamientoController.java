package adminRecursos.proveedores.controller;
import adminRecursos.proveedores.model.DetalleCompra;
import adminRecursos.proveedores.model.Equipamiento;
import adminRecursos.proveedores.repository.EquipamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController @CrossOrigin("http://localhost:5173/")
public class EquipamientoController {
    @Autowired
    EquipamientoRepository repository;

    @GetMapping("/getEquipamientos")
    public List<Equipamiento> getEquipamientos(){
        return repository.findAll();
    }

    @GetMapping("/getEquipamientoPorVencerSuGarantiaByProveedor/{idProveedor}")
    public ArrayList<Equipamiento> getEquipamientoPorVencerSuGarantia(@PathVariable("idProveedor") Long idProveedor) throws ParseException, ParseException {
        List<Equipamiento> equipamientos = repository.findAll();
        ArrayList<Equipamiento> equipamientosDelProveedor = new ArrayList<>();
        ArrayList<Equipamiento> equipamientosPorVencerSuGarantia = new ArrayList<>();

        for (Equipamiento equipamiento : equipamientos) {
            if (equipamiento.getProveedor().getId().equals(idProveedor)) {
                equipamientosDelProveedor.add(equipamiento);
            }
        }

        for (Equipamiento equipamiento: equipamientosDelProveedor
             ) {
            String Dateinicio = equipamiento.getGarantia().toString();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaInicio = date.parse(Dateinicio);
            Date fechaactual = new Date(System.currentTimeMillis());
            int milisecondsByDay = 86400000;
            int dias = (int) ((fechaactual.getTime()-fechaInicio.getTime()) / milisecondsByDay);
            if (dias <= 0) {
                if(Math.abs(dias) <= 30){
                    equipamientosPorVencerSuGarantia.add(equipamiento);
                    System.out.println(dias);
                }
            }
        }
        return equipamientosPorVencerSuGarantia;
    }
}
