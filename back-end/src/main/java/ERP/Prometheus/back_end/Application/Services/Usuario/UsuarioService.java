package ERP.Prometheus.back_end.Application.Services.Usuario;

import ERP.Prometheus.back_end.Domain.Contracts.Endereco.EnderecoDTO;
import ERP.Prometheus.back_end.Domain.Contracts.Usuario.Response.UsuarioResponseGetOneById;
import ERP.Prometheus.back_end.Domain.Models.Usuario;
import ERP.Prometheus.back_end.Infrastructure.PostgreSQL.Repositories.Usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService implements UsuarioServiceInterface {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return this.usuarioRepository.findAll();
    }

    public UsuarioResponseGetOneById getOneById(Integer id) {
        return this.usuarioRepository.findById(id)
                .map(usuario -> new UsuarioResponseGetOneById(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getCpf(),
                        usuario.getData_nascimento(),
                        usuario.getActive(),
                        new EnderecoDTO(
                                usuario.getEndereco().getId(),
                                usuario.getEndereco().getLogradouro(),
                                usuario.getEndereco().getNumero(),
                                usuario.getEndereco().getBairro(),
                                usuario.getEndereco().getComplemento(),
                                usuario.getEndereco().getCidade(),
                                usuario.getEndereco().getEstado(),
                                usuario.getEndereco().getCep()
                        )
                ))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário: " + id + " não encontrado"));
    }

    @Transactional
    public Usuario create (Usuario usuario) {
        usuario.setId(null);
        return this.usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario update (Usuario updatedUsuario) {

//        Usuario usuario = getOneById(updatedUsuario.getId());
//
//        if (updatedUsuario.getNome() != null)
//            usuario.setNome(updatedUsuario.getNome());
//
//        if (updatedUsuario.getCpf() != null)
//            usuario.setCpf(updatedUsuario.getCpf());
//
//        if (updatedUsuario.getData_nascimento() != null)
//            usuario.setData_nascimento(updatedUsuario.getData_nascimento());
//
//        if (updatedUsuario.getActive() != null)
//            usuario.setActive(updatedUsuario.getActive());
//
//        return this.usuarioRepository.save(usuario);
        return new Usuario();
    }

    public void delete (Integer id) {
        getOneById(id);
        System.out.println("Tentativa de executar exclusão do item: " + id);
        try {
            this.usuarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir, pois há entidades relacionadas!");
        }

    }

}
