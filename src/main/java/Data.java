import Entity.Author;
import Entity.Book;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Author> getAuthors() {
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "书名1", "类别,分类啊", 45));
        books1.add(new Book(2L, "书名2", "高效", 84));
        books1.add(new Book(3L, "书名3", "喜剧", 83));

        books2.add(new Book(5L, "书名4", "天啊", 65));
        books2.add(new Book(6L, "书名5", "高效", 89));

        books3.add(new Book(7L, "书名6", "久啊", 45));
        books3.add(new Book(8L, "书名7", "高效", 44));
        books3.add(new Book(9L, "书名8", "喜剧", 81));

        Author author1 = new Author(1L, "杨杰炜", 18, "my introduction 1", books1);
        Author author2 = new Author(2L, "abc", 19, "my introduction 2", books1);
        Author author3 = new Author(3L, "abc", 14, "my introduction 3", books2);
        Author author4 = new Author(4L, "dddd", 29, "my introduction 4", books2);
        Author author5 = new Author(5L, "sssss", 12, "my introduction 5", books3);

        return List.of(author1, author2, author3, author4, author5);
    }
}
