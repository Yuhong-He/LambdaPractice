import Entity.Author;

import java.util.List;

public class No7_Lambda_MethodReference {
    static List<Author> authors;

    public static void main(String[] args) {
        authors = Data.getAuthors();

        authors.stream()
                .map(Author::getAge)
                .forEach(System.out::println);
        StringBuilder sb = new StringBuilder();
        authors.stream()
                .map(Author::getName)
                .forEach(sb::append);
        System.out.println(sb);
    }
}
