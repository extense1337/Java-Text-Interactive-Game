package com.mpkg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class InventoryTest {
    Inventory inventory;

    /*public void add(Item item){
        if(item == null) {
            System.out.println("Неверно указан предмет!");
            return;
        }
        items.add(item);
    }*/
    @Before
    public void inventorySetUp(){
        ArrayList<Item> items = new ArrayList<>();
        inventory = new Inventory(items);
    }
    @Test
    public void emptyInventory(){
        boolean result = inventory.isEmpty();
        Assert.assertTrue(result);
    }
    @Test
    public void notAnEmptyInventory(){
        Item item = new Item("TestItem", "Desc", Moveable.MOBILE);
        inventory.add(item);
        boolean result = inventory.isEmpty();
        Assert.assertFalse(result);
        inventory.remove(item);
    }
    @Test
    public void addNullItem(){
        Item item = null;
        inventory.add(item);
        boolean result = inventory.isEmpty();
        Assert.assertTrue(result);
    }
    @Test
    public void shouldReturnItem(){
        Item item = new Item("TestItem", "Desc", Moveable.MOBILE);
        inventory.add(item);
        Item result = inventory.getItem("TestItem");
        Assert.assertEquals(item,result);
        inventory.remove(item);
    }
    @Test
    public void shouldNotReturnItem(){
        Item result = inventory.getItem("TestItem");
        Assert.assertEquals(null,result);
    }
}
