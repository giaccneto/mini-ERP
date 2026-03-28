package com.giaccneto.mini_ERP.controller;

import com.giaccneto.mini_ERP.entity.Medicamento;
import com.giaccneto.mini_ERP.service.MedicamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    public MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping
    public ResponseEntity<Medicamento> criarMedicamento(@RequestBody Medicamento medicamento){
        return ResponseEntity.ok(medicamentoService.criarMedicamento(medicamento));
    }

    @GetMapping
    public  ResponseEntity<List<Medicamento>> listarMedicamentos(){
        List<Medicamento> medicamentos = medicamentoService.buscarMedicamentos();
        return ResponseEntity.ok(medicamentos);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Medicamento> buscarPorNome(@RequestParam String nomeMedicamento){
        return ResponseEntity.ok(medicamentoService.buscaMedicamentoPorNome(nomeMedicamento));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePorNome(@RequestParam String nomeMedicamento){
        medicamentoService.deletePorNome(nomeMedicamento);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> atualizarMedicamento(
            @PathVariable Long id,
            @RequestBody Medicamento medicamentoAtualizado) {

        return medicamentoService.atualizarMedicamento(id, medicamentoAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
