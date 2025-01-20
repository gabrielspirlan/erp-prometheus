package ERP.Prometheus.back_end.Application.Services.Usuario;

import ERP.Prometheus.back_end.Domain.Contracts.Usuario.Response.UsuarioResponseGetOneById;
import ERP.Prometheus.back_end.Domain.Models.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
