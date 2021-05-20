package com.mpkg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class Inventory {
    ArrayList<Item> items;
    private static final Logger logger = LogManager.getLogger();

    public Inventory(ArrayList<Item> items) {
        this.items = items;
    }

    public void add(Item item){
        logger.info("Adding item.");
        if(item == null) {
            logger.warn("Null item name.");
            System.out.println("Неверно указан предмет!");
            return;
        }
        items.add(item);
    }
    public void remove(Item item){
        logger.info("Removing item.");
        if(item == null) {
            logger.warn("Null item name.");
            System.out.println("Неверно указан предмет!");
            return;
        }
        if(!items.contains(item)){
            logger.warn("Hasn't item in inventory.");
            System.out.println("Предмет отсутствует в инвентаре!");
            return;
        }
        items.remove(item);
    }
    public void show(){
        for(var item : items)
            System.out.println(item.getName());
    }
    public Item getItem(String itemName){
        for(var item : items)
            if(item.getName().equals(itemName))
                return item;
        System.out.println("Предмет не найден.");
        logger.warn("The item doesn't exist on planet.");
        return null;
    }
    public boolean hasItem(String itemName){
        for(var item : items)
            if(item.getName().equals(itemName))
                return true;
        return false;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(items, inventory.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}
