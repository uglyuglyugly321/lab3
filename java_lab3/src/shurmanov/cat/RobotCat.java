package shurmanov.cat;

public class RobotCat implements Meowable {
    private String model;

    public RobotCat(String model) {
        this.model = model;
    }

    @Override
    public void meow() {
        System.out.println(model + " : робо-мяу!");
    }
}
