package ERP.Prometheus.back_end.Infrastructure.PostgreSQL.Repositories.Usuario;

import ERP.Prometheus.back_end.Domain.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
