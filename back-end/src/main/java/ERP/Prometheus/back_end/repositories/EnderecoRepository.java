package ERP.Prometheus.back_end.repositories;


import ERP.Prometheus.back_end.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
