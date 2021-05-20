package com.mpkg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    Item item1;
    Item item2;

    @Before
    public void itemSetUp(){
        item1 = new Item("TestItem1", "Desc", Moveable.MOBILE);
        item2 = new Item("TestItem2", "Desc", Moveable.STATIONARY);
    }
    @Test
    public void testIsMoveable(){
        boolean result1 = item1.isMoveable();
        Assert.assertTrue(result1);
    }
    @Test
    public void testIsNotMoveable(){
        boolean result2 = item2.isMoveable();
        Assert.assertFalse(result2);
    }
    @Test
    public void testGetName(){
        String itemName = item1.getName();
        Assert.assertEquals("TestItem1", itemName);
    }
}
