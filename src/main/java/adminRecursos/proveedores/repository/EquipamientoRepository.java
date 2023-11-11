package adminRecursos.proveedores.repository;

import adminRecursos.proveedores.model.Equipamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamientoRepository extends JpaRepository <Equipamiento,Long> {
}
