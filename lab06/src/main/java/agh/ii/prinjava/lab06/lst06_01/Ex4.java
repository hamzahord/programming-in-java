package agh.ii.prinjava.lab06.lst06_01;

public class Ex4 {
    FunIf<String, Integer> f1 = s -> s.length();
    FunIf<Integer, String> f2 = i -> "Value: " + i;
    FunIf<Double, Double> f3 = Math::abs;
    FunIf<Integer, Boolean> f4 = i -> i > 0;
    FunIf<Boolean, Integer> f5 = b -> b ? 1 : 0;
    FunIf<Boolean, Boolean> f6 = b -> !b;

}

@FunctionalInterface
interface FunIf<T, R> {
    R apply(T t);
}

