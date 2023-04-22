package agh.ii.prinjava.lab06.lst06_01;

public class Ex5 {
    FunIf<String, Integer> f1 = String::length;
    FunIf<Integer, String> f2 = Object::toString;
    FunIf<Double, Double> f3 = Math::abs;
    FunIf<Integer, Boolean> f4 = i -> i > 0;
    FunIf<Boolean, Integer> f5 = b -> b ? 1 : 0;
    FunIf<Boolean, Boolean> f6 = b -> !b;

}
