package com.giaccneto.mini_ERP.repository;

import com.giaccneto.mini_ERP.entity.Medicamento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    Optional<Medicamento> findByNomeMedicamento(String nomeMedicamento);

    @Transactional
    void deleteByNomeMedicamento(String nomeMedicamento);
}
