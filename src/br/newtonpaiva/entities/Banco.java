package br.newtonpaiva.entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;

    private List<Conta> contas = new ArrayList<>();

    public Banco(){

    }

    public Banco(String nome, List<Conta> contas) {
        this.nome = nome;
        this.contas = contas;
    }

    public double calcularSaldoTotal() {
        double saldoTotal = 0.0;

        for (Conta conta : contas) {
            saldoTotal += conta.getSaldo();
        }

        return saldoTotal;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
