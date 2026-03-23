package br.com.fiap.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SENIOR")
public class FuncionarioSenior extends Funcionario {

    private double bonus;

    public FuncionarioSenior() {}

    public FuncionarioSenior(String nome, double horasTrabalhadas, double valorPorHoras, String cargo) {
        super(nome, horasTrabalhadas, valorPorHoras, cargo);
    }

    public FuncionarioSenior(String nome, double horasTrabalhadas, double valorPorHoras, String cargo, double bonus) {
        super(nome, horasTrabalhadas, valorPorHoras, cargo);
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario() {
        double salarioBase = super.calcularSalario();
        int quantidadeBonus = (int) (getHorasTrabalhadas() / 15);
        return salarioBase + (quantidadeBonus * bonus);
    }

    @Override
    public void imprimirInformacao() {
        System.out.println("Informações do funcionário sênior");
        System.out.println("Nome:                   " + getNome());
        System.out.println("Cargo:                  " + getCargo());
        System.out.println("Horas trabalhadas:      " + getHorasTrabalhadas() + "h");
        System.out.println("Valor por hora:         R$ " + String.format("%.2f", getValorPorHora()));
        System.out.println("Bônus por 15 horas:     R$ " + String.format("%.2f", bonus));
        int quantidadeBonus = (int) (getHorasTrabalhadas() / 15);
        System.out.println("Quantidade de Bônus:       " + quantidadeBonus + "x");
        System.out.println("===========================");
    }

    public double getBonus() {return bonus;}
    public void setBonus(double bonus) {this.bonus = bonus;}
}
