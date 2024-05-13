package br.com.residenciatic18.avaliacao.api.ap002.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.residenciatic18.avaliacao.api.ap002.web.controller.PasswordRecoveryController;

@WebMvcTest(PasswordRecoveryController.class)
public class PasswordResetControllerTest {
  
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
}
