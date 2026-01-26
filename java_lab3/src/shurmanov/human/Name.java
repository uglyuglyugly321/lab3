package shurmanov.human;

public class Name {
    private final String lastName;   // Фамилия
    private final String firstName;  // Имя
    private final String middleName; // Отчество

    public Name(String lastName, String firstName, String middleName) {


        if (isEmpty(firstName) && isEmpty(middleName) && isEmpty(lastName)) {
            throw new IllegalArgumentException(
                    "Хотя бы одно из полей должно быть задано"
            );
        }
        this.lastName = normalize(lastName);
        this.firstName = normalize(firstName);
        this.middleName = normalize(middleName);
    }

    public Name(String firstName) {
        this(null, firstName, null);
    }

    public Name(String lastName, String firstName) {
        this(lastName, firstName, null);
    }

    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    private static String normalize(String s) {
        return isEmpty(s) ? null : s;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (lastName != null)
            sb.append(lastName);

        if (firstName != null) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(firstName);
        }

        if (middleName != null) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(middleName);
        }

        return sb.toString();
    }

    public static void test(){
        System.out.println("Имена: ");

        Name name1 = new Name(null, "Клеопатра", null);
        Name name2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name name3 = new Name("Маяковский", "Владимир", null);
//        Name name4 = new Name(null , "", "");

        System.out.println("1-ое имя: " + name1);
        System.out.println("2-ое имя: " + name2);
        System.out.println("3-ое имя: " + name3);
//        System.out.println("4-ое имя : " + name4);
    }
}