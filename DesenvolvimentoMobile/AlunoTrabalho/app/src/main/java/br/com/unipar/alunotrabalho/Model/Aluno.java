package br.com.unipar.alunotrabalho.Model;

import java.util.ArrayList;

public class Aluno {
    String ra = "";
    String nome;
    ArrayList<Bimestre> notaBimestre = new ArrayList<>();

    public Aluno() {
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Bimestre> getNotasBimestre() {
        return notaBimestre;
    }

    public void setNotaBimestreAluno(Bimestre notasBimestre) {
        for (Bimestre nota:this.notaBimestre) {
            if (nota.getBimestre().equals(notasBimestre.getBimestre()) && nota.getDisciplina().equals(notasBimestre.getDisciplina())){
                this.notaBimestre.remove(nota);
            }
        }
        this.notaBimestre.add(notasBimestre);
    }
}
