package Controller;

import Model.Carro;

import java.util.*;

public class CarroController {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        Carro carro2 = new Carro();

        Carro carro3 = new Carro("Toyota", "Corolla", 2013);
        Carro carro4 = new Carro("Fiat", "Toro", 2019);

        Carro carro5 = new Carro(1, "Troller", "T4", 2018);
        Carro carro6 = new Carro(2, "BYD", "Dolphin Mini", 2024);

        System.out.println(carro1.toString());
        System.out.println(carro2.toString());
        System.out.println(carro3.toString());
        System.out.println(carro4.toString());
        System.out.println(carro5.toString());
        System.out.println(carro6.toString());

        carro1.setId(1);
        carro1.setMarca("Toyota");
        carro1.setModelo("Corolla");
        carro1.setAno_fabricacao(2018);

        carro2.setId(2);
        carro2.setMarca("Fiat");
        carro2.setModelo("Toro");
        carro2.setAno_fabricacao(2024);

        carro3.setId(3);
        carro3.setMarca("Fiat");
        carro3.setModelo("Uno");
        carro3.setAno_fabricacao(2019);

        carro4.setId(4);
        carro4.setMarca("BYD");
        carro4.setModelo("Dolphin Mini");
        carro4.setAno_fabricacao(2024);

        carro5.setId(5);
        carro5.setMarca("Troller");
        carro5.setModelo("T4");
        carro5.setAno_fabricacao(2019);

        carro6.setId(6);
        carro6.setMarca("Fiat");
        carro6.setModelo("Pulse");
        carro6.setAno_fabricacao(2023);

        System.out.println();
        System.out.println("id: " + carro1.getId() + " marca: " + carro1.getMarca() + " modelo: " + carro1.getModelo() + " ano: " + carro1.getAno_fabricacao());
        System.out.println("id: " + carro2.getId() + " marca: " + carro2.getMarca() + " modelo: " + carro2.getModelo() + " ano: " + carro2.getAno_fabricacao());
        System.out.println("id: " + carro3.getId() + " marca: " + carro3.getMarca() + " modelo: " + carro3.getModelo() + " ano: " + carro3.getAno_fabricacao());
        System.out.println("id: " + carro4.getId() + " marca: " + carro4.getMarca() + " modelo: " + carro4.getModelo() + " ano: " + carro4.getAno_fabricacao());
        System.out.println("id: " + carro5.getId() + " marca: " + carro5.getMarca() + " modelo: " + carro5.getModelo() + " ano: " + carro5.getAno_fabricacao());
        System.out.println("id: " + carro6.getId() + " marca: " + carro6.getMarca() + " modelo: " + carro6.getModelo() + " ano: " + carro6.getAno_fabricacao());

        List<Carro> carroList = new ArrayList<>();
        carroList.add(carro1);
        carroList.add(carro2);
        carroList.add(carro3);
        carroList.add(carro4);
        carroList.add(carro5);
        carroList.add(carro6);
        System.out.println("Coleção tipo List: " + carroList);


        System.out.println();
        carroList.sort(Comparator.comparing(Carro::getId).reversed());
        System.out.println("Coleção ordenada decrescente: " + carroList);
        System.out.println();

        for (Carro carro : carroList) {
            if (carro.getId() == 3) {
                System.out.println("Resultado da busca pelo id 3: ");
                System.out.println(carro);
            }
        }

        System.out.println();
        System.out.println("Resultado da busca binária pelo id 3: ");
        Carro carroFind = carroList.stream()
                .filter(carro -> carro.getId() == 3)
                .findAny()
                .orElse(null);
        System.out.println(carroFind);
        System.out.println();

        Map<Integer, Carro> carroMap = new HashMap<>();
        carroMap.put(carro1.getId(), carro1);
        carroMap.put(carro2.getId(), carro2);
        carroMap.put(carro3.getId(), carro3);
        carroMap.put(carro4.getId(), carro4);
        carroMap.put(carro5.getId(), carro5);
        carroMap.put(carro6.getId(), carro6);

        System.out.println();
        System.out.println("Coleção do tio Map: " + carroMap);
        System.out.println();

        System.out.println("Resultado da busca pelo id 3 pela coleção Map: ");
        System.out.println(carroMap.get(3));
    }
}
