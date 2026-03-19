package br.com.fiap.model;


import br.com.fiap.annotations.Coluna;
import br.com.fiap.annotations.Descricao;
import jakarta.persistence.Entity;
import br.com.fiap.annotations.Tabela;



@Entity
@Tabela(nome = "TB_FUNCIONARIO")
@Descricao(descricao = "Tabela de funcinários da empresa")
public class Funcionario {

    @Coluna(nome = "NM_FUNCIONARIO", obrigatorio = true, tamanho = 100)
    private String nome;

    @Coluna(nome = "NR_HORAS_TRABALHADAS", obrigatorio = true)
    private double horasTrabalhadas;

    @Coluna(nome = "VL_HORA", obrigatorio = true)
    private double valorPorHora;

    public Funcionario(String nome, double horasTrabalhadas, double valorPorHoras) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHoras;
    }

    public double calcularSalario() {
        return horasTrabalhadas * valorPorHora;
    }

    public void imprimirInformacao() {
        System.out.println("Informações do funcionário");
        System.out.println("Nome:                   " + nome);
        System.out.println("Horas trabalhadas:      " + horasTrabalhadas + "h");
        System.out.println("Valor por hora:         R$ " + String.format("%.2f", valorPorHora));
        System.out.println("Salário final:          R$ " + String.format("%.2f", calcularSalario()));
        System.out.println("===========================");
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public double getHorasTrabalhadas() {return horasTrabalhadas;}
    public void setHorasTrabalhadas(double horasTrabalhadas) {this.horasTrabalhadas = horasTrabalhadas;}

    public double getValorPorHora() {return valorPorHora;}
    public void setValorPorHora(double valorPorHora) {this.valorPorHora = valorPorHora;}

}
