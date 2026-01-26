package shurmanov.birds;

public class BirdsTest {
    public static void test() {
        Birds sparrow = new Sparrow();
        Birds cuckoo = new Cuckoo();
        Birds parrot = new Parrot("Привет, я попугай!");

        sparrow.sing();
        cuckoo.sing();
        parrot.sing();
    }
}