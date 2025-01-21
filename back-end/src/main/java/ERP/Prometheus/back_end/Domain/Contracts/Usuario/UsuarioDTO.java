package ERP.Prometheus.back_end.Domain.Contracts.Usuario;

import java.util.Date;

public class UsuarioDTO {

    private String nome;
    private String cpf;
    private Date data_nascimento;
    private Integer id;
    private Boolean isActive;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public UsuarioDTO() {

    }

    public UsuarioDTO(String nome, String cpf, Date data_nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
    }

    public UsuarioDTO(String nome, String cpf, Date data_nascimento, Integer id) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.id = id;
    }

    public UsuarioDTO(String nome, String cpf, Date data_nascimento, Integer id, Boolean isActive) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.id = id;
        this.isActive = isActive;
    }
}
