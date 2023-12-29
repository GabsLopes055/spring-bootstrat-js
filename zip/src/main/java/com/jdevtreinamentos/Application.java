package com.jdevtreinamentos;

import com.jdevtreinamentos.model.Usuario;
import com.jdevtreinamentos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Autowired
    private UsuarioRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner initialUser() {
        return args -> {
            Usuario user = new Usuario();
            user.setNome("Gabriel Lopes Teixeira");
            user.setIdade(25);
            repository.save(user);
        };
    }


}
