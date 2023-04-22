package agh.ii.prinjava.lab06.lst06_04;
import java.util.function.*;

public class Ex2 {
    public static void main(String[] args) {
        // f1(x) = 2x, g1(x) = x^2
        Function<Double, Double> f1 = x -> 2 * x;
        Function<Double, Double> g1 = x -> x * x;
        Function<Double, Double> f1g1 = g1.andThen(f1);
        System.out.println("f1g1(2) = " + f1g1.apply(2.0));

        // f2(x) = sin(x), g2(x) = (1 - x) / (1 + x^2)
        Function<Double, Double> f2 = Math::sin;
        Function<Double, Double> g2 = x -> (1 - x) / (1 + x * x);
        Function<Double, Double> f2g2 = g2.andThen(f2);
        System.out.println("f2g2(1) = " + f2g2.apply(1.0));

        // f3(x) = (1 - sin(x)) / (1 + 2x^2), g3(x) = cos(x)
        Function<Double, Double> f3 = x -> (1 - Math.sin(x)) / (1 + 2 * x * x);
        Function<Double, Double> g3 = Math::cos;
        Function<Double, Double> f3g3 = g3.andThen(f3);
        System.out.println("f3g3(0) = " + f3g3.apply(0.0));
    }
}
