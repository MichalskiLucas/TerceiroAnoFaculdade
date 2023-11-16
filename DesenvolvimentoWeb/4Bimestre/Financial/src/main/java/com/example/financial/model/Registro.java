package com.example.financial.model;

import com.example.financial.enums.TipoRegistroENUM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "REGISTRO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataRegistro;
    private String descricao;
    private double valor;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Categoria categoria;
    private TipoRegistroENUM tipoRegistroENUM;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TipoRegistroENUM getTipoRegistroENUM() {
        return tipoRegistroENUM;
    }

    public void setTipoRegistroENUM(TipoRegistroENUM tipoRegistroENUM) {
        this.tipoRegistroENUM = tipoRegistroENUM;
    }
}
