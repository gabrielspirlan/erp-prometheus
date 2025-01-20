package ERP.Prometheus.back_end.Application.Services.Usuario;

import ERP.Prometheus.back_end.Domain.Contracts.Result.Response.UsuarioResponseGetOneById;
import ERP.Prometheus.back_end.Domain.Models.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public interface UsuarioServiceInterface {
    public List<Usuario> getAll();

    public UsuarioResponseGetOneById getOneById(Integer id);

    @Transactional
    public Usuario create (Usuario usuario);

    @Transactional
    public Usuario update (Usuario updatedUsuario);

    public void delete (Integer id);
}
