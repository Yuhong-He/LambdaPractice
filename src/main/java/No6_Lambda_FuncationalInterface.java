import Entity.Author;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class No6_Lambda_FuncationalInterface {
    static List<Author> authors;

    public static void main(String[] args) {
        authors = Data.getAuthors();
//        and();
//        useAnd();
//        or();
        negate();
    }

    public static void and() {
        authors.stream()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() > 17;
                    }
                }.and(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() < 65;
                    }
                }))
                .forEach(System.out::println);

        authors.stream()
                .filter(((Predicate<Author>) author -> author.getAge() > 17).and(author -> author.getAge() < 65))
                .forEach(System.out::println);
    }

    private static void useAnd() {
        printNum(value -> value % 2 == 0, value -> value > 4, new int[]{1,2,3,4,5,6,7,8,9,10});
    }

    public static void printNum(IntPredicate predicate1, IntPredicate predicate2, int[] arr) {
        for (int i: arr) {
            if (predicate1.and(predicate2).test(i)) {
                System.out.println(i);
            }
        }
    }

    private static void or() {
        authors.stream()
                .filter(((Predicate<Author>) author -> author.getAge() > 50).or(author -> author.getAge() < 20))
                .forEach(author -> System.out.println(author.getAge()));
    }

    private static void negate() {
        authors.stream()
                .filter(((Predicate<Author>) author -> author.getAge() > 15).negate())
                .forEach(author -> System.out.println(author.getAge()));
    }

}
