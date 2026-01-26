package shurmanov.cat;

public class Cat implements Meowable {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println(name + " : мяу!");
    }

    public void meow(int n) {
        if (n <= 0) return;
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < n; i++) {
            sb.append("мяу");
            if (i != n - 1) sb.append("-");
        }
        System.out.println(sb);
    }

    @Override
    public String toString() {
        return "кот " + name;
    }

    public class MeowUtils {
        public static void makeThemMeow(Meowable[] animals) {
            for (Meowable animal : animals) {
                animal.meow();
            }
        }
    }

    public static void test() {
        Cat cat1 = new Cat("Барсик");
        cat1.meow();
        cat1.meow(3);

        System.out.println();

        Meowable[] animals = {
                new Cat("Васька"),
                new Cat("Пушок"),
                new RobotCat("Робокот")
        };

        MeowUtils.makeThemMeow(animals);
    }



}


