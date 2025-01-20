package ERP.Prometheus.back_end.Application.Services.Endereco;

import ERP.Prometheus.back_end.Domain.Models.Endereco;
import ERP.Prometheus.back_end.Infrastructure.PostgreSQL.Repositories.Endereco.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EnderecoService implements EnderecoServiceInterface {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> getAll() {
        return this.enderecoRepository.findAll();
    }

    public Endereco getOneById(Integer id) {
        return this.enderecoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço: " + id + "não encontrado"));
    }

    @Transactional
    public Endereco create (Endereco endereco) {
        endereco.setId(null);
        return this.enderecoRepository.save(endereco);
    }

    @Transactional
    public Endereco update (Endereco updatedEndereco) {

        Endereco endereco = getOneById(updatedEndereco.getId());

        if (updatedEndereco.getLogradouro() != null)
            endereco.setLogradouro(updatedEndereco.getLogradouro());

        if (updatedEndereco.getNumero() != null)
            endereco.setNumero(updatedEndereco.getNumero());

        if (updatedEndereco.getBairro() != null)
            endereco.setBairro(updatedEndereco.getBairro());

        if (updatedEndereco.getComplemento() != null)
            endereco.setComplemento(updatedEndereco.getComplemento());

        if (updatedEndereco.getCidade() != null)
            endereco.setCidade(updatedEndereco.getCidade());

        if (updatedEndereco.getCep() != null)
            endereco.setCep(updatedEndereco.getCep());

        if (updatedEndereco.getEstado() != null)
            endereco.setEstado(updatedEndereco.getEstado());

        if (updatedEndereco.getUsuario() != null)
            endereco.setUsuario(updatedEndereco.getUsuario());

        return this.enderecoRepository.save(endereco);
    }

    public void delete (Integer id) {
        getOneById(id);
        try {
            this.enderecoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir, pois há entidades relacionadas!");
        }
    }

}
