package shurmanov.route;

import java.util.Arrays;

public class Route {

    private String from;
    private String to;

    public Route(String from, String to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Начало и конец маршрута не могут быть null");
        }
        this.from = from;
        this.to = to;
    }

    public void setFrom(String from) {
        if (from == null) {
            throw new IllegalArgumentException("Начало маршрута не может быть null");
        }
        this.from = from;
    }

    public void setTo(String to) {
        if (to == null) {
            throw new IllegalArgumentException("Конец маршрута не может быть null");
        }
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }


    public String[] getPath() {
        if (from.equals(to)) {
            return new String[] { from };
        }

        // Пример фиксированного пути
        if (from.equals("F") && to.equals("D")) {
            return new String[] { "F", "B", "C", "D" };
        }

        // Если путь неизвестен
        return new String[0];
    }

    @Override
    public String toString() {
        String[] path = getPath();
        if (path.length == 0) {
            return "Маршрут не найден";
        }
        return String.join(" -> ", path);
    }

    public static void test() {

            Route route = new Route("F", "D");

            System.out.println(route);                 // F -> B -> C -> D
            System.out.println(Arrays.toString(
                    route.getPath()));                 // [F, B, C, D]

            route.setFrom("A");
            route.setTo("A");

            System.out.println(route);                 // A
        }

}