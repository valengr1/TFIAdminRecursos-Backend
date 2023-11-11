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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController @CrossOrigin("http://localhost:5173/")
public class DetalleCompraController {
    @Autowired
    DetalleCompraRepository repositoryDetalleCompra;

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

    @GetMapping("/getEquipamientoPorVencerSuGarantiaByProveedor/{idProveedor}")
    public ArrayList<DetalleCompra> getEquipamientoPorVencerSuGarantia(@PathVariable("idProveedor") Long idProveedor) throws ParseException, ParseException {
        List<DetalleCompra> detalles = repositoryDetalleCompra.findAll();
        ArrayList<DetalleCompra> detallesEncontrados = new ArrayList<>();
        LocalDate fechaHoy = LocalDate.now();
        String fechaHoyString = fechaHoy.toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date fechaFinal = format.parse(fechaHoyString);
        for (DetalleCompra detalle : detalles) {
            if (detalle.getCompra().getProveedor().getId().equals(idProveedor)) {
                Date fechaInicio = format.parse(detalle.getEquipamiento().getGarantia().toString());
                Long diasRestantes = fechaInicio.getTime() - fechaFinal.getTime();
                TimeUnit unidad = TimeUnit.DAYS;
                Long dias = unidad.convert(diasRestantes,TimeUnit.MILLISECONDS);
                if(dias <= 30 && dias > 0){
                    detallesEncontrados.add(detalle);
                    System.out.println(dias);
                }
            }
        }
        return detallesEncontrados;
    }


}
