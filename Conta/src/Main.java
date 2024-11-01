import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

		public class Main {
		    private static List<ContaBancaria> contas = new ArrayList<>();

		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        boolean sair = false;

		        while (!sair) {
		            System.out.println("\nEscolha uma operação:\n1. Criar Conta\n2. Sacar\n3. Depositar\n4. Calcular Rendimento (Conta Poupança)\n5. Mostrar Dados da Conta\n6. Sair");
		            int opcao = scanner.nextInt();

		            switch (opcao) {
		                case 1:
		                    criarConta(scanner);
		                    break;
		                case 2:
		                    sacar(scanner);
		                    break;
		                case 3:
		                    depositar(scanner);
		                    break;
		                case 4:
		                    calcularRendimento(scanner);
		                    break;
		                case 5:
		                    mostrarDadosConta(scanner);
		                    break;
		                case 6:
		                    sair = true;
		                    System.out.println("Saindo...");
		                    break;
		                default:
		                    System.out.println("Opção inválida.");
		            }
		        }
		        scanner.close();
		    }

		    private static void criarConta(Scanner scanner) {
		        System.out.print("Informe o nome do cliente: ");
		        scanner.nextLine();
		        String cliente = scanner.nextLine();
		        System.out.print("Informe o número da conta: ");
		        String numeroConta = scanner.nextLine();
		        System.out.print("Informe o saldo inicial: ");
		        double saldoInicial = scanner.nextDouble();

		        System.out.print("Tipo de conta (1- Poupança, 2- Especial): ");
		        int tipoConta = scanner.nextInt();

		        if (tipoConta == 1) {
		            System.out.print("Informe o dia de rendimento: ");
		            int diaRendimento = scanner.nextInt();
		            contas.add(new ContaPoupanca(cliente, numeroConta, saldoInicial, diaRendimento));
		            System.out.println("Conta Poupança criada com sucesso.");
		        } else if (tipoConta == 2) {
		            System.out.print("Informe o limite da conta especial: ");
		            double limite = scanner.nextDouble();
		            contas.add(new ContaEspecial(cliente, numeroConta, saldoInicial, limite));
		            System.out.println("Conta Especial criada com sucesso.");
		        } else {
		            System.out.println("Tipo de conta inválido.");
		        }
		    }

		    private static void sacar(Scanner scanner) {
		        ContaBancaria conta = buscarConta(scanner);
		        if (conta != null) {
		            System.out.print("Informe o valor do saque: ");
		            double valor = scanner.nextDouble();
		            conta.sacar(valor);
		        }
		    }

		    private static void depositar(Scanner scanner) {
		        ContaBancaria conta = buscarConta(scanner);
		        if (conta != null) {
		            System.out.print("Informe o valor do depósito: ");
		            double valor = scanner.nextDouble();
		            conta.depositar(valor);
		        }
		    }

		    private static void calcularRendimento(Scanner scanner) {
		        ContaBancaria conta = buscarConta(scanner);
		        if (conta instanceof ContaPoupanca) {
		            System.out.print("Informe a taxa de rendimento: ");
		            double taxaRendimento = scanner.nextDouble();
		            ((ContaPoupanca) conta).calcularNovoSaldo(taxaRendimento);
		        } else {
		            System.out.println("A conta selecionada não é uma Conta Poupança.");
		        }
		    }

		    private static void mostrarDadosConta(Scanner scanner) {
		        ContaBancaria conta = buscarConta(scanner);
		        if (conta != null) {
		            System.out.println(conta.getDadosConta());
		        }
		    }

		    private static ContaBancaria buscarConta(Scanner scanner) {
		        System.out.print("Informe o número da conta: ");
		        scanner.nextLine();
		        String numeroConta = scanner.nextLine();

		        for (ContaBancaria conta : contas) {
		            if (conta.numeroConta.equals(numeroConta)) {
		                return conta;
		            }
		        }
		        System.out.println("Conta não encontrada.");
		        return null;
		    }
		}
