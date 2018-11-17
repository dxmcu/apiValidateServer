package eleven;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Test;
import scala.io.Source;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

public class CollectionTest {
    @Test
    public void whenJoiningTwoArrays_thenJoined() {
        String[] animals1 = new String[]{"Dog", "Cat"};
        String[] animals2 = new String[]{"Bird", "Cow"};

        String[] result = Stream.concat(
                Arrays.stream(animals1), Arrays.stream(animals2)).toArray(size -> new String[size]);

        assertArrayEquals(result, new String[]{"Dog", "Cat", "Bird", "Cow"});
    }

    @Test
    public void whenConvertArrayToString_thenConverted() {
        String[] animals = new String[]{"Dog", "Cat", "Bird", "Cow"};
        String result = Arrays.stream(animals).collect(Collectors.joining(", "));

        assertEquals(result, "Dog, Cat, Bird, Cow");
    }

    @Test
    public void whenConvertCollectionToString_thenConverted() {
        Collection<String> animals = Arrays.asList("Dog", "Cat", "Bird", "Cow");
        String result = animals.stream().collect(Collectors.joining(", "));

        assertEquals(result, "Dog, Cat, Bird, Cow");
    }

    @Test
    public void whenSplitCollectionHalf_thenConverted() {
        Collection<String> animals = Arrays.asList(
                "Dog", "Cat", "Cow", "Bird", "Moose", "Pig");
        Collection<String> result1 = new ArrayList<>();
        Collection<String> result2 = new ArrayList<>();
        AtomicInteger count = new AtomicInteger();
        int midpoint = Math.round(animals.size() / 2);

        animals.forEach(next -> {
            int index = count.getAndIncrement();
            if (index < midpoint) {
                result1.add(next);
            } else {
                result2.add(next);
            }
        });

        assertTrue(result1.equals(Arrays.asList("Dog", "Cat", "Cow")));
        assertTrue(result2.equals(Arrays.asList("Bird", "Moose", "Pig")));
    }

    @Test
    public void whenSplitArrayByWordLength_thenConverted() {
        String[] animals = new String[]{"Dog", "Cat", "Bird", "Cow", "Pig", "Moose"};
        Map<Integer, List<String>> result = Arrays.stream(animals)
                .collect(Collectors.groupingBy(String::length));

        assertTrue(result.get(3).equals(Arrays.asList("Dog", "Cat", "Cow", "Pig")));
        assertTrue(result.get(4).equals(Arrays.asList("Bird")));
        assertTrue(result.get(5).equals(Arrays.asList("Moose")));
    }

    @Test
    public void streamTest() {
        Stream<String> stream = Stream.iterate("", s -> s + "s")
                .takeWhile(s -> s.length() < 10);
        stream.dropWhile(s -> !s.contains("sssss"));

        Stream.iterate(0, i -> i < 10, i -> i + 1)
                .forEach(System.out::println);
    }
}
