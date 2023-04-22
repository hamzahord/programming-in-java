package agh.ii.prinjava.lab06.lst06_02;

import java.util.function.*;



public class Ex2 {

    BiConsumer<String, String> bc = (s1, s2) -> System.out.println(s1 + " " + s2);

    // BiFunction: takes two arguments of any type and returns a result of any type
    BiFunction<Integer, Integer, String> bf = (a, b) -> "The sum of " + a + " and " + b + " is " + (a + b);
    String result1 = bf.apply(2, 3); // result = "The sum of 2 and 3 is 5"

    // BinaryOperator: takes two arguments of the same type and returns a result of the same type
    BinaryOperator<Integer> bo = (a, b) -> a + b;
    int sum = bo.apply(2, 3); // sum = 5

    // Function: takes an argument of any type and returns a result of any type
    Function<Integer, String> f = n -> "The number is " + n;
    String message = f.apply(42); // message = "The number is 42"

    // Predicate: takes an argument of any type and returns a boolean result
    Predicate<String> p = s -> s.startsWith("J");
    boolean startsWithJ = p.test("Java"); // startsWithJ = true

    // Supplier: takes no arguments and returns a result of any type
    Supplier<Integer> s = () -> 42;
    int result2 = s.get(); // result = 42

}
