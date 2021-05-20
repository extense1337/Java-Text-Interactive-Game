package com.mpkg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CraftSwordTest {
    private PlanetsList planets;
    private Player player;

    @Test
    public void testCorrectPlanet() throws Exception{
        PlanetsList planetsList = new PlanetsList();
        boolean result = CraftSword.isWbPlanet(planetsList.getPlanetByName("Дагоба"));
        Assert.assertTrue(result);
    }
    @Test
    public void testIncorrectPlanet() throws Exception{
        PlanetsList planetsList = new PlanetsList();
        boolean result = CraftSword.isWbPlanet(planetsList.getPlanetByName("Татуин"));
        Assert.assertFalse(result);
    }
    @Before
    public void playerSetUp(){
        planets = new PlanetsList();
        player = new Player(planets.getPlanet(0), new Inventory(new ArrayList<>()));
        player.addItem(new Item("Энергоячейка", "Необходима для создания светового меча", Moveable.MOBILE));
        player.addItem(new Item("Световой кристалл", "Необходим для создания светового меча", Moveable.MOBILE));
        player.addItem(new Item("Рукоять меча", "Необходима для создания светового меча", Moveable.MOBILE));
    }
    @Test
    public void enoughSwordDetails(){
        boolean result = CraftSword.hasSwordDetails(player);
        Assert.assertTrue(result);
    }
    @Test
    public void notEnoughSwordDetails(){
        player.removeItem("Световой кристалл");
        boolean result = CraftSword.hasSwordDetails(player);
        Assert.assertFalse(result);
    }
}
