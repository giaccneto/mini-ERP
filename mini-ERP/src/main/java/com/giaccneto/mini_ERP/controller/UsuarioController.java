package com.giaccneto.mini_ERP.controller;

import com.giaccneto.mini_ERP.entity.Medicamento;
import com.giaccneto.mini_ERP.entity.Usuario;
import com.giaccneto.mini_ERP.service.MedicamentoService;
import com.giaccneto.mini_ERP.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    public UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.criarUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.buscarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Usuario> buscarPorNome(@RequestParam String nomeUsuario) {
        return ResponseEntity.ok(usuarioService.buscaUsuarioPorNome(nomeUsuario));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePorNome(@RequestParam String nomeUsuario) {
        usuarioService.deletePorNome(nomeUsuario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(
            @PathVariable Long id,
            @RequestBody Usuario usuario) {

        Optional<Usuario> usuarioAtualizado =
                usuarioService.atualizarUsuario(id, usuario);

        return usuarioAtualizado
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
