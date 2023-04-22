package agh.ii.prinjava.lab06.lst06_03;
import java.util.function.DoubleUnaryOperator;

public class Ex3 {
    public static void main(String[] args) {
        DoubleUnaryOperator f = x -> Math.sin(x);
        DoubleUnaryOperator f2 = d2f(f, 23);
        System.out.println(f2.applyAsDouble(Math.PI));
    }

    static DoubleUnaryOperator d2f(DoubleUnaryOperator f, double h) {
        return x -> {
            double f1 = f.applyAsDouble(x - h);
            double f2 = f.applyAsDouble(x);
            double f3 = f.applyAsDouble(x + h);

            // Three-point central difference scheme
            double df = (f3 - f1) / (2 * h);
            double d2f = (f3 - 2 * f2 + f1) / (h * h);

            return d2f;
        };
    }
}
