package shurmanov.main;

import shurmanov.math.Degree;
import shurmanov.birds.BirdsTest;
import shurmanov.human.Human;
import shurmanov.human.Name;
import shurmanov.points.Point;
import shurmanov.points.Point2;
import shurmanov.route.Route;
import shurmanov.cat.Cat;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Меню ===");
            System.out.println("1 — Задание 1 (Имена)");
            System.out.println("2 — Задание 2 (Человек)");
            System.out.println("3 — Задание 3 (Маршрут)");
            System.out.println("4 — Задание 4 (Точка)");
            System.out.println("5 — Задание 5 (Птицы)");
            System.out.println("6 — Трехмерная точка");
            System.out.println("7 — Степень ");
            System.out.println("8 — Кот ");

            System.out.println("0 — Выход");
            System.out.print("Выберите пункт: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> Name.test();
                case 2 -> Human.test();
                case 3 -> Route.test();
                case 4 -> Point.test();
                case 5 -> BirdsTest.test();
                case 6 -> Point2.test();
                case 7 -> {
                    System.out.println("Введите x: ");
                    String x = sc.nextLine();

                    System.out.println("Введите y: ");
                    String y = sc.nextLine();

                    double result = Degree.test(x, y);
                    System.out.println(x + " ^ " + y + " = " + result);

                }
                case 8 -> Cat.test();

                case 0 -> System.out.println("Выход...");
                default -> System.out.println("Неверный ввод!");
            }
        } while (choice != 0);
    }
}