package agh.ii.prinjava.lab06.lst06_01;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Ex2 {
    // f1(x) = x - 2
    static Function<Double, Double> f1 = x -> x - 2.0;

    // f2(x, y) = sqrt(x^2 + y^2)
    static BiFunction<Double, Double, Double> f2 = (x, y) -> Math.sqrt(x*x + y*y);

    // f3(x, y, z) = sqrt(x^2 + y^2 + z^2)
    static TriFunction<Integer, Integer, Integer, Double> f3 = (x, y, z) -> Math.sqrt(x*x + y*y + z*z);

    public static void main(String[] args) {
        // Test f1(x)
        System.out.println(f1.apply(5.0)); // Output: 3.0

        // Test f2(x, y)
        System.out.println(f2.apply(3.0, 4.0)); // Output: 5.0

        // Test f3(x, y, z)
        System.out.println(f3.apply(1, 2, 2)); // Output: 3.0
    }
}

@FunctionalInterface
interface TriFunction<A,B,C,R> {

    R apply(A a, B b, C c);

    default <V> TriFunction<A, B, C, V> andThen(
            Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (A a, B b, C c) -> after.apply(apply(a, b, c));
    }
}
