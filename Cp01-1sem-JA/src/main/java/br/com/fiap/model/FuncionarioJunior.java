package br.com.fiap.model;


import br.com.fiap.annotation.Descricao;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("JUNIOR")
public class FuncionarioJunior extends Funcionario {

    public FuncionarioJunior() {
    }

    public FuncionarioJunior(String nome, double horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }
}
