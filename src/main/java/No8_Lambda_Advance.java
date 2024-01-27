import Entity.Author;

import java.util.List;
import java.util.stream.Stream;

public class No8_Lambda_Advance {
    static List<Author> authors;

    public static void main(String[] args) {
        authors = Data.getAuthors();

        authors.stream()
                .mapToInt(Author::getAge)
                .map(num -> num + 100)
                .forEach(System.out::println);

        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        int sum = stream.parallel()
                .peek(integer -> System.out.println(integer + ": " + Thread.currentThread().getName()))
                .filter(num -> num > 5)
                .reduce(Integer::sum)
                .get();
        System.out.println(sum);

        sum = authors.parallelStream()
                .peek(author -> System.out.println(author.getName() + ": " + Thread.currentThread().getName()))
                .map(Author::getAge)
                .filter(age -> age > 15)
                .reduce(Integer::sum)
                .get();
        System.out.println(sum);
    }
}
