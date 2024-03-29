package agh.ii.prinjava.lab05.lst05_04;

import java.util.*;

/**
 * <p>{@link Comparable} interface imposes a total order on the objects of each class that implement it.
 * This ordering is referred to as the class's <i>natural order</i>, and the class's compareTo method is referred
 * to as its natural comparison method.
 *
 * <p>Lists (and arrays) of objects that implement this interface can be sorted automatically
 * by {@link Collections#sort} (and {@link Arrays#sort}).
 * Objects that implement this interface can be used as keys in a sorted map or as elements in a sorted set,
 * without the need to specify a comparator.
 * It is strongly recommended (though not required) that the natural order be consistent with equals.
 *
 * <p>{@link Comparator} - a comparison interface (function), which imposes a total order on a collection of objects.
 * Comparators can be passed to a sort method (such as {@link Collections#sort} or {@link Arrays#sort})
 * to allow precise control over the sort order.
 * Comparators can also be used to control the order of certain data structures (such as sorted sets or sorted maps),
 * or to provide an order for collections of objects that don't have a natural order.
 *
 * <p>The order imposed by a comparator {@code c} on a set of elements {@code S} is said to be consistent
 * with {@link #equals} if and only if:
 * <ul>
 *     <li>{@code c.compare(e1, e2) == 0}</li>
 *     <li>{@code e1.equals(e2)}</li>
 * </ul>
 * have the same boolean values for every {@code e1} and {@code e2} in {@code S}.
 *
 * <p><i>Note</i>: comparing elements using the {@link Comparable} interface is referred to as comparing using natural order,
 * and comparing elements using the {@link Comparator} interface is referred to as comparing using comparator.
 *
 * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Comparable.html">Comparable</a>
 * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Comparator.html">Comparator</a>
 */
public class Main {

    private static final List<Integer> LST = List.of(3, 1, 2, 1, 7, 4);

    private static void fillTheListOfBox1(List<Box1<Integer>> elems) {
        for (var e : LST) {
            elems.add(new Box1<>(e));
        }
    }

    private static void fillTheListOfBox2(List<Box2<Integer>> elems) {
        for (var e : LST) {
            elems.add(new Box2<>(e));
        }
    }

    static Object max(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            if (c1.compareTo(c2) >= 0) {
                return o1;
            } else {
                return o2;
            }
        } else {
            throw new IllegalArgumentException("Both objects must implement Comparable");
        }
    }

    private static void m() {
        String[] cities = {"Copenhagen", "Warsaw", "Budapest"};
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s2.length(), s1.length());
            }
        };
        Arrays.sort(cities, comparator);
        System.out.println(Arrays.toString(cities));
    }




    /**
     * {@link Comparable} application example
     */
    private static void demo1() {
        System.out.println("demo1...");
        List<Box1<Integer>> boxes = new ArrayList<>();
        fillTheListOfBox1(boxes);
        System.out.println("boxes = " + boxes);

        Box1<Integer> b1 = boxes.get(1);
        Box1<Integer> b3 = boxes.get(3);

        System.out.println("b1 = " + b1 + ", b2 = " + b3 + ", b1.compareTo(b2) = " + b1.compareTo(b3));

        Collections.sort(boxes);
        System.out.println("After sorting\nboxes = " + boxes);
    }

    /**
     * {@link Comparator} application example
     * <p>Be careful:
     * <ul>
     *     <li>{@code Comparable<T> -> int compareTo(T o)}</li>
     *     <li>{@code Comparator<T> -> int compare(T o1, T o2)}</li>
     * </ul>
     * <p>
     * Compare to {@code bool operator==(T o1, T o2)} in C++, global function vs. a method
     */
    private static void demo2() {
        System.out.println("\ndemo2...");
        List<Box2<Integer>> boxes = new ArrayList<>();
        fillTheListOfBox2(boxes);
        System.out.println("boxes = " + boxes);

        Box2<Integer> b1 = boxes.get(1);
        Box2<Integer> b3 = boxes.get(3);

        // The following three comparator definitions are equivalent:
        // (1) | warning: Anonymous new Comparator<Box2<Integer>>() can be replaced with lambda
        Comparator<Box2<Integer>> box2Cmp1 = new Comparator<Box2<Integer>>() {
            @Override
            public int compare(Box2<Integer> o1, Box2<Integer> o2) {
                return Integer.compare(o1.e(), o2.e());
            }
        };

        // (2) | warning: the following can be replaced with 'Comparator.comparingInt'
        Comparator<Box2<Integer>> box2Cmp2 = (o1, o2) -> Integer.compare(o1.e(), o2.e());

        // (3)
        Comparator<Box2<Integer>> box2Cmp3 = Comparator.comparingInt(Box2::e);

        // And, finally, an explicit instance of a "named" Box2Comparator class
        Box2Comparator<Integer> box2Cmp4 = new Box2Comparator<>();

        System.out.println("b1 = " + b1 + ", b2 = " + b3 + ", cmp.compare(b1, b3) = " + box2Cmp3.compare(b1, b3));

        //Collections.sort(boxes, box2Cmp1); // (*)
        //Collections.sort(boxes, box2Cmp2); // as in (*)
        //Collections.sort(boxes, box2Cmp3); // as in (*)
        Collections.sort(boxes, box2Cmp4);   // as in (*)

        System.out.println("After sorting\nboxes = " + boxes);
    }

    public static void main(String[] args) {
        demo1();
        demo2();
    }
}

record Box1<T extends Comparable<T>>(T e) implements Comparable<Box1<T>> {
    @Override
    public int compareTo(Box1<T> that) {
        return e.compareTo(that.e);
    }
}

/**
 * Note {@link Box2} does not implement {@link Comparable}
 * <p>The use of {@link Comparator} will be necessary in some scenarios (e.g. sorting)
 */
record Box2<T>(T e) {
    @Override
    public int hashCode() {
        return Objects.hash(e);
    }
}

/**
 * Generic comparator for {@code Box2<T>}
 */
class Box2Comparator<T extends Comparable<T>> implements Comparator<Box2<T>> {
    @Override
    public int compare(Box2<T> o1, Box2<T> o2) {
        return o1.e().compareTo(o2.e());
    }

}
