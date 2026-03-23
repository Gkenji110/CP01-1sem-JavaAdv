package br.com.fiap.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("JUNIOR")
public class FuncionarioJunior extends Funcionario {

    private double bonus;

    public FuncionarioJunior() {
    }

    public FuncionarioJunior(String nome, double horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    public FuncionarioJunior(String nome, double horasTrabalhadas, double valorPorHora, String cargo) {
        super(nome, horasTrabalhadas, valorPorHora, cargo);
    }

    public FuncionarioJunior(String nome, double horasTrabalhadas, double valorPorHora, String cargo, double bonus) {
        super(nome, horasTrabalhadas, valorPorHora, cargo);
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario() {
        double salarioBase = super.calcularSalario();
        int quantidadeBonus = (int) (getHorasTrabalhadas() / 45);
        return salarioBase + (quantidadeBonus * bonus);
    }

    @Override
    public void imprimirInformacao() {
        System.out.println("Informações do funcionário júnior");
        System.out.println("Nome:                   " + getNome());
        System.out.println("Cargo:                  " + getCargo());
        System.out.println("Horas trabalhadas:      " + getHorasTrabalhadas() + "h");
        System.out.println("Valor por hora:         R$ " + String.format("%.2f", getValorPorHora()));
        System.out.println("Bônus por 45 horas:     R$ " + String.format("%.2f", bonus));
        int quantidadeBonus = (int) (getHorasTrabalhadas() / 45);
        System.out.println("Quantidade de Bônus:    " + quantidadeBonus + "x");
        System.out.println("===========================");
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
