package agh.ii.prinjava.lab06.lst06_01;

import java.util.function.DoubleUnaryOperator;

public class Ex3 {
    // sqrt(x)
    DoubleUnaryOperator sqrt = x -> Math.sqrt(x);

    // abs(x)
    DoubleUnaryOperator abs = x -> Math.abs(x);

    // log(x)
    DoubleUnaryOperator log = x -> Math.log(x);

    // id(x)
    DoubleUnaryOperator id = x -> x;

}
