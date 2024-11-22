package Controller;

import Model.Funcionario;
import Model.Produto;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class ProdutoController {
    public static void main(String[] args) {
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();

        Produto produto3 = new Produto(3, "Campeira", "Linguiça", 22.90, 30);
        Produto produto4 = new Produto(4, "Seca", "Linguiça Defumada", 23.80, 50);

        Produto produto5 = new Produto("Trakinas", "Bolachinha", 3.50, 10);
        Produto produto6 = new Produto("Chimango", "Pastel de Feira", 10.00, 15);

        System.out.println(produto1.toString());
        System.out.println(produto2.toString());
        System.out.println(produto3.toString());
        System.out.println(produto4.toString());
        System.out.println(produto5.toString());
        System.out.println(produto6.toString());

        produto1.setId(1);
        produto1.setNome("Coca-Cola");
        produto1.setDescricao("Refrigerante");
        produto1.setValor(10.00);
        produto1.setEstoque(20);

        produto2.setId(2);
        produto2.setNome("Sprite");
        produto2.setDescricao("Refrigerante");
        produto2.setValor(7.50);
        produto2.setEstoque(30);

        produto3.setId(3);
        produto3.setNome("Chimango");
        produto3.setDescricao("Pastel de Feira");
        produto3.setValor(10.00);
        produto3.setEstoque(20);

        produto4.setId(4);
        produto4.setNome("Snickers");
        produto4.setDescricao("Chocolate");
        produto4.setValor(3.50);
        produto4.setEstoque(50);

        produto5.setId(5);
        produto5.setNome("Macanudo");
        produto5.setDescricao("Pastel de Feira");
        produto5.setValor(10.00);
        produto5.setEstoque(23);

        produto6.setId(6);
        produto6.setNome("Lollo");
        produto6.setDescricao("Chocolate");
        produto6.setValor(3.50);
        produto6.setEstoque(50);

        System.out.println(produto1.getId());
        System.out.println(produto1.getNome());
        System.out.println(produto1.getDescricao());
        System.out.println(produto1.getValor());
        System.out.println(produto1.getEstoque());

        System.out.println(produto2.getId());
        System.out.println(produto2.getNome());
        System.out.println(produto2.getDescricao());
        System.out.println(produto2.getValor());
        System.out.println(produto2.getEstoque());

        System.out.println(produto3.getId());
        System.out.println(produto3.getNome());
        System.out.println(produto3.getDescricao());
        System.out.println(produto3.getValor());
        System.out.println(produto3.getEstoque());

        System.out.println(produto4.getId());
        System.out.println(produto4.getNome());
        System.out.println(produto4.getDescricao());
        System.out.println(produto4.getValor());
        System.out.println(produto4.getEstoque());

        System.out.println(produto5.getId());
        System.out.println(produto5.getNome());
        System.out.println(produto5.getDescricao());
        System.out.println(produto5.getValor());
        System.out.println(produto5.getEstoque());

        System.out.println(produto6.getId());
        System.out.println(produto6.getNome());
        System.out.println(produto6.getDescricao());
        System.out.println(produto6.getValor());
        System.out.println(produto6.getEstoque());

        List<Produto> produtoList = new ArrayList<>();
        produtoList.add(produto1);
        produtoList.add(produto2);
        produtoList.add(produto3);
        produtoList.add(produto4);
        produtoList.add(produto5);
        produtoList.add(produto6);
        System.out.println(produtoList);

        produtoList.sort(Comparator.comparing(Produto::getId).reversed());
        System.out.println("Resultado da coleção list na ordem decrescente: ");
        System.out.println(produtoList);

        System.out.println();
        for (Produto produto : produtoList) {
            if (produto.getId() == 3) {
                System.out.println("Resultado da busca pelo Id por força bruta: ");
                System.out.println(produto);
            }
        }


        System.out.println();
        System.out.println("Resultado por método de fluxo: ");
        Produto produtoFind = produtoList.stream().filter(c -> c.getId() == 3).findFirst().orElse(null);
        System.out.println(produtoFind);

        System.out.println();
        System.out.println("Resultado da busca por binarySearch");
        produtoList.sort(Comparator.comparing(Produto::getId));
        produtoFind = produtoList.get(
                Collections.binarySearch(
                        produtoList,
                        new Produto(3, "null"),
                        Comparator.comparing(Produto::getId)
                )
        );
        System.out.println(produtoFind);

        Map<Integer, Produto> produtoMap = new HashMap<>();
        produtoMap.put(produto1.getId(), produto1);
        produtoMap.put(produto2.getId(), produto2);
        produtoMap.put(produto3.getId(), produto3);
        produtoMap.put(produto4.getId(), produto4);
        produtoMap.put(produto5.getId(), produto5);
        produtoMap.put(produto6.getId(), produto6);

        System.out.println("Coleção do tipo Map: ");
        System.out.println(produtoMap);

        System.out.println();
        System.out.println("Resultado da busca pelo tipo Map: ");
        System.out.println(produtoMap.get(3));
    }
}
