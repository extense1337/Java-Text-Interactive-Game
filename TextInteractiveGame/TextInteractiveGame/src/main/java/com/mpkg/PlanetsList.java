package com.mpkg;

import java.util.ArrayList;

public class PlanetsList {

    ArrayList<Planet> planets = new ArrayList<>();

    public PlanetsList() {

        planets.add(tatooine()); // 0
        planets.add(jeda()); // 1
        planets.add(naboo()); // 2
        planets.add(dagoba()); // 3
        planets.add(kamino()); // 4
        planets.add(exegol()); // 5

        planets.get(0).addDirection(Direction.RIGHT, planets.get(1)); // Tatooine

        planets.get(1).addDirection(Direction.LEFT, planets.get(0)); // Jeda
        planets.get(1).addDirection(Direction.RIGHT, planets.get(2));
        planets.get(1).addDirection(Direction.DOWN, planets.get(3));

        planets.get(2).addDirection(Direction.LEFT, planets.get(1)); // Naboo
        planets.get(2).addDirection(Direction.DOWN, planets.get(5));

        planets.get(3).addDirection(Direction.UP, planets.get(1)); // Dagoba
        planets.get(3).addDirection(Direction.DOWN, planets.get(4));

        planets.get(4).addDirection(Direction.UP, planets.get(3)); // Kamino

        planets.get(5).addDirection(Direction.UP, planets.get(2)); // Exegol
    }
    public Planet getPlanet(int index){
        return planets.get(index);
    }
    public Planet getPlanetByName(String planetName){
        int index = -1;
        for(var planet : planets){
            index++;
            if(planet.name.equals(planetName)){
                return planet;
            }
        }
        System.out.println("Такой планеты не существует! (Возможно, Вы ввели неправильное название)");
        return null;
    }
    public Planet tatooine() {
        Item powerCell = new Item("Энергоячейка", "Необходима для создания светового меча", Moveable.MOBILE);
        ArrayList<Item> itemsTatooine = new ArrayList<>();
        itemsTatooine.add(powerCell);
        Inventory inventoryTatooine = new Inventory(itemsTatooine);

        Planet tatuin = new Planet("Татуин", "Пустынная планета, на которой Вы появились, возможно, здесь находится энергоячейка", inventoryTatooine);
        return tatuin;
    }
    public Planet jeda() {
        Item lightCrystal= new Item("Световой кристалл", "Необходим для создания светового меча", Moveable.MOBILE);
        ArrayList<Item> itemsJeda = new ArrayList<>();
        itemsJeda.add(lightCrystal);
        Inventory inventoryJeda = new Inventory(itemsJeda);

        Planet jeda = new Planet("Джеда", "Планета с ископаемыми кристаллами", inventoryJeda);
        return jeda;
    }
    public Planet naboo() {
        Item lightSaberHilt = new Item("Рукоять меча", "Необходима для создания светового меча", Moveable.MOBILE);
        ArrayList<Item> itemsNaboo = new ArrayList<>();
        itemsNaboo.add(lightSaberHilt);
        Inventory inventoryNaboo = new Inventory(itemsNaboo);

        Planet naboo = new Planet("Набу", "Планета со множеством имперских штурмовиков и дроидов", inventoryNaboo);
        return naboo;
    }
    public Planet dagoba() {
        Item workbench = new Item("Верстак", "Собирает световой мечь из деталей", Moveable.STATIONARY);
        ArrayList<Item> itemsDagoba = new ArrayList<>();
        itemsDagoba.add(workbench);
        Inventory inventoryDagoba = new Inventory(itemsDagoba);

        Planet dagoba = new Planet("Дагоба", "По легенде на данной планете Люк Скайвокер собрал здесь свой первый светвой меч", inventoryDagoba);
        return dagoba;
    }
    public Planet kamino() {
        Item farsight = new Item("Способность Провидение", "Видит очертания тех или иных событий в различное время", Moveable.MOBILE);
        Item telekinesis = new Item("Способность Телекинез", "Перемещает предметы силой", Moveable.MOBILE);
        Item tutaminis = new Item("Способность Тутаминис", "Поглощает энергию силы", Moveable.MOBILE);
        ArrayList<Item> itemsKamino = new ArrayList<>();
        itemsKamino.add(farsight);
        itemsKamino.add(telekinesis);
        itemsKamino.add(tutaminis);
        Inventory inventoryKamino = new Inventory(itemsKamino);

        Planet kamino = new Planet("Камино", "Планета, на который сила особенно преобладает ", inventoryKamino);
        return kamino;
    }
    public Planet exegol() {
        Item theForce = new Item("Сила", "Необходима для успешного сражения с древними ситхами", Moveable.STATIONARY);
        ArrayList<Item> itemsExegol = new ArrayList<>();
        itemsExegol.add(theForce);
        Inventory inventoryExegol = new Inventory(itemsExegol);

        Planet exegol = new Planet("Экзегол", "Убежище древних ситхов", inventoryExegol);
        return exegol;
    }
}
