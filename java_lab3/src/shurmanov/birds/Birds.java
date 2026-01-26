package shurmanov.birds;

import java.util.Random;

abstract class Birds {
    public abstract void sing();
}

class Sparrow extends Birds {
    @Override
    public void sing() {
        System.out.println("чырык");
    }
}

class Cuckoo extends Birds {
    private final Random random = new Random();

    @Override
    public void sing() {
        int x = random.nextInt(10) + 1;
        for (int i = 0; i < x; i++) {
            System.out.print("ку-ку ");
        }
        System.out.println();
    }
}

class Parrot extends Birds {
    private final String text;
    private final Random random = new Random();

    public Parrot(String text) {
        this.text = text;
    }

    @Override
    public void sing() {
        int n = random.nextInt(text.length()) + 1;
        System.out.println(text.substring(0, n));
    }
}

