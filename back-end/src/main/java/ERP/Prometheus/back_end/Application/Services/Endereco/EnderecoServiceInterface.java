package ERP.Prometheus.back_end.Application.Services.Endereco;

import ERP.Prometheus.back_end.Domain.Models.Endereco;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnderecoServiceInterface {


    public List<Endereco> getAll();

    public Endereco getOneById(Integer id);

    @Transactional
    public Endereco create (Endereco endereco);

    @Transactional
    public Endereco update (Endereco updatedEndereco);

    public void delete (Integer id);
}
