package ERP.Prometheus.back_end.Application.Services.Usuario;

import ERP.Prometheus.back_end.Domain.Contracts.Usuario.Request.UsuarioRequestCreate;
import ERP.Prometheus.back_end.Domain.Contracts.Usuario.Response.UsuarioResponseCreate;
import ERP.Prometheus.back_end.Domain.Contracts.Usuario.Response.UsuarioResponseGet;
import ERP.Prometheus.back_end.Domain.Models.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioServiceInterface {
    public List<UsuarioResponseGet> getAll();

    public UsuarioResponseGet getOneById(Integer id);

    @Transactional
    public UsuarioResponseCreate create (UsuarioRequestCreate request);

    @Transactional
    public Usuario update (Usuario updatedUsuario);

    public void delete (Integer id);
}
