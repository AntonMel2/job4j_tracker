package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

   public List<Item> findById(int id) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (item.getId() == id) {
                rsl.add(item);
                break;
            }
        }
        return rsl;
    }

    private int indexOfTr(int id) {
        int rsl = -1;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = items.indexOf(item);
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int ind = indexOfTr(id);
        boolean rsl = ind > -1;
        if (rsl) {
            item.setId(id);
            items.set(ind, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int ind = indexOfTr(id);
        boolean rsl = ind > -1;
        if (rsl) {
            items.remove(ind);

        }
        return rsl;
    }
}

