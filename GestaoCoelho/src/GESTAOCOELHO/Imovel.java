package GESTAOCOELHO;

public class Imovel {
    private String endereco;
    private double ultimaLeitura;
    private double penultimaLeitura;
    private Fatura fatura;  // Adiciona um objeto Fatura

    public Imovel(String endereco, double ultimaLeitura, double penultimaLeitura) {
        this.endereco = endereco;
        this.ultimaLeitura = ultimaLeitura;
        this.penultimaLeitura = penultimaLeitura;
        this.fatura = null;  // Inicializa a fatura como nula
    }

    public String getEndereco() {
        return endereco;
    }

    public double getUltimaLeitura() {
        return ultimaLeitura;
    }

    public double getPenultimaLeitura() {
        return penultimaLeitura;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setUltimaLeitura(double novaUltimaLeitura) {
        this.ultimaLeitura = novaUltimaLeitura;
    }

    public void setPenultimaLeitura(double novaPenultimaLeitura) {
        this.penultimaLeitura = novaPenultimaLeitura;
    }

    public void gerarFatura() {
        if (fatura != null && !fatura.isQuitada()) {
            System.out.println("A fatura anterior ainda não foi quitada. Não é possível gerar uma nova fatura.");
            return;
        }

        double leituraAnterior = penultimaLeitura;
        double leituraAtual = ultimaLeitura;
        penultimaLeitura = leituraAtual;

        fatura = new Fatura(leituraAnterior, leituraAtual);

        ultimaLeitura = leituraAtual;

        System.out.println("Fatura gerada com sucesso:");
        System.out.println("Data de Emissão: " + fatura.getDataEmissao());
        System.out.println("Leitura Anterior: " + fatura.getLeituraAnterior());
        System.out.println("Leitura Atual: " + fatura.getLeituraAtual());
        System.out.println("Valor Calculado: " + fatura.getValorCalculado());
    }
}
