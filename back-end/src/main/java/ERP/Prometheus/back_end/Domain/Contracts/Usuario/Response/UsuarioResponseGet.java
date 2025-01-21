package ERP.Prometheus.back_end.Domain.Contracts.Usuario.Response;
import ERP.Prometheus.back_end.Domain.Contracts.Endereco.EnderecoDTO;
import ERP.Prometheus.back_end.Domain.Contracts.Usuario.UsuarioDTO;

import java.util.Date;

public class UsuarioResponseGet extends UsuarioDTO {

    private EnderecoDTO endereco;


    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public UsuarioResponseGet () {

    }

    public UsuarioResponseGet (Integer id, String nome, String cpf, Date data_nascimento, EnderecoDTO endereco, Boolean isActive) {
        super(nome, cpf, data_nascimento, id, isActive);
        this.endereco = endereco;
    }

    public UsuarioResponseGet( EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
