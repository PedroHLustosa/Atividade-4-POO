
public abstract class ContaBancaria {
    protected String cliente;
    protected String numeroConta;
    protected double saldo;

    public ContaBancaria(String cliente, String numeroConta, double saldoInicial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public abstract boolean sacar(double valor);

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado. Novo saldo: " + saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getDadosConta() {
        return "Cliente: " + cliente + "\nNúmero da Conta: " + numeroConta + "\nSaldo: " + saldo;
    }
}

