package br.com.unipar.Hospital.Repository;

import br.com.unipar.Hospital.Model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query
    List<Medico> findAllByOrderByNome();

    @Query("select m from Medico m where m.ativo = true and m.id not in (select c.medico.id from Consulta c where c.dataHora = :data)")
    List<Medico> findMedicosSemConsultaParaData(@Param("data") Date data);
}
