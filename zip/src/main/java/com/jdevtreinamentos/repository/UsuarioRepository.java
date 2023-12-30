package com.jdevtreinamentos.repository;

import com.jdevtreinamentos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM USUARIO WHERE upper(trim(NOME)) LIKE %:nome%", nativeQuery = true)
    List<Usuario> buscarPorNome(String nome);

    List<Usuario> findAllByOrderByIdDesc();

}
