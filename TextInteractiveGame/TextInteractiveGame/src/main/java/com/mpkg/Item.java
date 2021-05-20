package com.mpkg;

import java.util.Objects;

public class Item {
    String name;
    String description;
    Moveable moveable;

    public Item(String name, String description, Moveable moveable) {
        this.name = name;
        this.description = description;
        this.moveable = moveable;
    }
    public boolean isMoveable(){
        if(moveable == Moveable.STATIONARY) return false;
        return true;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(description, item.description) && moveable == item.moveable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, moveable);
    }
}
