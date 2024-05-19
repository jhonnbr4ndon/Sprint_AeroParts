package br.com.aeroparts.strategies.usuario;

import br.com.aeroparts.entity.Usuario;

import java.util.List;

public interface UsuarioStrategy {

    List<Usuario> organizar(List<Usuario> usuarios);

}
