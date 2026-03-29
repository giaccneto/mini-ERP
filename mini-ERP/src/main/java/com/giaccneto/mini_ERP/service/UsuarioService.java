package com.giaccneto.mini_ERP.service;

import com.giaccneto.mini_ERP.entity.Usuario;
import com.giaccneto.mini_ERP.repository.UsuarioRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> buscarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscaUsuarioPorNome(String nomeUsuario) {
        return usuarioRepository.findByNome(nomeUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + nomeUsuario));
    }


    @Transactional
    public void deletePorNome(String nomeUsuario) {
        usuarioRepository.deleteByNome(nomeUsuario);

    }

    public Optional<Usuario> atualizarUsuario(Long id, Usuario usuarioAtualizado) {

        return usuarioRepository.findById(id)
                .map(usuario -> {

                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setEmail(usuarioAtualizado.getEmail());
                    usuario.setSenha(usuarioAtualizado.getSenha());

                    return usuarioRepository.save(usuario);
                });
    }
}

