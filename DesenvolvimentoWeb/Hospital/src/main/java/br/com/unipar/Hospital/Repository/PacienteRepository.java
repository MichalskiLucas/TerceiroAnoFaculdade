package br.com.unipar.Hospital.Repository;

import br.com.unipar.Hospital.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    @Query
    List<Paciente> findAllByOrderByNome();
}
