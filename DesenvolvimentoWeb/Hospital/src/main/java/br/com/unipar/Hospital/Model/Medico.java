package br.com.unipar.Hospital.Model;

import br.com.unipar.Hospital.Enum.EspecialidadeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MEDICO")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    @NotBlank
    @NotEmpty
    @NotNull
    private String nome;

    @Column(length = 20)
    @NotBlank
    @NotEmpty
    @NotNull
    private String telefone;

    @Column(length = 50)
    @NotBlank
    @NotEmpty
    @NotNull
    private String email;

    @Column(length = 6)
    @NotBlank
    @NotEmpty
    @NotNull
    private String crm;

    @OneToOne
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidade;

    private boolean ativo = true;

    public Medico() {
    }

    public Medico(Long id, String nome, String telefone, String email, String crm, Endereco endereco, EspecialidadeEnum especialidade, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.crm = crm;
        this.endereco = endereco;
        this.especialidade = especialidade;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public EspecialidadeEnum getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(EspecialidadeEnum especialidade) {
        this.especialidade = especialidade;
    }
}
