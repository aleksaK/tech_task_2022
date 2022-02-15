package lv.kalashnikov.insurance.core.domain;

import java.util.List;

public class Entity {

    private String name;
    private List<Item> items;

    public Entity() {}

    public Entity(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}