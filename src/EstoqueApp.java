public class EstoqueApp {

    public static void main(String[] args) {

        Estoque estoque = new Estoque();

        System.out.println("===== SISTEMA DE ESTOQUE =====");
        System.out.println();

        System.out.println(">> Cadastrando produtos...");
        try {
            ProdutoComum arroz = new ProdutoComum("Arroz 5kg", 25.90, 10);
            ProdutoComum feijao = new ProdutoComum("Feijao 1kg", 8.50, 20);
            ProdutoPerecivel leite = new ProdutoPerecivel("Leite 1L", 5.00, 30, 2);
            ProdutoPerecivel queijo = new ProdutoPerecivel("Queijo Mussarela", 40.00, 5, 15);

            estoque.adicionarProduto(arroz);
            estoque.adicionarProduto(feijao);
            estoque.adicionarProduto(leite);
            estoque.adicionarProduto(queijo);

            System.out.println();
            System.out.println(">> Testando aplicarDesconto (sobrecarga)...");
            arroz.aplicarDesconto(10);
            queijo.aplicarDesconto(50, 5.00);

        } catch (QuantidadeInvalidaException e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }

        System.out.println();
        estoque.listarProdutos();

        System.out.println();
        System.out.println(">> Tentando cadastrar produto com quantidade negativa...");
        try {
            ProdutoComum errado = new ProdutoComum("Macarrao", 4.50, -3);
            estoque.adicionarProduto(errado);
        } catch (QuantidadeInvalidaException e) {
            System.out.println("QuantidadeInvalidaException capturada: " + e.getMessage());
        }

        System.out.println();
        System.out.println(">> Cadastrando mais um produto e vendendo...");
        try {
            ProdutoComum cafe = new ProdutoComum("Cafe 500g", 18.00, 12);
            estoque.adicionarProduto(cafe);

            estoque.venderProduto(1, 5);
            estoque.venderProduto(3, 10);
            System.out.println("Essa linha nao deveria aparecer");
        } catch (QuantidadeInvalidaException e) {
            System.out.println("QuantidadeInvalidaException capturada: " + e.getMessage());
        } catch (ProdutoIndisponivelException e) {
            System.out.println("ProdutoIndisponivelException capturada: " + e.getMessage());
        } catch (EstoqueException e) {
            System.out.println("Erro de estoque: " + e.getMessage());
        } finally {
            System.out.println("Fim da tentativa de venda.");
        }

        System.out.println();
        estoque.listarProdutos();
        System.out.println("VALOR TOTAL DO ESTOQUE: R$ "
                + String.format("%.2f", estoque.calcularValorTotalEstoque()));
        System.out.println("(o leite teve 20% de desconto porque vence em ate 3 dias)");
    }
}
