package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenJobDescByName() {
        List<Job> job = Arrays.asList(
                new Job("Apple", 1),
                new Job("Orange", 2),
                new Job("Banana", 3),
                new Job("Grape", 4)
        );
        Collections.sort(job, new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("Orange", 2),
                new Job("Grape", 4),
                new Job("Banana", 3),
                new Job("Apple", 1)
        );
        Assert.assertEquals(expected, job);
    }

    @Test
    public void whenJobAscByName() {
        List<Job> job = Arrays.asList(
                new Job("Apple", 1),
                new Job("Orange", 2),
                new Job("Banana", 3),
                new Job("Grape", 4)
        );
        Collections.sort(job, new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("Apple", 1),
                new Job("Banana", 3),
                new Job("Grape", 4),
                new Job("Orange", 2)
        );
        Assert.assertEquals(expected, job);
    }

    @Test
    public void whenJobDescByPriority() {
        List<Job> job = Arrays.asList(
                new Job("Apple", 1),
                new Job("Orange", 2),
                new Job("Banana", 3),
                new Job("Grape", 4)
        );
        Collections.sort(job, new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Grape", 4),
                new Job("Banana", 3),
                new Job("Orange", 2),
                new Job("Apple", 1)
        );
        Assert.assertEquals(expected, job);
    }

    @Test
            public void whenJobAscByPriority() {
    List<Job> job = Arrays.asList(
            new Job("Grape", 4),
            new Job("Banana", 3),
            new Job("Orange", 2),
            new Job("Apple", 1)
    );
        Collections.sort(job, new JobAscByPriority());
    List<Job> expected = Arrays.asList(
            new Job("Apple", 1),
            new Job("Orange", 2),
            new Job("Banana", 3),
            new Job("Grape", 4)
    );
        Assert.assertEquals(expected, job);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityAndName() {
        Comparator<Job> cmpPriorityName = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpPriorityName.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, equalTo(0));
    }

    @Test
    public void whenComparatorByAscPriorityAndAscName() {
        Comparator<Job> cmpPriorityName = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpPriorityName.compare(
                new Job("Fix bug1", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}