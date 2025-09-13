package com.example.estudo.adapters.input;

import com.example.estudo.ports.input.ValidarSenhaUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SenhaControllerTest {

    private MockMvc mockMvc;
    private ValidarSenhaUseCase validarSenhaUseCase;

    @BeforeEach
    void setUp() {
        validarSenhaUseCase = Mockito.mock(ValidarSenhaUseCase.class);
        SenhaController controller = new SenhaController(validarSenhaUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void deveRetornarTrueQuandoSenhaValida() throws Exception {
        String senha = "AbTp9!fok";

        when(validarSenhaUseCase.isValid(senha)).thenReturn(true);

        mockMvc.perform(post("/senha/validar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"senha\":\"AbTp9!fok\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void deveRetornarFalseQuandoSenhaInvalida() throws Exception {
        String senha = "123";

        when(validarSenhaUseCase.isValid(senha)).thenReturn(false);

        mockMvc.perform(post("/senha/validar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"senha\":\"123\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }
}
