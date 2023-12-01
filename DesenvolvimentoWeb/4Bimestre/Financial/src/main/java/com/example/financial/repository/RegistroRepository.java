package com.example.financial.repository;

import com.example.financial.enums.TipoRegistroENUM;
import com.example.financial.domain.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface RegistroRepository extends JpaRepository<Registro, Long> {

    @Query
    public List<Registro> findByTipoRegistroENUM(TipoRegistroENUM tipoRegistroENUM);
}
