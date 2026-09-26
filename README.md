# Sistema de Estoque de Produtos

Trabalho da primeira avaliacao de Paradigmas de Linguagens de Programacao.

Programa em Java que cadastra produtos comuns e pereciveis, faz vendas e trata os erros com excecoes.

## O que foi usado

- Classe abstrata (`Product`)
- Heranca (`ProdutoComum` e `ProdutoPerecivel` herdam de `Product`)
- Interface (`Vendavel`)
- Polimorfismo dinamico (`@Override` no `calcularValorTotal()` e no `getDescricao()`)
- Polimorfismo estatico / sobrecarga (`aplicarDesconto`)
- Composicao (`Estoque` tem uma lista de `Product`)
- Excecoes proprias (`EstoqueException`, `QuantidadeInvalidaException`, `ProdutoIndisponivelException`)

## Classes

| Arquivo | O que faz |
|---|---|
| EstoqueException | excecao base |
| QuantidadeInvalidaException | preco ou quantidade negativos |
| ProdutoIndisponivelException | vender mais do que tem |
| Vendavel | interface com o metodo vender() |
| Product | classe abstrata base dos produtos |
| ProdutoComum | valor total = preco x quantidade |
| ProdutoPerecivel | 20% de desconto se faltar 3 dias ou menos pra vencer |
| Estoque | guarda os produtos, vende e soma o valor total |
| EstoqueApp | tem o main |

## Como rodar

Precisa ter o JDK instalado (fiz no Java 17).

```
javac -d out src/*.java
java -cp out EstoqueApp
```
