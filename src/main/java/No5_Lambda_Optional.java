import Entity.Author;

import java.util.List;
import java.util.Optional;

public class No5_Lambda_Optional {
    static List<Author> authors;

    public static void main(String[] args) {
        authors = Data.getAuthors();

        Optional<Author> authorOptional1 = Optional.empty();
        authorOptional1.ifPresent(author -> System.out.println(author.getName()));

        Optional<Author> authorOptional2 = Optional.ofNullable(authors.get(0));
        authorOptional2.ifPresent(author -> System.out.println(author.getName()));

        Optional<Author> authorOptional3 = Optional.of(authors.get(0));
        authorOptional3.ifPresent(author -> System.out.println(author.getName()));

        System.out.println(authorOptional2.get().getName());
        System.out.println(authorOptional2.orElse(new Author()).getName());
        System.out.println(authorOptional2.orElseGet(() -> new Author()).getName());
//        authorOptional1.orElseThrow(() -> new Throwable("NULL, No Object!"));

        authorOptional2.filter(author -> author.getAge() > 20).ifPresent(author -> System.out.println(author.getName()));

        if (authorOptional1.isPresent()) {
            System.out.println("exists!");
        } else {
            System.out.println("not exists!");
        }

        authorOptional2.map(author -> author.getBooks())
                .ifPresent(books ->
                        books.stream()
                                .findAny()
                                .ifPresent(book -> System.out.println(book.getName()))
                        );
    }
}
