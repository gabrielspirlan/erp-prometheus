package ERP.Prometheus.back_end.Domain.Contracts.Usuario.Request;

import ERP.Prometheus.back_end.Domain.Contracts.Endereco.EnderecoDTO;
import ERP.Prometheus.back_end.Domain.Contracts.Usuario.UsuarioDTO;

public class UsuarioRequestCreate {
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

    public UsuarioRequestCreate () {

    }

    public UsuarioRequestCreate(UsuarioDTO usuario, EnderecoDTO endereco) {
        this.usuario = usuario;
        this.endereco = endereco;
    }
}
