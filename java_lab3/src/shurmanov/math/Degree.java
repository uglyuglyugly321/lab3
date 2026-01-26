package shurmanov.math;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Degree {

    // Метод принимает строки и возвращает X^Y
    public static double test(String x, String y) {
        int X = parseInt(x);
        int Y = parseInt(y);
        return pow(X, Y);
    }
}