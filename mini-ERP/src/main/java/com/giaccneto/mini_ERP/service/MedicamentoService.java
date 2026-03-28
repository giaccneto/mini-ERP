package com.giaccneto.mini_ERP.service;

import com.giaccneto.mini_ERP.entity.Medicamento;
import com.giaccneto.mini_ERP.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
