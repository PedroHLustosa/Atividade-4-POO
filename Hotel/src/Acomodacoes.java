// Classe abstrata AcomodacaoBase
abstract class AcomodacaoBase implements Acomodacao, ServicoAdicional {
    protected double diaria;

    public AcomodacaoBase(double diaria) {
        this.diaria = diaria;
    }

    @Override
    public double calcularDiaria() {
        return diaria;
    }

    @Override
    public void exibirDetalhes(int dias, double custoServico) {
        double custoTotal = (calcularDiaria() * dias) + custoServico;
        System.out.printf("%s - Diária: R$%.2f, Custo Total para %d dias (incluindo serviços): R$%.2f%n", 
                this.getClass().getSimpleName(), diaria, dias, custoTotal);
    }

    @Override
    public double calcularServico(int numPessoas, int dias, boolean cafeDaManha, boolean limpezaExtra) {
        double custo = 0;
        if (cafeDaManha) {
            custo += 20 * numPessoas * dias;
        }
        if (limpezaExtra) {
            custo += 30 * dias;
        }
        return custo;
    }
}

// Classe QuartoSimples
class QuartoSimples extends AcomodacaoBase {
    public QuartoSimples() {
        super(100);
    }
}

// Classe QuartoDuplo
class QuartoDuplo extends AcomodacaoBase {
    public QuartoDuplo() {
        super(180);
    }
}

// Classe Suite
class Suite extends AcomodacaoBase {
    public Suite() {
        super(350);
    }
}
