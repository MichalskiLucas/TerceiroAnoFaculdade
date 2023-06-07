package br.com.unipar.Hospital.Repository;

import br.com.unipar.Hospital.Model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query
    List<Medico> findAllByOrderByNome();
}
