package br.com.unipar.hibernateteste.model.usuario;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-25T20:14:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Servico.class)
public class Servico_ { 

    public static volatile SingularAttribute<Servico, Long> id_servico;
    public static volatile SingularAttribute<Servico, BigDecimal> valor;
    public static volatile SingularAttribute<Servico, String> descricao;

}