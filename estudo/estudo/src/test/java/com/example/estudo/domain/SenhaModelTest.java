package com.example.estudo.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SenhaModelTest {

    @Test
    void deveLancarErroQuandoSenhaMenorQueNoveCaracteres() {
        String senhaCurta = "Ab1!cd";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new SenhaModel(senhaCurta)
        );
        assertEquals("A senha deve ter pelo menos 9 caracteres.", exception.getMessage());
    }

    @Test
    void deveLancarErroQuandoSenhaSemDigito() {
        String senha = "Abcdef!@#";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new SenhaModel(senha)
        );
        assertEquals("A senha deve conter pelo menos 1 dígito.", exception.getMessage());
    }

    @Test
    void deveCriarSenhaValida() {
        String senhaValida = "AbTp9!fok";
        assertDoesNotThrow(() -> new SenhaModel(senhaValida));
    }

    @Test
    void deveLancarErroQuandoSenhaSemEspacoPermitido() {
        String senhaComEspaco = "AbTp9 foK";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new SenhaModel(senhaComEspaco)
        );
        assertEquals("Não pode conter espaços em brancos", exception.getMessage());
    }
}

