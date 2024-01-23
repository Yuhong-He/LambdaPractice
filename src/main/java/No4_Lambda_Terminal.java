import Entity.Author;
import Entity.Book;
import lombok.val;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class No4_Lambda_Terminal {
    static List<Author> authors;

    public static void main(String[] args) {
        authors = Data.getAuthors();
//        forEach();
//        count();
//        max();
//        collect();
//        anyMatch();
//        allMatch();
//        noneMatch();
//        findAny();
//        findFirst();
        reduce();
    }

    private static void forEach() {
        authors.stream()
                .map(Author::getName)
                .distinct()
                .forEach(System.out::println);
    }

    private static void count() {
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    private static void max() {
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .max((o1, o2) -> o1 - o2);
        System.out.println(max.get());

        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .max((o1, o2) -> o2 - o1);
        System.out.println(min.get());
    }

    private static void collect() {
        List<String> list = authors.stream()
                .map(Author::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);

        Set<Book> set = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toSet());
        System.out.println(set);

        Map<String, List<Book>> map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(new Function<Author, String>() {
                    @Override
                    public String apply(Author author) {
                        return author.getName();
                    }
                }, new Function<Author, List<Book>>() {
                    @Override
                    public List<Book> apply(Author author) {
                        return author.getBooks();
                    }
                }));
        map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(Author::getName, Author::getBooks));
        System.out.println(map);
    }

    private static void anyMatch() {
        boolean result = authors.stream()
                .anyMatch(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() > 20;
                    }
                });
        result = authors.stream()
                .anyMatch(author -> author.getAge() > 20);
        System.out.println(result);
    }

    private static void allMatch() {
        boolean result = authors.stream()
                .allMatch(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() >= 18;
                    }
                });
        result = authors.stream()
                .allMatch(author -> author.getAge() >= 18);
        System.out.println(result);
    }

    private static void noneMatch() {
        boolean result = authors.stream()
                .noneMatch(author -> author.getAge() > 18);
        System.out.println(result);
    }

    private static void findAny() {
        System.out.println(authors.stream()
                .min((a1, a2) -> a1.getAge() - a2.getAge()).stream()
                .findAny()
                .get()
                .getName()
        );
    }

    private static void findFirst() {
        System.out.println(authors.stream()
                .filter(a -> a.getAge() > 18)
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .findFirst()
                .get()
                .getName()
        );
    }

    private static void reduce() {
        System.out.println(authors.stream()
                .distinct()
                .map(Author::getAge)
                .reduce(0, (result, element) -> result + element)
        );

        System.out.println(
                authors.stream()
                        .map(Author::getAge)
                        .reduce(0, (result, element) -> result > element ? result : element)
        );
    }
}
