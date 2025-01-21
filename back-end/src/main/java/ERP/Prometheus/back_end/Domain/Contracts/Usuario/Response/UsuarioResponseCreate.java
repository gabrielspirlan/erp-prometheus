package ERP.Prometheus.back_end.Domain.Contracts.Usuario.Response;

import ERP.Prometheus.back_end.Domain.Contracts.Endereco.EnderecoDTO;
import ERP.Prometheus.back_end.Domain.Contracts.Usuario.UsuarioDTO;

public class UsuarioResponseCreate {

    private UsuarioDTO usuario;
    private EnderecoDTO endereco;

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public UsuarioResponseCreate () {

    }
    public UsuarioResponseCreate(UsuarioDTO usuario, EnderecoDTO endereco) {
        this.usuario = usuario;
        this.endereco = endereco;
    }
}
