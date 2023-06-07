package br.com.unipar.Hospital.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ENDERECO")

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    @NotBlank
    @NotEmpty
    @NotNull
    private String logradouro;
    @Column(length = 10)
    private String numero;
    @Column(length = 100)
    private String complemento;
    @Column(length = 100)
    @NotBlank
    @NotEmpty
    @NotNull
    private String bairro;
    @Column(length = 100)
    @NotBlank
    @NotEmpty
    @NotNull
    private String cidade;
    @Column(length = 2)
    @NotBlank
    @NotEmpty
    @NotNull
    private String uf;
    @Column(length = 10)
    @NotBlank
    @NotEmpty
    @NotNull
    private String cep;

    public Endereco(Long id, String logradouro, String numero, String complemento, String bairro, String cidade, String uf, String cep) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public Endereco() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
