package br.com.unipar.hibernateteste.model.usuario;

import br.com.unipar.hibernateteste.model.usuario.Endereco;
import br.com.unipar.hibernateteste.model.usuario.Telefone;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-25T20:14:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Boolean> ativo;
    public static volatile SingularAttribute<Cliente, Long> id_cliente;
    public static volatile ListAttribute<Cliente, Endereco> enderecos;
    public static volatile SingularAttribute<Cliente, String> cpf;
    public static volatile SingularAttribute<Cliente, String> nome;
    public static volatile ListAttribute<Cliente, Telefone> telefones;
    public static volatile SingularAttribute<Cliente, String> email;

}