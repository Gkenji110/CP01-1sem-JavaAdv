package br.com.fiap.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PLENO")
public class FuncionarioPleno extends Funcionario{

    public FuncionarioPleno() {

    }

    public FuncionarioPleno(String nome, double horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }
}
