package br.newtonpaiva.ui;

import br.newtonpaiva.entities.Arquivos;
import br.newtonpaiva.entities.Banco;
import br.newtonpaiva.entities.Cliente;
import br.newtonpaiva.entities.Conta;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Conta> listaContas = new ArrayList<>();

        String nomeCliente = JOptionPane.showInputDialog("Nome do cliente: ");
        Cliente cliente = new Cliente(nomeCliente);

        String path = "C://Users//Arthur Coutinho//IdeaProjects//arquivoComplementar";
        List<String> linhasArquivo = Arquivos.leitor(path);

        for (String linha : linhasArquivo) {
            String[] dados = linha.split(",");
            String agencia = dados[0];
            String numero = dados[1];
            double saldo = Double.parseDouble(dados[2]);

            Conta conta = new Conta(agencia, numero, saldo);
            listaContas.add(conta);
        }

        Banco banco = new Banco();
        banco.setNome(JOptionPane.showInputDialog("Nome do banco: "));
        banco.setContas(listaContas);

        double saldoTotal = banco.calcularSaldoTotal();
        String mensagem = "Banco " + banco.getNome() + " possui o saldo geral de contas de: " + saldoTotal;

        Arquivos.escritor("C://Users//Arthur Coutinho//IdeaProjects//saldoGeral");
    }
}
