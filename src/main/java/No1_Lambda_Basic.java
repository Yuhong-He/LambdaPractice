import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class No1_Lambda_Basic {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("I'm in Runnable")).start();


        // ------------
        System.out.println(calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        }));

        System.out.println(calculateNum(((int left, int right) -> {
            return left + right;
        })));

        System.out.println(calculateNum(((left, right) -> left + right)));


        // ------------
        printNum(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value % 2 == 0;
            }
        });

        printNum((int value) -> {
            return value % 2 == 0;
        });

        printNum(value -> value % 2 == 0);


        // ------------
        Integer i3_1 = typeCover(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });
        System.out.println(i3_1);

        Integer i3_2 = typeCover((String s) -> {
            return Integer.parseInt(s);
        });
        System.out.println(i3_2);

        Integer i3_3 = typeCover(s -> Integer.parseInt(s));
        System.out.println(i3_3);


        // ------------
        foreachArr(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value + " ");
            }
        });
        System.out.println(" ");

        foreachArr((int value) -> {
            System.out.print(value + " ");
        });
        System.out.println(" ");

        foreachArr(value -> System.out.print(value + " "));
    }

    public static void foreachArr(IntConsumer consumer) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i: arr) {
            consumer.accept(i);
        }
    }

    public static <R> R typeCover(Function<String, R> function) {
        String str = "1235";
        R result = function.apply(str);
        return result;
    }

    public static void printNum(IntPredicate predicate) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i: arr) {
            if (predicate.test(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println(" ");
    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }
}
