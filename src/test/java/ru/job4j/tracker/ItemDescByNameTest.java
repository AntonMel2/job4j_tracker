package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemDescByNameTest  {

    @Test
    public void whenItemDescByNameTest() {
        List<Item> items = Arrays.asList(
                new Item(1, "Apple"),
                new Item(2, "Orange"),
                new Item(3, "Banana"),
                new Item(4, "Grape")
        );
        Collections.sort(items, Collections.reverseOrder(new ItemDescByName()));
        List<Item> expected = Arrays.asList(
                new Item(2, "Orange"),
                new Item(4, "Grape"),
                new Item(3, "Banana"),
                new Item(1, "Apple")
        );
        Assert.assertEquals(expected, items);
    }

}