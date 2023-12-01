package com.example.financial.domain;

import com.example.financial.enums.TipoRegistroENUM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
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

    @Column(columnDefinition = "numeric(10,2)")
    private BigDecimal valor;

//    @ManyToOne
//    private Usuario usuario;

    @ManyToOne
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private TipoRegistroENUM tipoRegistroENUM;
}
