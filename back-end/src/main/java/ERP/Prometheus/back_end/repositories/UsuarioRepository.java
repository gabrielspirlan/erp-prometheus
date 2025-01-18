package ERP.Prometheus.back_end.repositories;

import ERP.Prometheus.back_end.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
