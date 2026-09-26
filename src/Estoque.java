import java.util.ArrayList;

public class Estoque {

    private ArrayList<Product> produtos;

    public Estoque() {
        produtos = new ArrayList<Product>();
    }

    public void adicionarProduto(Product p) {
        produtos.add(p);
        System.out.println("Produto cadastrado: " + p.getNome());
    }

    public void venderProduto(int indice, int quantidade) throws ProdutoIndisponivelException, EstoqueException {
        if (indice < 0 || indice >= produtos.size()) {
            throw new EstoqueException("Nao existe produto na posicao " + indice);
        }
        Product p = produtos.get(indice);
        p.vender(quantidade);
    }

    public double calcularValorTotalEstoque() {
        double total = 0;
        for (Product p : produtos) {
            total = total + p.calcularValorTotal();
        }
        return total;
    }

    public void listarProdutos() {
        System.out.println("---- Produtos no estoque ----");
        for (int i = 0; i < produtos.size(); i++) {
            Product p = produtos.get(i);
            System.out.println("[" + i + "] " + p.getDescricao()
                    + " | Valor total: R$ " + String.format("%.2f", p.calcularValorTotal()));
        }
        System.out.println("-----------------------------");
    }
}
