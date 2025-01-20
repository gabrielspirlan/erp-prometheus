package ERP.Prometheus.back_end.Infrastructure.PostgreSQL.Repositories.Endereco;


import ERP.Prometheus.back_end.Domain.Models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
