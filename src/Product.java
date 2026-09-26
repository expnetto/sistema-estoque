public abstract class Product implements Vendavel {

    private String nome;
    private double preco;
    private int quantidade;

    public Product(String nome, double preco, int quantidade) throws QuantidadeInvalidaException {
        if (preco < 0) {
            throw new QuantidadeInvalidaException("Preco invalido para o produto " + nome + ": " + preco);
        }
        if (quantidade < 0) {
            throw new QuantidadeInvalidaException("Quantidade invalida para o produto " + nome + ": " + quantidade);
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public abstract double calcularValorTotal();

    public String getDescricao() {
        return nome + " | Preco: R$ " + String.format("%.2f", preco) + " | Quantidade: " + quantidade;
    }

    @Override
    public void vender(int quantidadeDesejada) throws ProdutoIndisponivelException {
        if (quantidadeDesejada > quantidade) {
            throw new ProdutoIndisponivelException("Estoque insuficiente de " + nome
                    + ". Pedido: " + quantidadeDesejada + ", disponivel: " + quantidade);
        }
        quantidade = quantidade - quantidadeDesejada;
        System.out.println("Venda realizada: " + quantidadeDesejada + " unidade(s) de " + nome
                + ". Restam " + quantidade + " no estoque.");
    }

    public void aplicarDesconto(double percentual) {
        if (percentual <= 0 || percentual > 100) {
            System.out.println("Percentual de desconto invalido: " + percentual);
            return;
        }
        double desconto = preco * percentual / 100;
        preco = preco - desconto;
        System.out.println("Desconto de " + percentual + "% aplicado em " + nome
                + ". Novo preco: R$ " + String.format("%.2f", preco));
    }

    public void aplicarDesconto(double percentual, double descontoMaximo) {
        if (percentual <= 0 || percentual > 100) {
            System.out.println("Percentual de desconto invalido: " + percentual);
            return;
        }
        double desconto = preco * percentual / 100;
        if (desconto > descontoMaximo) {
            desconto = descontoMaximo;
        }
        preco = preco - desconto;
        System.out.println("Desconto de R$ " + String.format("%.2f", desconto) + " aplicado em " + nome
                + " (limite de R$ " + String.format("%.2f", descontoMaximo) + "). Novo preco: R$ "
                + String.format("%.2f", preco));
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
