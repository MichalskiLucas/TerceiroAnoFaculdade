package br.com.unipar.Hospital.DTO;

import br.com.unipar.Hospital.Enum.EspecialidadeEnum;

public class MedicoDto {
    private String nome;
    private String email;
    private String crm;
    private EspecialidadeEnum especialidade;

    public MedicoDto() {
    }

    public MedicoDto(String nome, String email, String crm, EspecialidadeEnum especialidade) {
        this.nome = nome;
        this.email = email;
        this.crm = crm;
        this.especialidade = especialidade;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public EspecialidadeEnum getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(EspecialidadeEnum especialidade) {
        this.especialidade = especialidade;
    }
}
