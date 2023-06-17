package br.com.unipar.hibernateteste.model.usuario;

import br.com.unipar.hibernateteste.model.enums.GeneroEnum;
import br.com.unipar.hibernateteste.model.enums.TamanhoEnum;
import br.com.unipar.hibernateteste.model.usuario.Cliente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-25T20:14:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Pet.class)
public class Pet_ { 

    public static volatile SingularAttribute<Pet, Long> id_pet;
    public static volatile SingularAttribute<Pet, Cliente> cliente;
    public static volatile SingularAttribute<Pet, String> obs;
    public static volatile SingularAttribute<Pet, TamanhoEnum> tamanho;
    public static volatile SingularAttribute<Pet, String> nome;
    public static volatile SingularAttribute<Pet, GeneroEnum> sexo;

}