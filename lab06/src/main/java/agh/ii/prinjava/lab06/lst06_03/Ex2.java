package agh.ii.prinjava.lab06.lst06_03;
import java.util.function.DoubleUnaryOperator;

public class Ex2 {
    public static void main(String[] args) {
        DoubleUnaryOperator f = expApproxUpTo(5);
        System.out.println(f.applyAsDouble(1)); // Output: 2.71666666666
    }

    static DoubleUnaryOperator expApproxUpTo(int n) {
        if (n < 0 || n >= 6) {
            throw new IllegalArgumentException("n must be between 0 and 5 inclusive");
        }

        return x -> {
            double result = 0;
            double term = 1;
            for (int k = 0; k <= n; k++) {
                result += term;
                term *= x / (k + 1);
            }
            return result;
        };
    }
}

