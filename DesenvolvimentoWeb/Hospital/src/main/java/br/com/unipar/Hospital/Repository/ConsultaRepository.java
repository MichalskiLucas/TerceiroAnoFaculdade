package br.com.unipar.Hospital.Repository;

import br.com.unipar.Hospital.Model.Consulta;
import br.com.unipar.Hospital.Model.Medico;
import br.com.unipar.Hospital.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query
    List<Consulta> findConsultaByPacienteAndDataHora(Paciente paciente, Date date);

    @Query
    List<Consulta> findConsultaByMedicoAndAndDataHora(Medico medico, Date date);

}
