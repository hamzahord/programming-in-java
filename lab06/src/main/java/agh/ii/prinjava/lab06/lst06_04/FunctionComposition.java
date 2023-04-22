package agh.ii.prinjava.lab06.lst06_04;
import java.util.List;
import java.util.function.Function;
import java.util.Arrays;

public class FunctionComposition {
    public static <T> Function<T, T> compose(List<Function<T, T>> functions) {
        if (functions.isEmpty()) {
            return Function.identity();
        } else if (functions.size() == 1) {
            return functions.get(0);
        } else {
            Function<T, T> composition = functions.get(0);
            for (int i = 1; i < functions.size(); i++) {
                composition = composition.andThen(functions.get(i));
            }
            return composition;
        }
    }
}

