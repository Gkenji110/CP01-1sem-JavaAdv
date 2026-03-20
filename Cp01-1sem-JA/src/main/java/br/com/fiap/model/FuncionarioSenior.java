package br.com.fiap.model;

public class FuncionarioSenior extends Funcionario {

    private double bonus;

    public FuncionarioSenior() {}

    public FuncionarioSenior(String nome, double horasTrabalhadas, double valorPorHoras, double bonus) {
        super(nome, horasTrabalhadas, valorPorHoras);
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
        System.out.println("Horas trabalhadas:      " + getHorasTrabalhadas() + "h");
        System.out.println("Valor por hora:         R$ " + String.format("%.2f", getValorPorHora()));
        System.out.println("Bônus por 15 horas:     R$ " + String.format("%.2f", bonus));
        int quantidadeBonus = (int) (getHorasTrabalhadas() / 15);
        System.out.println("Quantidade de Bônus:       " + quantidadeBonus + "x");
        System.out.println("Salário final:          R$ " + String.format("%.2f", calcularSalario()));
        System.out.println("===========================");
    }

    public double getBonus() {return bonus;}
    public void setBonus(double bonus) {this.bonus = bonus;}
}
