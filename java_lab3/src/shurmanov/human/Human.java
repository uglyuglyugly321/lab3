package shurmanov.human;

public class Human {
    private final Name name;   // Фамилия
    private int height;  // Имя
    private final Human father;

    public Human(Name name, int height, Human father) {
        if (height <= 0 || height > 500) {
            throw new IllegalArgumentException("Рост не может быть отрицательным, нулевым и >500");
        }
        if (name == null) {
            throw new IllegalArgumentException("Имя не может пустым");
        }
        this.name = name;
        this.height = height;
        this.father = father;

    }
    public Name getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 0 || height > 500) {
            throw new IllegalArgumentException("Рост не может быть отрицательным, нулевым и >500");
        }
        this.height = height;


    }

    public Human getFather() {
        return father;
    }
    @Override
    public String toString() {
        return this.name + ", рост: " + this.height;
    }

    public static void test() {

        Name nameIvan = new Name("Чудов", "Иван", null);
        Name namePetr = new Name("Чудов", "Петр", null);
        Name nameBoris = new Name(null, "Борис", null);

        Human human1 = new Human(nameIvan, 152, null);
        Human human2 = new Human(namePetr, 167, human1);
        Human human3 = new Human(nameBoris, 189, human2);


        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);

//        human1.setHeight(501);
//        System.out.println(human1);
    }
}
