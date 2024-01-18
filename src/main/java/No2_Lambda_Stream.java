import Entity.Author;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class No2_Lambda_Stream {

    public static void main(String[] args) {
        List<Author> authors = Data.getAuthors();
        // Print authors with age < 18
        authors.stream()
                .distinct() // remove duplicates
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() < 18;
                    }
                })
                .forEach(new Consumer<Author>() {
                    @Override
                    public void accept(Author author) {
                        System.out.println(author.getName());
                    }
                });
        authors.stream()
                .distinct() // remove duplicates
                .filter(author -> author.getAge() < 18)
                .forEach(author -> System.out.println(author.getName()));


        // create stream
        Stream<Author> authorStream = authors.stream();

        Integer[] arr = {1,2,3,4,5};
        Stream<Integer> arrStream1 = Arrays.stream(arr);
        Stream<Integer> arrStream2 = Stream.of(arr);

        Map<String, Integer> map = new HashMap<>();
        map.put("Google", 1);
        map.put("Yahoo", 3);
        map.put("Baidu", 2);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Stream<Map.Entry<String, Integer>> entryStream = entries.stream();
        entryStream
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
    }
}
