package ERP.Prometheus.back_end.models;

import jakarta.persistence.*;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table()
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Column(length = 200)
   private String logradouro;

    @Column(length = 200)
   private String numero;

    @Column(length = 200)
    private String bairro;

   @Column (length = 200, nullable = true)
   private String complemento;

    @Column (length = 200)
    private String cidade;

    @Column (length = 200)
    private String estado;

    @Column(length = 9)
    private String cep;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }




//    public List<Usuario> getUsuarios() {
//        return usuarios;
//    }
//
//    public void setUsuarios(List<Usuario> usuarios) {
//        this.usuarios = usuarios;
//    }

//   @OneToMany(mappedBy = "endereco")
//   private List<Usuario> usuarios = new ArrayList<Usuario>();
}
