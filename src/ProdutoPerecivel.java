public class ProdutoPerecivel extends Product {

    private int diasParaVencer;

    public ProdutoPerecivel(String nome, double preco, int quantidade, int diasParaVencer)
            throws QuantidadeInvalidaException {
        super(nome, preco, quantidade);
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public double calcularValorTotal() {
        double total = getPreco() * getQuantidade();
        if (diasParaVencer <= 3) {
            total = total * 0.8;
        }
        return total;
    }

    @Override
    public String getDescricao() {
        String texto = super.getDescricao() + " | Vence em: " + diasParaVencer + " dia(s)";
        if (diasParaVencer <= 3) {
            texto = texto + " (20% de desconto)";
        }
        return texto;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }
}
