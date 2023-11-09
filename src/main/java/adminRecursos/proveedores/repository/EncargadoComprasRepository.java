package adminRecursos.proveedores.repository;

import adminRecursos.proveedores.model.EncargadoCompras;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository @Transactional
public interface EncargadoComprasRepository extends JpaRepository<EncargadoCompras,Long> {
}
