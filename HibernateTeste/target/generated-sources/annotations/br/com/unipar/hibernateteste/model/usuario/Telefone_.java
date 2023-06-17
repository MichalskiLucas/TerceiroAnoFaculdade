package br.com.unipar.hibernateteste.model.usuario;

import br.com.unipar.hibernateteste.model.enums.TipoTelefoneEnum;
import br.com.unipar.hibernateteste.model.usuario.Cliente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-25T20:14:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Telefone.class)
public class Telefone_ { 

    public static volatile SingularAttribute<Telefone, Cliente> cliente;
    public static volatile SingularAttribute<Telefone, String> telefone;
    public static volatile SingularAttribute<Telefone, TipoTelefoneEnum> tipo;
    public static volatile SingularAttribute<Telefone, Long> id_telefone;

}