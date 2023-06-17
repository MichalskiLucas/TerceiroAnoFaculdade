package br.com.unipar.hibernateteste.model.usuario;

import br.com.unipar.hibernateteste.model.usuario.Cidade;
import br.com.unipar.hibernateteste.model.usuario.Cliente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-25T20:14:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Endereco.class)
public class Endereco_ { 

    public static volatile SingularAttribute<Endereco, Cliente> cliente;
    public static volatile SingularAttribute<Endereco, Cidade> cidade;
    public static volatile SingularAttribute<Endereco, String> numero;
    public static volatile SingularAttribute<Endereco, String> logradouro;
    public static volatile SingularAttribute<Endereco, String> bairro;
    public static volatile SingularAttribute<Endereco, Long> id_endereco;
    public static volatile SingularAttribute<Endereco, String> cep;

}