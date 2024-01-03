package com.jdevtreinamentos.Controllers;

import com.jdevtreinamentos.model.Usuario;
import com.jdevtreinamentos.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api")
public class newController {


    private UsuarioRepository repository;

    newController(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
    }

    @GetMapping(value = "listarTodosUsuarios")
    public ResponseEntity<List<Usuario>> listarTodosUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByOrderByIdDesc());
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

        Optional<Usuario> user = repository.findById(id);

        return user.map(usuario -> ResponseEntity.status(HttpStatus.OK).body(usuario)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @PutMapping(value = "atualizar")
    public ResponseEntity<?> atualizar(@RequestBody Usuario usuario) {

        if (usuario.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID não informado !");
        } else {
        return ResponseEntity.status(HttpStatus.OK).body(repository.saveAndFlush(usuario));
        }

    }

    @GetMapping(value = "buscarPorNome")
    public ResponseEntity<List<Usuario>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.buscarPorNome(nome.trim().toUpperCase()));
    }

}
