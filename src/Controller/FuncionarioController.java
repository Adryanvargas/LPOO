package Controller;

import Model.Funcionario;

import java.util.*;

public class FuncionarioController {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario();
        Funcionario funcionario2 = new Funcionario();

        Funcionario funcionario3 = new Funcionario(1, "Adryan", 3000);
        Funcionario funcionario4 = new Funcionario(2, "Duu", 5000);

        Funcionario funcionario5 = new Funcionario("Erick", 5000);
        Funcionario funcionario6 = new Funcionario("João", 5000);

        System.out.println(funcionario1.toString());
        System.out.println(funcionario2.toString());
        System.out.println(funcionario3.toString());
        System.out.println(funcionario4.toString());
        System.out.println(funcionario5.toString());
        System.out.println(funcionario6.toString());

        funcionario1.setId(1);
        funcionario1.setNome("Adryan");
        funcionario1.setSalario(5000);

        funcionario2.setId(2);
        funcionario2.setNome("Duu");
        funcionario2.setSalario(5000);

        funcionario3.setId(3);
        funcionario3.setNome("Erick");
        funcionario3.setSalario(4000);

        funcionario4.setId(4);
        funcionario4.setNome("Joao");
        funcionario4.setSalario(4000);

        funcionario5.setId(5);
        funcionario5.setNome("Caesar");
        funcionario5.setSalario(6000);

        funcionario6.setId(6);
        funcionario6.setNome("Pablo");
        funcionario6.setSalario(6000);

        System.out.println(funcionario1.getId());
        System.out.println(funcionario1.getNome());
        System.out.println(funcionario1.getSalario());

        System.out.println(funcionario2.getId());
        System.out.println(funcionario2.getNome());
        System.out.println(funcionario2.getSalario());

        System.out.println(funcionario3.getId());
        System.out.println(funcionario3.getNome());
        System.out.println(funcionario3.getSalario());

        System.out.println(funcionario4.getId());
        System.out.println(funcionario4.getNome());
        System.out.println(funcionario4.getSalario());

        System.out.println(funcionario5.getId());
        System.out.println(funcionario5.getNome());
        System.out.println(funcionario5.getSalario());

        System.out.println(funcionario6.getId());
        System.out.println(funcionario6.getNome());
        System.out.println(funcionario6.getSalario());

        List<Funcionario> funcionarioList = new ArrayList<>();
        funcionarioList.add(funcionario1);
        funcionarioList.add(funcionario2);
        funcionarioList.add(funcionario3);
        funcionarioList.add(funcionario4);
        funcionarioList.add(funcionario5);
        funcionarioList.add(funcionario6);
        System.out.println("Coleção tipo List: ");
        System.out.println(funcionarioList);

        funcionarioList.sort(Comparator.comparing(Funcionario::getId).reversed());
        System.out.println("Resultado da coleção list na ordem decrescente: ");
        System.out.println(funcionarioList);

        System.out.println();

        for (Funcionario funcionario : funcionarioList) {
            if (funcionario.getId() == 3) {
                    System.out.println("Resultado da busca por força bruta: ");
                    System.out.println(funcionario);
            }
        }

        System.out.println();
        System.out.println("Buscando funcionário pelo método binary");
        funcionarioList.sort(Comparator.comparing(Funcionario::getId));
        System.out.println(funcionarioList.get(
                        Collections.binarySearch(
                                funcionarioList,
                                new Funcionario(3, "null", 0),
                                Comparator.comparing(Funcionario::getId)
                        )
        ));

        //outro jeito

        System.out.println();
        Funcionario funcionarioFind = funcionarioList.stream()
                .filter(c -> c.getId() == 3)
                .findAny()
                .orElse(null);
        System.out.println("Resultado da outra busca binary: ");
        System.out.println(funcionarioFind);

        Map<Integer, Funcionario> funcionarioMap = new HashMap<>();
        funcionarioMap.put(funcionario1.getId(), funcionario1);
        funcionarioMap.put(funcionario2.getId(), funcionario2);
        funcionarioMap.put(funcionario3.getId(), funcionario3);
        funcionarioMap.put(funcionario4.getId(), funcionario4);
        funcionarioMap.put(funcionario5.getId(), funcionario5);
        funcionarioMap.put(funcionario6.getId(), funcionario6);
        System.out.println("\nFuncionários na coleção tipo Map: " + funcionarioMap);

        System.out.println();
        System.out.println("Resultado da busca: ");
        System.out.println(funcionarioMap.get(3));
    }
}
