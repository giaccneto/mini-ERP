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

    public Medicamento criarMedicamento(Medicamento medicamento){

        return medicamentoRepository.save(medicamento);
    }

    public List<Medicamento> buscarMedicamentos(){
        return medicamentoRepository.findAll();
    }

    public Medicamento buscaMedicamentoPorNome(String nomeMedicamento){
        try{
            return medicamentoRepository.findByNomeMedicamento(nomeMedicamento).orElseThrow(
                    ()-> new RuntimeException("Medicamento não encontrado" + nomeMedicamento));

        } catch (RuntimeException e) {
            throw new RuntimeException("Medicamento não encontrado " + e);
        }
    }

    public void deletePorNome(String nomeMedicamento){
        medicamentoRepository.deleteByNomeMedicamento(nomeMedicamento);

    }

    public Optional<Medicamento> atualizarMedicamento(Long id, Medicamento dadosAtualizados) {

        Optional<Medicamento> medicamentoExistente = medicamentoRepository.findById(id);

        if (medicamentoExistente.isPresent()) {
            Medicamento med = medicamentoExistente.get();

            med.setNomeMedicamento(dadosAtualizados.getNomeMedicamento());
            med.setLaboratorio(dadosAtualizados.getLaboratorio());
            med.setDescricaoMedicamento(dadosAtualizados.getDescricaoMedicamento());
            med.setQuantidadeEstoque(dadosAtualizados.getQuantidadeEstoque());
            med.setPreco(dadosAtualizados.getPreco());
            med.setDataValidade(dadosAtualizados.getDataValidade());

            return Optional.of(medicamentoRepository.save(med));
        }

        return Optional.empty();
    }
}
