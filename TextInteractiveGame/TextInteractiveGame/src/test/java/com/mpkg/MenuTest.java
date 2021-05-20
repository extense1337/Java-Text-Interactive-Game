package com.mpkg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MenuTest {
    Player player;
    PlanetsList planetsList;

    @Before
    public void setUpDefault(){
        planetsList = new PlanetsList();
        player = new Player(planetsList.getPlanet(0), new Inventory(new ArrayList<>()));
    }
    @Before
    public void setUpItems(){
        Item lightSaber = new Item("Световой меч", "Клинок чистой энергии", Moveable.MOBILE);
        Item farsight = new Item("Способность Провидение", "Видит очертания тех или иных событий в различное время", Moveable.MOBILE);
        Item telekinesis = new Item("Способность Телекинез", "Перемещает предметы силой", Moveable.MOBILE);
        Item tutaminis = new Item("Способность Тутаминис", "Поглощает энергию силы", Moveable.MOBILE);
        player.addItem(lightSaber);
        player.addItem(farsight);
        player.addItem(telekinesis);
        player.addItem(tutaminis);
    }
    @Test
    public void testWithNotEnoughItems(){
        player.removeItem("Световой меч");
        player.planet = planetsList.getPlanetByName("Экзегол");
        boolean result = Menu.slayTheBoss(player);
        Assert.assertFalse(result);
    }
    @Test
    public void testInWrongPlanet(){
        player.planet = planetsList.getPlanetByName("Джеда");

        boolean result = Menu.slayTheBoss(player);
        Assert.assertFalse(result);
    }
    @Test
    public void successfulKillingTheBoss(){
        player.planet = planetsList.getPlanetByName("Экзегол");
        boolean result = Menu.slayTheBoss(player);
        Assert.assertTrue(result);
    }

}
