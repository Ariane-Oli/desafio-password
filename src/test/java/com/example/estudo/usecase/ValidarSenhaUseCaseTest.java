package com.example.estudo.usecase;


import com.example.estudo.ports.input.ValidarSenhaUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidarSenhaUseCaseTest {

    private final ValidarSenhaUseCase useCase = new ValidarSenhaUseCaseImpl();

    @Test
    void deveRetornarTrueParaSenhaValida() {
        assertTrue(useCase.isValid("AbTp9!fok"));
    }

    @Test
    void deveRetornarFalseParaSenhaComEspaco() {
        assertFalse(useCase.isValid("AbTp9 fok"));
    }

    @Test
    void deveRetornarFalseParaSenhaSemDigito() {
        assertFalse(useCase.isValid("AbTp!fokl"));
    }

    // Continue adicionando testes para cada regra
}

