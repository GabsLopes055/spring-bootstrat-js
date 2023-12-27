package com.jdevtreinamentos.Controllers;

import com.jdevtreinamentos.model.Usuario;
import com.jdevtreinamentos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class newController {

    @Autowired
    UsuarioRepository repository;

    @GetMapping(value = "{name}")
    public ResponseEntity<String> newController(@PathVariable String name) {

        Usuario usuario = new Usuario(name, 10);

        repository.save(usuario);

        return ResponseEntity.status(HttpStatus.OK).body("Projeto Criado por: " + usuario.toString());
    }

    @GetMapping(value = "listarTodosUsuarios")
    public ResponseEntity<List<Usuario>> listarTodosUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @PostMapping(value = "salvar")
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
    }

    @DeleteMapping(value = "deletar")
    public ResponseEntity<String> deletar(@RequestParam Long idUser) {
        repository.deleteById(idUser);

        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");

    }

    @GetMapping(value = "listarUsuarioId")
    public ResponseEntity<Usuario> buscarUsuarioId(@RequestParam Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get());

    }

}
