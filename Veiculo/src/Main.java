import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Veiculo> frota = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\nEscolha uma opção:\n1. Adicionar Veículo\n2. Exibir Detalhes de Veículos\n3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarVeiculo(scanner, frota);
                    break;
                case 2:
                    exibirDetalhesFrota(frota);
                    break;
                case 3:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    private static void adicionarVeiculo(Scanner scanner, List<Veiculo> frota) {
        System.out.print("Informe a placa: ");
        String placa = scanner.nextLine();
        System.out.print("Informe a marca: ");
        String marca = scanner.nextLine();
        System.out.print("Informe o modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Informe o ano de fabricação: ");
        int anoFabricacao = scanner.nextInt();

        System.out.print("Tipo de veículo (1- Carro, 2- Caminhão, 3- Ônibus): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        switch (tipo) {
            case 1:
                frota.add(new Carro(placa, marca, modelo, anoFabricacao));
                System.out.println("Carro adicionado à frota.");
                break;
            case 2:
                frota.add(new Caminhao(placa, marca, modelo, anoFabricacao));
                System.out.println("Caminhão adicionado à frota.");
                break;
            case 3:
                frota.add(new Onibus(placa, marca, modelo, anoFabricacao));
                System.out.println("Ônibus adicionado à frota.");
                break;
            default:
                System.out.println("Tipo de veículo inválido.");
        }
    }

    private static void exibirDetalhesFrota(List<Veiculo> frota) {
        if (frota.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
            for (Veiculo veiculo : frota) {
                veiculo.exibirDetalhes();
                System.out.println("------------------------------");
            }
        }
    }
}
