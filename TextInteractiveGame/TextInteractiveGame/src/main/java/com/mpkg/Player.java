package com.mpkg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player {
    Planet planet;
    Inventory inventory;
    private static final Logger logger = LogManager.getLogger();

    public Player(Planet planet, Inventory inventory) {
        this.planet = planet;
        this.inventory = inventory;
    }
    public String getCurrentPlanetName(){
        return planet.name;
    }
    public void lookAround(){
        planet.showAvailable();
    }
    public void go(Planet planetNext){
        planet = planetNext;
    }
    public boolean take(String itemName){
        if(planet.pickUp(itemName) != null){
            inventory.add(planet.pickUp(itemName));
            System.out.println(itemName + " подобран в Ваш инвентарь.");
            return true;
        }
        return false;
    }
    public void addItem(Item item){
        inventory.add(item);
    }
    public void removeItem(String itemName){
        inventory.remove(inventory.getItem(itemName));
    }
    public void inventory(){
        if(inventory.isEmpty()){
            System.out.println("Ваш инвентарь пока пуст.");
            return;
        }
        System.out.println("Ваши предметы: ");
        inventory.show();
    }
}
