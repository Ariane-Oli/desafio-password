package com.example.estudo.adapters.input;

import com.example.estudo.ports.input.ValidarSenhaUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/senha")
public class SenhaController {

    private final ValidarSenhaUseCase validarSenhaUseCase;

    public SenhaController(ValidarSenhaUseCase validarSenhaUseCase){
        this.validarSenhaUseCase = validarSenhaUseCase;
    }

    @PostMapping("/validar")
    public boolean validarSenha(@RequestBody SenhaDTO dto){
        return validarSenhaUseCase.isValid(dto.getSenha());
    }
}
