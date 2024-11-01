
public class ContaEspecial extends ContaBancaria {
    private double limite;

    public ContaEspecial(String cliente, String numeroConta, double saldoInicial, double limite) {
        super(cliente, numeroConta, saldoInicial);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo + limite) {
            saldo -= valor;
            System.out.println("Saque realizado. Novo saldo: " + saldo);
            return true;
        } else {
            System.out.println("Saldo e limite insuficientes para saque.");
            return false;
        }
    }
}
