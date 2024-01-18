import Entity.Author;
import Entity.Book;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class No3_Lambda_Intermediate {

    static List<Author> authors;

    public static void main(String[] args) {
        authors = Data.getAuthors();
//        filter();
//        map();
//        distinct();
//        sorted();
//        limit();
//        skip();
        flatMap();
    }

    private static void filter() {
        authors.stream()
                .filter(author -> author.getName().length() > 3)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void map() {
        authors.stream()
                .map(new Function<Author, String>() {
                    @Override
                    public String apply(Author author) {
                        return author.getName();
                    }
                })
                .forEach(author -> System.out.println(author));


        authors.stream()
                .map(author -> author.getName())
                .forEach(System.out::println);

        authors.stream()
                .map(Author::getName)
                .forEach(System.out::println);

        authors.stream()
                .map(Author::getAge)
                .map(age -> age * 100)
                .forEach(System.out::println);
    }

    private static void distinct() {
        authors.stream()
                .distinct() // 要重写Author类的equals方法和hashCode方法
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void sorted() {
        authors.stream()
                .distinct()
                .sorted((a1, a2) -> a1.getAge() - a2.getAge())
                .forEach(author -> System.out.println(author.getAge()));

        authors.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Author::getAge))
                .forEach(author -> System.out.println(author.getAge()));

        authors.stream()
                .distinct()
                .sorted((a1, a2) -> a2.getAge() - a1.getAge())
                .forEach(author -> System.out.println(author.getAge()));
    }

    private static void limit() {
        authors.stream()
                .limit(2)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void skip() {
        authors.stream()
                .skip(2)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void flatMap() {
        authors.stream()
                .flatMap(new Function<Author, Stream<Book>>() {
                    @Override
                    public Stream<Book> apply(Author author) {
                        return author.getBooks().stream();
                    }
                })
                .distinct()
                .forEach(book -> System.out.println(book.getName()));

        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));

        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(System.out::println);
    }

}
