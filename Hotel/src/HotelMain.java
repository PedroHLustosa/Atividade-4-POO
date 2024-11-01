import java.util.Scanner;

public class HotelMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha o tipo de acomodação:\n1. Quarto Simples\n2. Quarto Duplo\n3. Suíte\n4. Sair");
            int opcao = scanner.nextInt();

            if (opcao == 4) {
                System.out.println("Encerrando o sistema.");
                continuar = false;
                break;
            }

            System.out.print("Informe a quantidade de dias: ");
            int dias = scanner.nextInt();

            System.out.print("Informe a quantidade de pessoas: ");
            int numPessoas = scanner.nextInt();

            System.out.print("Deseja incluir café da manhã? (1 para Sim, 0 para Não): ");
            boolean cafeDaManha = scanner.nextInt() == 1;

            System.out.print("Deseja incluir limpeza extra? (1 para Sim, 0 para Não): ");
            boolean limpezaExtra = scanner.nextInt() == 1;

            Acomodacao acomodacao;
            switch (opcao) {
                case 1 -> acomodacao = new QuartoSimples();
                case 2 -> acomodacao = new QuartoDuplo();
                case 3 -> acomodacao = new Suite();
                default -> {
                    System.out.println("Opção inválida.");
                    continue;
                }
            }

            double custoServico = ((ServicoAdicional) acomodacao).calcularServico(numPessoas, dias, cafeDaManha, limpezaExtra);
            acomodacao.exibirDetalhes(dias, custoServico);
        }

        scanner.close();
    }
}

// Interface Acomodacao
interface Acomodacao {
    double calcularDiaria();
    void exibirDetalhes(int dias, double custoServico);
}

// Interface ServicoAdicional
interface ServicoAdicional {
    double calcularServico(int numPessoas, int dias, boolean cafeDaManha, boolean limpezaExtra);
}
