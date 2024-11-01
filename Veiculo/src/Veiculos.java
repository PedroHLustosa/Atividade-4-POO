
abstract class Veiculo {
    protected String placa;
    protected String marca;
    protected String modelo;
    protected int anoFabricacao;

    public Veiculo(String placa, String marca, String modelo, int anoFabricacao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    public abstract double calcularIPVA();

    public abstract double calcularValorEstimado();

    public void exibirDetalhes() {
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano de Fabricação: " + anoFabricacao);
        System.out.println("Valor Estimado: R$" + calcularValorEstimado());
        System.out.println("IPVA: R$" + calcularIPVA());
    }
}

class Carro extends Veiculo {
    private static final double TAXA_IPVA = 0.04;
    private static final int DESVALORIZACAO_ANUAL = 2000;

    public Carro(String placa, String marca, String modelo, int anoFabricacao) {
        super(placa, marca, modelo, anoFabricacao);
    }

    @Override
    public double calcularValorEstimado() {
        int anosDeUso = 2024 - anoFabricacao;
        return Math.max(0, 50000 - (anosDeUso * DESVALORIZACAO_ANUAL));
    }

    @Override
    public double calcularIPVA() {
        return calcularValorEstimado() * TAXA_IPVA;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Tipo de Veículo: Carro");
        super.exibirDetalhes();
    }
}

class Caminhao extends Veiculo {
    private static final double TAXA_IPVA = 0.015;
    private static final int DESVALORIZACAO_ANUAL = 5000;

    public Caminhao(String placa, String marca, String modelo, int anoFabricacao) {
        super(placa, marca, modelo, anoFabricacao);
    }

    @Override
    public double calcularValorEstimado() {
        int anosDeUso = 2024 - anoFabricacao;
        return Math.max(0, 120000 - (anosDeUso * DESVALORIZACAO_ANUAL));
    }

    @Override
    public double calcularIPVA() {
        return calcularValorEstimado() * TAXA_IPVA;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Tipo de Veículo: Caminhão");
        super.exibirDetalhes();
    }
}

class Onibus extends Veiculo {
    private static final double TAXA_IPVA = 0.02;
    private static final int DESVALORIZACAO_ANUAL = 3000;

    public Onibus(String placa, String marca, String modelo, int anoFabricacao) {
        super(placa, marca, modelo, anoFabricacao);
    }

    @Override
    public double calcularValorEstimado() {
        int anosDeUso = 2024 - anoFabricacao;
        return Math.max(0, 80000 - (anosDeUso * DESVALORIZACAO_ANUAL));
    }

    @Override
    public double calcularIPVA() {
        return calcularValorEstimado() * TAXA_IPVA;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Tipo de Veículo: Ônibus");
        super.exibirDetalhes();
    }
}
