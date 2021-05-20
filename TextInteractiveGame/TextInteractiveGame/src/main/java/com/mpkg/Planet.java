package com.mpkg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Planet {
    String name;
    String description;
    Inventory inventory;
    HashMap<Direction, Planet> directions;
    private static final Logger logger = LogManager.getLogger();

    public Planet(String name, String description, Inventory inventory) {
        this.name = name;
        this.description = description;
        this.inventory = inventory;
        directions = new HashMap<>();
    }
    public void showAvailable(){
        Iterator<Map.Entry<Direction, Planet>> entries = directions.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Direction, Planet> entry = entries.next();
            System.out.println("Направление: " + entry.getKey() + " Планета: " + entry.getValue().name);
        }
    }
    public boolean isAvailable(Planet planet){
        if(directions.containsValue(planet)){
            return true;
        }
        else {
            logger.warn("Not available planet.");
            System.out.println("Переход на данную планету невозможен, проверьте звездную карту!");
            return false;
        }
    }
    public Item pickUp(String itemName){
        logger.info("Picking up item from the planet");
        if(itemName == null){
            logger.warn("Null item name.");
            System.out.println("Пустое поле имени.");
            return null;
        }
        if(inventory.getItem(itemName) == null) {
            logger.warn("Item doesn't exist.");
            return null;
        }
        if(!inventory.getItem(itemName).isMoveable()) {
            logger.warn("Item isn't movable.");
            System.out.println("Данный предмет нельзя взять.");
            return null;
        }
        Item item = inventory.getItem(itemName);
        return item;
    }
    public void removeItem(String itemName){
        logger.info("Removing item from planet.");
        inventory.remove(inventory.getItem(itemName));
    }

    public void addDirection(Direction direction, Planet planet){
        logger.info("Adding direction to " + planet.name + ".");
        directions.put(direction, planet);
    }
    public void showInventory(){
        if(inventory.isEmpty()){
            System.out.println("На планете ничего нет.");
            return;
        }
        inventory.show();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return name.equals(planet.name) && description.equals(planet.description) && inventory.equals(planet.inventory) && Objects.equals(directions, planet.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, inventory, directions);
    }
}
