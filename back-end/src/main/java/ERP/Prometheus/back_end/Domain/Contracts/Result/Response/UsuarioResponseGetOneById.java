package ERP.Prometheus.back_end.Domain.Contracts.Result.Response;
import ERP.Prometheus.back_end.Domain.Contracts.Endereco.EnderecoDTO;
import ERP.Prometheus.back_end.Domain.Models.Endereco;

import java.util.Date;

public class UsuarioResponseGetOneById {

    private Integer id;
    private String nome;
    private String cpf;
    private Date data_nascimento;
    private EnderecoDTO endereco;
    private Boolean isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public Boolean getIsActive () {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public UsuarioResponseGetOneById () {

    }

    public UsuarioResponseGetOneById(Integer id, String nome, String cpf, Date data_nascimento,Boolean isActive, EnderecoDTO endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.isActive = isActive;
        this.endereco = endereco;
    }
}
