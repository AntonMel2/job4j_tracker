package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemAscByNameTest  {

    @Test
    public void whenItemAscByNameTest() {
        List<Item> items = Arrays.asList(
                new Item(1, "Apple"),
                new Item(2, "Orange"),
                new Item(3, "Banana"),
                new Item(4, "Grape")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "Apple"),
                new Item(3, "Banana"),
                new Item(4, "Grape"),
                new Item(2, "Orange")
        );
        Assert.assertEquals(expected, items);
    }
}