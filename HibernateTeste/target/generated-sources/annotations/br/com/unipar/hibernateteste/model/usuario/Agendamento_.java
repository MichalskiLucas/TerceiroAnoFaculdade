package br.com.unipar.hibernateteste.model.usuario;

import br.com.unipar.hibernateteste.model.enums.SituacaoEnum;
import br.com.unipar.hibernateteste.model.usuario.AgendamentoServico;
import br.com.unipar.hibernateteste.model.usuario.Pet;
import br.com.unipar.hibernateteste.model.usuario.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-25T20:14:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Agendamento.class)
public class Agendamento_ { 

    public static volatile SingularAttribute<Agendamento, BigDecimal> valor_total;
    public static volatile ListAttribute<Agendamento, AgendamentoServico> agendamentoServicos;
    public static volatile SingularAttribute<Agendamento, String> obs;
    public static volatile SingularAttribute<Agendamento, SituacaoEnum> situacao;
    public static volatile SingularAttribute<Agendamento, Usuario> usuario;
    public static volatile SingularAttribute<Agendamento, Long> id;
    public static volatile SingularAttribute<Agendamento, Date> datahora;
    public static volatile SingularAttribute<Agendamento, Pet> pet;

}