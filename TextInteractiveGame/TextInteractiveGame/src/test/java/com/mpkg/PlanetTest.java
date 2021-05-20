package com.mpkg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlanetTest {
    PlanetsList planetsList;

    @Before
    public void planetsSetUp(){
        planetsList = new PlanetsList();
    }
    @Test
    public void testAvailable(){
        boolean result = planetsList.getPlanetByName("Татуин").
                isAvailable(planetsList.getPlanetByName("Джеда"));
        Assert.assertTrue(result);
    }
    @Test
    public void testUnavailable(){
        boolean result = planetsList.getPlanetByName("Татуин").
                isAvailable(planetsList.getPlanetByName("Набу"));
        Assert.assertFalse(result);
    }
    @Test
    public void testSuccessfulGetItem(){
        Item item = new Item("Энергоячейка", "Необходима для создания светового меча", Moveable.MOBILE);
        Item pickedItem = planetsList.getPlanetByName("Татуин").pickUp("Энергоячейка");
        Assert.assertEquals(item, pickedItem);
    }
    @Test
    public void testGetNotExistingItem(){
        Item pickedItem = planetsList.getPlanetByName("Джеда").pickUp("Энергоячейка");
        Assert.assertEquals(null, pickedItem);
    }
}
