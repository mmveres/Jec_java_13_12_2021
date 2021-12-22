package ua.univer.lesson05;

import ua.univer.lesson03.kmda.User;

import java.util.*;
import java.util.function.BiFunction;

//@FunctionalInterface
//interface Calc {
//    int oper(int x, int y);
//
//}
public class Program {
    //    public static int sum(int x, int y){
//        return x+y;
//    }
//    public static int multi(int x, int y){
//        return x*y;
//    }
//    public static int sub(int x, int y){
//        return x-y;n
//    }
    public static void main(String[] args) {
        //   testLambda();
        List<Integer> integers = Arrays.asList(1, 2, 4, 5, 12, 3, 3, 45, 3, 5, 43);
        Collections.sort(integers);
        System.out.println(integers);

        List<User> users = Arrays.asList(
                new User("A2", "Manager3", 150),
                new User("A1", "Manager4", 120),
                new User("A4", "Manager1", 100),
                new User("A3", "Manager4", 110)
        );
        Collections.sort(users, Comparator
                .comparing(User::getPosition)
                .reversed()
                .thenComparingDouble(User::getSalary));

        System.out.println(users);
        Collections.sort(users, (o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()));
        System.out.println(users);
        users.sort(Comparator.comparingDouble(User::getSalary));
    }

    private static void testLambda() {
        int a = 10;
        int b = 20;
        BiFunction<Integer, Integer, Integer> calcSum = (x, y) -> x + y;
        BiFunction<Integer, Integer, Integer> calcMulti = (x, y) -> x * y;
        BiFunction<Integer, Integer, Integer> calcDiv = (x, y) -> x - y;

        System.out.println(calcSum.apply(a, b));
        System.out.println(calcMulti.apply(a, b));
        System.out.println(calcDiv.apply(a, b));

        System.out.println(calcSum.apply(calcMulti.apply(a, b), calcDiv.apply(a, b)));

        List<String> list = new ArrayList<String>();
        list.add("apple");
        list.add("pear");
        list.add("orange");
        list.add("strawberries");
        list.forEach(
                (n) -> System.out.println(n)
        );
    }
}
