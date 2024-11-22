package Controller;

import Model.Conta;

import java.util.*;

public class ContaController {
    public static void main(String[] args) {
        Conta conta1 = new Conta();
        Conta conta2 = new Conta();

        Conta conta3 = new Conta(1000.00);
        Conta conta4 = new Conta(2000.00);

        Conta conta5 = new Conta(1,3000.00);
        Conta conta6 = new Conta(2,4000.00);

        System.out.println(conta1.toString());
        System.out.println(conta2.toString());
        System.out.println(conta3.toString());
        System.out.println(conta4.toString());
        System.out.println(conta5.toString());
        System.out.println(conta6.toString());

        conta1.setId(1);
        conta1.deposita(1000.00);

        conta2.setId(2);
        conta2.deposita(2000.00);

        conta3.setId(3);
        conta3.deposita(3000.00);

        conta4.setId(4);
        conta4.deposita(4000.00);

        conta5.setId(5);
        conta5.deposita(5000.00);

        conta6.setId(6);
        conta6.deposita(6000.00);

        System.out.println(conta1.getId());
        System.out.println(conta1.getSaldo());
        System.out.println(conta2.getId());
        System.out.println(conta2.getSaldo());
        System.out.println(conta3.getId());
        System.out.println(conta3.getSaldo());
        System.out.println(conta4.getId());
        System.out.println(conta4.getSaldo());
        System.out.println(conta5.getId());
        System.out.println(conta5.getSaldo());
        System.out.println(conta6.getId());
        System.out.println(conta6.getSaldo());

        List<Conta> contaList = new ArrayList<>();
        contaList.add(conta1);
        contaList.add(conta2);
        contaList.add(conta3);
        contaList.add(conta4);
        contaList.add(conta5);
        contaList.add(conta6);
        System.out.println("Coleção tipo List: ");
        System.out.println(contaList);

        System.out.println();
        contaList.sort(Comparator.comparing(Conta::getId).reversed());
        System.out.println("Resultado da coleção list na ordem decrescente: ");
        System.out.println(contaList);

        System.out.println();
        for (Conta conta : contaList) {
            if (conta.getId() == 3) {
                System.out.println("Resultado da busca pelo id = 3 no tipo List: ");
                System.out.println(conta);
            }
        }

        System.out.println();
        System.out.println("Resultado da busca pelo id = 3 no tipo List método binary: ");
        contaList.sort(Comparator.comparing(Conta::getId));
        System.out.println(
                contaList.get(
                        Collections.binarySearch(
                                contaList,
                                new Conta(3, 0.0),
                                Comparator.comparing(Conta::getId)
                        )
                ));

        System.out.println();
        System.out.println("Resultado da busca pelo id = 3 no tipo List outro método binary: ");
        Conta contaFind = contaList.stream()
                .filter(c -> c.getId() == 3)
                .findAny()
                .orElse(null);
        System.out.println(contaFind);

        Map<Integer, Conta> contaMap = new HashMap<>();
        contaMap.put(conta1.getId(), conta1);
        contaMap.put(conta2.getId(), conta2);
        contaMap.put(conta3.getId(), conta3);
        contaMap.put(conta4.getId(), conta4);
        contaMap.put(conta5.getId(), conta5);
        contaMap.put(conta6.getId(), conta6);
        System.out.println("Coleção tipo Map\n" + contaMap);


        System.out.println();
        System.out.println("Resultado da busca pelo id = 3 no tipo Map: ");
        System.out.println(contaMap.get(3));



     }

}
