package com.mpkg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CraftSword {
    Inventory objects;
    Inventory subject;
    Item result;
    private static final Logger logger = LogManager.getLogger();

    public CraftSword(Player player) {
        this.objects = player.inventory;
        this.subject = player.planet.inventory;

        if(!isWbPlanet(player.planet)){
            logger.warn("Hasn't workbench on the planet.");
            System.out.println("Вы должны быть на планете, где есть верстак.");
            return;
        }
        if(!hasSwordDetails(player)) {
            logger.warn("Hasn't necessary items.");
            System.out.println("У Вас нет необходимых предметов в инвентаре!");
            return;
        }
        result = new Item("Световой меч", "Клинок чистой энергии", Moveable.MOBILE);
        logger.info("Removing saber components.");
        player.removeItem("Энергоячейка");
        player.removeItem("Световой кристалл");
        player.removeItem("Рукоять меча");
        logger.info("Adding light saber to player.");
        player.addItem(result);
        System.out.println("Световой меч скрафчен и находится в Вашем инвентаре.");
    }
    public static boolean isWbPlanet(Planet planet){
        if(planet.inventory.hasItem("Верстак")) return true;
        return false;
    }
    public static boolean hasSwordDetails(Player player){
        if(player.inventory.hasItem("Энергоячейка")
                && player.inventory.hasItem("Световой кристалл")
                && player.inventory.hasItem("Рукоять меча")) return true;
        return false;
    }
}
