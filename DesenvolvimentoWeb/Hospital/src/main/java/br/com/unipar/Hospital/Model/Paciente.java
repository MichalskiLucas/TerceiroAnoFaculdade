package br.com.unipar.Hospital.Model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PACIENTE")
@ApiModel(description = "Modelo de representação de Pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    @NotBlank
    @NotEmpty
    @NotNull
    private String nome;

    @Column(length = 50)
    @NotBlank
    @NotEmpty
    @NotNull
    private String email;

    @Column(length = 20)
    @NotBlank
    @NotEmpty
    @NotNull
    private String telefone;

    @Column(length = 11)
    @NotBlank
    @NotEmpty
    @NotNull
    @CPF
    private String cpf;

    @OneToOne
    private Endereco endereco;

    private boolean ativo = true;

    public Paciente() {
    }

    public Paciente(Long id, String nome, String email, String telefone, String cpf, Endereco endereco, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
