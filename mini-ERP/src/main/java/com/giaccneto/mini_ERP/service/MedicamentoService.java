package com.giaccneto.mini_ERP.service;

import com.giaccneto.mini_ERP.entity.Medicamento;
import com.giaccneto.mini_ERP.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {


    public MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public Medicamento criarMedicamento(Medicamento medicamento) {

        return medicamentoRepository.save(medicamento);
    }

    public List<Medicamento> buscarMedicamentos() {
        return medicamentoRepository.findAll();
    }

    public Medicamento buscaMedicamentoPorNome(String nomeMedicamento) {
        try {
            return medicamentoRepository.findByNomeMedicamento(nomeMedicamento).orElseThrow(
                    () -> new RuntimeException("Medicamento não encontrado" + nomeMedicamento));

        } catch (RuntimeException e) {
            throw new RuntimeException("Medicamento não encontrado " + e);
        }
    }

    public void deletePorNome(String nomeMedicamento) {
        medicamentoRepository.deleteByNomeMedicamento(nomeMedicamento);

    }

    public Optional<Medicamento> atualizarMedicamento(Long id, Medicamento medicamentoAtualizado) {

        return medicamentoRepository.findById(id)
                .map(medicamento -> {

                    medicamento.setNomeMedicamento(medicamentoAtualizado.getNomeMedicamento());
                    medicamento.setLaboratorio(medicamentoAtualizado.getLaboratorio());
                    medicamento.setDescricaoMedicamento(medicamentoAtualizado.getDescricaoMedicamento());
                    medicamento.setQuantidadeEstoque(medicamentoAtualizado.getQuantidadeEstoque());
                    medicamento.setPreco(medicamentoAtualizado.getPreco());
                    medicamento.setDataValidade(medicamentoAtualizado.getDataValidade());

                    return medicamentoRepository.save(medicamento);
                });
    }
}
