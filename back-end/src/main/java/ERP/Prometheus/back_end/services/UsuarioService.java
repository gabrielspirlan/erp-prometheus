package ERP.Prometheus.back_end.services;

import ERP.Prometheus.back_end.models.Usuario;
import ERP.Prometheus.back_end.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return this.usuarioRepository.findAll();
    }

    public Usuario getOneById(Integer id) {
        return this.usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário: " + id + "não encontrado"));
    }

    @Transactional
    public Usuario create (Usuario usuario) {
        usuario.setId(null);
        return this.usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario update (Usuario updatedUsuario) {

        Usuario usuario = getOneById(updatedUsuario.getId());

        if (updatedUsuario.getNome() != null)
            usuario.setNome(updatedUsuario.getNome());

        if (updatedUsuario.getCpf() != null)
            usuario.setCpf(updatedUsuario.getCpf());

        if (updatedUsuario.getData_nascimento() != null)
            usuario.setData_nascimento(updatedUsuario.getData_nascimento());

        if (updatedUsuario.getActive() != null)
            usuario.setActive(updatedUsuario.getActive());

        return this.usuarioRepository.save(usuario);
    }

    public void delete (Integer id) {
        getOneById(id);
        try {
            this.usuarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir, pois há entidades relacionadas!");
        }

    }

}
