package agh.ii.prinjava.lab06.lst06_04;

import java.util.Arrays;
import java.util.function.Function;

public class Main2 {
    public static void main(String[] args) {
        Function<Double, Double> f1 = x -> x * 2.0;
        Function<Double, Double> f2 = x -> x + 1.0;
        Function<Double, Double> f3 = x -> x * x;

        Function<Double, Double> composition = FunctionComposition.compose(Arrays.asList(f1, f2, f3));

        System.out.println("Composition result: " + composition.apply(2.0));
    }
}
