package com.mpkg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Menu {
    PlanetsList planets;
    Player player;
    int choice;
    List<String> menuLines = List.of(
            "---------------------------------",
            "1. Открыть звездную карту",
            "2. Узнать текущее местоположение",
            "3. Открыть инвентарь",
            "4. Перейти на другую планету",
            "5. Искать предметы на планете",
            "6. Получить предмет с планеты",
            "7. Создать световой меч",
            "8. Сразиться с древними ситхами",
            "9. Выйти из игры",
            "---------------------------------");
    private static final Logger logger = LogManager.getLogger();

    Menu(){
        planets = new PlanetsList();
        player = new Player(planets.getPlanet(0), new Inventory(new ArrayList<>()));
        boolean bossKilled = false;

        System.out.println("Приветствую! Это игра \"Звездные войны\".");
        System.out.println("Вам предстоит собрать собственный световой мечь из деталей");
        System.out.println("А также освоить определенные способности.");
        System.out.println("Для завершения Вы должны убить древних ситхов.");
        System.out.println("Итак, выберите первое действие. ");

        logger.info("Launching case menu cycle");
        do {
            Stream menuStream = menuLines.stream();
            menuStream.forEach(System.out::println);

            logger.info("Menu opening.");

            System.out.print("Следующее действие: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            System.out.println();

            switch (choice){
                case 1:
                    logger.info("Visual map chosen.");
                    visualMap();
                    break;
                case 2:
                    logger.info("Current planet chosen.");
                    currentPlanet(player);
                    break;
                case 3:
                    logger.info("Check inventory chosen.");
                    checkInventory(player);
                    break;
                case 4:
                    logger.info("Change planet chosen.");
                    changePlanet(player);
                    break;
                case 5:
                    logger.info("Find items chosen.");
                    findItems(player);
                    break;
                case 6:
                    logger.info("Take item chosen.");
                    takeItem(player);
                    break;
                case 7:
                    logger.info("Sword craft chosen");
                    craftSword(player);
                    break;
                case 8:
                    if(bossKilled){
                        logger.warn("Boss already killed.");
                        System.out.println("Древние ситхи уже повержены.");
                        break;
                    }
                    logger.info("Boss slaying chosen.");
                    bossKilled = slayTheBoss(player);
                    break;
                case 9:
                    logger.info("Leave chosen.");
                    System.out.println("Выход");
                    break;
            }  }while (choice != 9);
    }
    public void visualMap(){
        logger.info("Showing visual map.");
        System.out.println("Tatuin – Jeda – Naboo \n" +
                           "           |       |  \n" +
                           "        Dagoba  Exegol\n" +
                           "           |          \n" +
                           "        Kamino        \n");
    }
    public void currentPlanet(Player player){
        logger.info("Showing current planet.");
        System.out.println("Вы находитесь на планете - " + player.getCurrentPlanetName());
        System.out.println(player.planet.description);
    }
    public void checkInventory(Player player){
        logger.info("Showing inventory.");
        player.inventory();
    }
    public void changePlanet(Player player){
        System.out.println("Доступные планеты для перехода: ");
        logger.info("Showing available planets.");
        player.lookAround();
        System.out.print("Выберите планету: ");
        Scanner sc = new Scanner(System.in);
        logger.info("Waiting for input planet name.");
        String planetName = sc.nextLine();
        Planet choosenPlanet = planets.getPlanetByName(planetName);

        if (choosenPlanet == null || !player.planet.isAvailable(choosenPlanet)) {
            logger.warn("Wrong chosen planet.");
            return;
        }

        player.go(choosenPlanet);
        logger.info("Changing player's planet.");
        System.out.println("Вы перешли на планету " + player.planet.name);
    }
    public void findItems(Player player){
        logger.info("Showing planet's inventory.");
        player.planet.showInventory();
    }
    public void takeItem(Player player){
        System.out.print("Введите название предмета: ");
        Scanner sc = new Scanner(System.in);
        logger.info("Waiting for input item name.");
        String itemName = sc.nextLine();

        logger.info("Adding item to player's inventory.");
        boolean took = player.take(itemName);
        if(took) {
            logger.info("Removing item from planet.");
            player.planet.removeItem(itemName);
        }
    }
    public void craftSword(Player player){
        logger.info("Crafting a light saber.");
        new CraftSword(player);
    }
    public static boolean slayTheBoss(Player player){
        logger.info("Fighting with boss.");
        if(player.getCurrentPlanetName() != "Экзегол") {
            System.out.println("Древние ситхи находятся на планете Экзегол.");
            logger.warn("Wrong planet.");
            return false;
        }
        if(!player.inventory.hasItem("Световой меч")) {
            System.out.println("Чтобы убить древних ситхов, вам нужен световой меч");
            logger.warn("Hasn't light saber.");
            return false;
        }
        if(!player.inventory.hasItem("Способность Провидение")) {
            System.out.println("Для успешного сражения с древними ситхами, необходимо освоить способность Провидение");
            logger.warn("Hasn't providence.");
            return false;
        }
        if(!player.inventory.hasItem("Способность Телекинез")) {
            System.out.println("Для успешного сражения с древними ситхами, необходимо освоить способность Телекинез");
            logger.warn("Hasn't telekinesis.");
            return false;
        }
        if(!player.inventory.hasItem("Способность Тутаминис")) {
            System.out.println("Для успешного сражения с древними ситхами, необходимо освоить способность Тутаминис");
            logger.warn("Hasn't tutaminis.");
            return false;
        }
        logger.warn("Boss killed.");
        System.out.println("Поздравлаем! Вы смогли победить древних ситхов.\nИгра завершена.");
        return true;
    }
}
