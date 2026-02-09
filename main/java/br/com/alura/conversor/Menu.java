package br.com.alura.conversor;

import java.util.Scanner;

public class Menu {

    public void exibir() {
        Scanner scanner = new Scanner(System.in);
        ConversorMoedas conversor = new ConversorMoedas();

        int opcao;

        do {
            System.out.println("""
                    
                    ===============================
                    CONVERSOR DE MOEDAS
                    ===============================
                    1 - USD → BRL
                    2 - BRL → USD
                    3 - EUR → BRL
                    4 - BRL → EUR
                    5 - USD → EUR
                    6 - EUR → USD
                    0 - Sair
                    """);

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Programa finalizado.");
                break;
            }

            System.out.print("Digite o valor para conversão: ");
            double valor = scanner.nextDouble();

            double resultado = conversor.converter(opcao, valor);

            if (resultado != -1) {
                System.out.printf("Valor convertido: %.2f%n", resultado);
            }

        } while (opcao != 0);

        scanner.close();
    }
}
