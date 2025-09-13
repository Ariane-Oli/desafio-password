package com.example.estudo.domain;

import java.util.HashSet;
import java.util.Set;

public class SenhaModel {

    private String senha;

    public SenhaModel(String senha) {
        validarTamanho(senha);
        validarDigito(senha);
        validarMinuscula(senha);
        validarMaiuscula(senha);
        validarCaratereEspecial(senha);
        validarRepeticaoEspecial(senha);
        validarEspacos(senha);

        this.senha = senha;
    }


    private void validarTamanho(String senha){
        if (senha.length() < 9) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 9 caracteres.");
        }

    }
    private void validarDigito(String senha){
        if (!senha.matches(".*\\d.*")) {
            throw new IllegalArgumentException("A senha deve conter pelo menos 1 dígito.");
        }

    }
    private void validarMinuscula(String senha){
        if (!senha.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("A senha deve conter ao menos 1 letra minúscula.");
        }

    }
    private void validarMaiuscula(String senha){
        if (!senha.matches(".*[A-Z].*")){
            throw new IllegalArgumentException("A senha deve ter no mínimo 1 letra maiúscula.");
        }

    }
    private void validarCaratereEspecial(String senha){
        if (!senha.matches(".*[!@#$%^&*()\\-+].*")){
            throw new IllegalArgumentException("Não pode conter espaços em brancos");
        }

    }
    private void validarRepeticaoEspecial(String senha){
        String especiais = "!@#$%^&*()-+";
        Set<Character> vistos = new HashSet<>();

        for (char c : senha.toCharArray()){
            if (especiais.indexOf(c) >= 0) {
                if (!vistos.add(c)) {
                    throw new IllegalArgumentException("Não pode conter espaços em brancos");
                }

            }
        }
    }
    private void validarEspacos(String senha){
                if (senha.matches(".*\\s.*")){
                    throw new IllegalArgumentException("Não pode conter espaços em brancos");
                }

    }

    public String getSenha() {
        return senha;
    }


}


