package ERP.Prometheus.back_end.Application.Services.Usuario;

import ERP.Prometheus.back_end.Domain.Contracts.Endereco.EnderecoDTO;
import ERP.Prometheus.back_end.Domain.Contracts.Usuario.Request.UsuarioRequestCreate;
import ERP.Prometheus.back_end.Domain.Contracts.Usuario.Response.UsuarioResponseCreate;
import ERP.Prometheus.back_end.Domain.Contracts.Usuario.Response.UsuarioResponseGet;
import ERP.Prometheus.back_end.Domain.Contracts.Usuario.UsuarioDTO;
import ERP.Prometheus.back_end.Domain.Models.Endereco;
import ERP.Prometheus.back_end.Domain.Models.Usuario;
import ERP.Prometheus.back_end.Infrastructure.PostgreSQL.Repositories.Endereco.EnderecoRepository;
import ERP.Prometheus.back_end.Infrastructure.PostgreSQL.Repositories.Usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements UsuarioServiceInterface {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<UsuarioResponseGet> getAll() {
        List<Usuario> usuarios =  this.usuarioRepository.findAll();
        List<UsuarioResponseGet> response = new ArrayList<UsuarioResponseGet>();
        usuarios.forEach(usuario -> response.add( new UsuarioResponseGet(
                usuario.getId(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getData_nascimento(),
                (new EnderecoDTO(
                        usuario.getEndereco().getLogradouro(),
                        usuario.getEndereco().getNumero(),
                        usuario.getEndereco().getBairro(),
                        usuario.getEndereco().getComplemento(),
                        usuario.getEndereco().getCidade(),
                        usuario.getEndereco().getEstado(),
                        usuario.getEndereco().getCep()
                )),
                usuario.getActive())));

        return response;
    }

    public UsuarioResponseGet getOneById(Integer id) {
        return this.usuarioRepository.findById(id)
                .map(usuario -> new UsuarioResponseGet(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getCpf(),
                        usuario.getData_nascimento(),
                        (new EnderecoDTO(
                                usuario.getEndereco().getLogradouro(),
                                usuario.getEndereco().getNumero(),
                                usuario.getEndereco().getBairro(),
                                usuario.getEndereco().getComplemento(),
                                usuario.getEndereco().getCidade(),
                                usuario.getEndereco().getEstado(),
                                usuario.getEndereco().getCep()
                        )),
                        usuario.getActive()
                ))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário: " + id + " não encontrado"));
    }

    @Transactional
    public UsuarioResponseCreate create (UsuarioRequestCreate request) {

        Usuario usuario = usuarioRepository.save(new Usuario(null,
                request.getUsuario().getNome(),
                request.getUsuario().getCpf(),
                request.getUsuario().getData_nascimento(),
                true));

        Endereco endereco = enderecoRepository.save(new Endereco(
                null,
                request.getEndereco().getLogradouro(),
                request.getEndereco().getNumero(),
                request.getEndereco().getBairro(),
                request.getEndereco().getComplemento(),
                request.getEndereco().getCidade(),
                request.getEndereco().getEstado(),
                request.getEndereco().getCep(),
                usuario
        ));

        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getNome(), usuario.getCpf(), usuario.getData_nascimento(), usuario.getId());

        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(), endereco.getComplemento(), endereco.getCidade(), endereco.getEstado(), endereco.getCep());

        return new UsuarioResponseCreate(usuarioDTO, enderecoDTO);
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
