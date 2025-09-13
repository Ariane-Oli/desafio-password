package com.example.estudo.usecase;

import com.example.estudo.domain.SenhaModel;
import com.example.estudo.ports.input.ValidarSenhaUseCase;
import org.springframework.stereotype.Service;

@Service
public class ValidarSenhaUseCaseImpl implements ValidarSenhaUseCase {


    @Override
    public boolean isValid(String senha){
        try {
            new SenhaModel(senha);
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

}
