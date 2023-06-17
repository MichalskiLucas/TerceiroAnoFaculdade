package br.com.unipar.hibernateteste.model.usuario;

import br.com.unipar.hibernateteste.model.usuario.Agendamento;
import br.com.unipar.hibernateteste.model.usuario.Servico;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-25T20:14:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(AgendamentoServico.class)
public class AgendamentoServico_ { 

    public static volatile SingularAttribute<AgendamentoServico, Long> id_agendamentoservico;
    public static volatile SingularAttribute<AgendamentoServico, BigDecimal> valor_un;
    public static volatile SingularAttribute<AgendamentoServico, Servico> servico;
    public static volatile SingularAttribute<AgendamentoServico, Agendamento> agendamento;

}