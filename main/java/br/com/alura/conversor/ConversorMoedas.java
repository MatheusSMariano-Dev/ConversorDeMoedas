package br.com.alura.conversor;

public class ConversorMoedas {

    private final ApiClient apiClient = new ApiClient();

    public double converter(int opcao, double valor) {

        return switch (opcao) {
            case 1 -> valor * apiClient.getTaxa("USD", "BRL");
            case 2 -> valor * apiClient.getTaxa("BRL", "USD");
            case 3 -> valor * apiClient.getTaxa("EUR", "BRL");
            case 4 -> valor * apiClient.getTaxa("BRL", "EUR");
            case 5 -> valor * apiClient.getTaxa("USD", "EUR");
            case 6 -> valor * apiClient.getTaxa("EUR", "USD");
            default -> {
                System.out.println("Opção inválida!");
                yield -1;
            }
        };
    }
}
