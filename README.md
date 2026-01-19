# Лабораторная работа №3 ЯП Java
**Шурманов Демид**

**Группа ИТ-9-2024 (2 курс)**

**Вариант №3**

---

# Тема: ОБЪЕКТНО-ОРИЕНТИРОВАННОЕ ПРОГРАММИРОВАНИЕ. ПАКЕТЫ.
**В коде класса `Main` импортированы пакеты каждой задачи:**
```java
package shurmanov.main;
import shurmanov.math.Degree;
import shurmanov.birds.BirdsTest;
import shurmanov.human.Human;
import shurmanov.human.Name;
import shurmanov.points.Point;
import shurmanov.points.Point2;
import shurmanov.route.Route;
```
**Реализовано удобное меню для выбора задачи:**
```java
System.out.println("=== Меню ===");
System.out.println("1 — Задание 1 (Имена)");
System.out.println("2 — Задание 2 (Человек)");
System.out.println("3 — Задание 3 (Маршрут)");
System.out.println("4 — Задание 4 (Точка)");
System.out.println("5 — Задание 5 (Птицы)");
System.out.println("6 — Трехмерная точка");
System.out.println("7 — Степень ");

```


Также предусмотрено предупреждение о неверном вводе пользователем.

---

# Задание 1 (№7-8):

**Формулировка:**  
```
№7 Непустые Имена.
Измените сущность Имя из задачи 1.4.5. Гарантируйте, что:
 Как минимум один параметр будет иметь не null значение и не пустую строку.
 Имя неизменяемо.
Продемонстрируйте работоспособность решения на примерах.
```
```
№8 Человек меняется.
Измените сущность Человек из задачи 1.4.6. Новые требования включают:
 Рост человека всегда положительный и не более 500, его можно изменить и получить в
любой момент.
 Отца возможно задать только при создании и в дальнейшем он не изменяется, но его
можно получить
 Имя можно получить в любой момент в виде объекта типа Имя.
Продемонстрируйте работоспособность решения на примерах.
```

## Пакет `Human` 

Для логического объединения классов используем пакет `Human`. 

Пакет содержит класс `Name` c указанием пакета `Human`:
```java
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
```

---

## Описание класса `Name`

Класс `Name` хранит три свойства:  

| Поле | Тип | Описание |
|------|-----|----------|
| `lastName` | `String` | Фамилия человека |
| `firstName` | `String` | Имя человека |
| `middleName` | `String` | Отчество человека |

Каждое поле может быть `null`, если значение не указано.  

---

## Конструкторы

**Упрощённые конструкторы (перегрузка)**
```java
public Name(String firstName) {
    this(null, firstName, null);
}

public Name(String lastName, String firstName) {
    this(lastName, firstName, null);
}
```

Позволяют создавать имя:
- только по личному имени
- по фамилии и имени

## Вспомогательные методы
**Проверка на пустоту**
```java
public static boolean isEmpty(String s) {
    return s == null || s.isEmpty();
}
```
Используется для централизованной проверки строк.

**Нормализация значений**
```java
private static String normalize(String s) {
    return isEmpty(s) ? null : s;
}
```
Преобразует пустые строки в null, обеспечивая единый формат хранения данных.

---
## Геттеры 
```
Геттеры
- getLastName() — возвращает фамилию
- getFirstName() — возвращает имя
- getMiddleName() — возвращает отчество

```
Таким образом, класс защищает себя от присвоения пустых значений полям.

---

## Метод toString
```java
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
```
**Метод формирует строку:**
- только из заданных частей имени
- без лишних пробелов
- в корректном порядке
## Примеры вывода:
```
Клеопатра
Пушкин Александр Сергеевич
Маяковский Владимир
```


- Пропускает null поля, чтобы не оставлять лишних пробелов.
- Позволяет красиво отображать объект при выводе.
  
---

## Метод тестирования test
**Для демонстрации работы реализован метод test():**
```java
public static void test(){
    System.out.println("Имена: ");

    Name name1 = new Name(null, "Клеопатра", null);
    Name name2 = new Name("Пушкин", "Александр", "Сергеевич");
    Name name3 = new Name("Маяковский", "Владимир", null);
//  Name name4 = new Name(null , "", "");

    System.out.println("1-ое имя: " + name1);
    System.out.println("2-ое имя: " + name2);
    System.out.println("3-ое имя: " + name3);
}
```
Последний вариант закомментирован, так как он приводит к выбросу исключения.

## Тесты
Ожидаемый вывод:
```
Имена: 
1-ое имя: Клеопатра
2-ое имя: Пушкин Александр Сергеевич
3-ое имя: Маяковский Владимир
```
При попытке создать полностью пустое имя:
```java
IllegalArgumentException: Хотя бы одно из полей должно быть задано
```

## Класс `Human`

**Проектирование сущности**

В классе используются следующие поля:
```java
private final Name name;   
private int height;  
private final Human father;
```
```
name — объект класса Name (ФИО человека)
height — рост человека
father — ссылка на отца
```
Поля name и father объявлены как final, что делает личность человека и его происхождение неизменяемыми после создания.

## Конструктор класса
```java
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
```

В конструкторе реализована строгая валидация:
- рост должен быть в диапазоне 1–500
- имя не может быть null

При нарушении условий выбрасывается IllegalArgumentException.


## Геттеры
```java
public Name getName() {
    return name;
}

public int getHeight() {
    return height;
}

public Human getFather() {
    return father;
}
```
Используются для доступа к данным, в том числе в других классах пакета.

## Сеттер роста
```java
public void setHeight(int height) {
    if (height <= 0 || height > 500) {
        throw new IllegalArgumentException("Рост не может быть отрицательным, нулевым и >500");
    }
    this.height = height;
}
```

Позволяет изменять рост человека, сохраняя ограничения.

## Переопределение метода `toString()`
```java
@Override
public String toString() {
    return this.name + ", рост: " + this.height;
}
```

Метод возвращает строковое представление человека в формате:
```
Фамилия Имя Отчество, рост: N
```
Формирование ФИО происходит внутри класса Name.

## Реализация тестирования
Для проверки работы реализован метод `test()`:
```java
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

//  human1.setHeight(501);
}
```

Здесь:
- создаются три имени
- создаются три человека
- формируется цепочка отцов
- демонстрируется вывод строкового представления
- закомментирован пример некорректного изменения роста

## Тесты
Ожидаемый вывод:
```
Чудов Иван, рост: 152
Чудов Петр, рост: 167
Борис, рост: 189
```
При попытке создать человека с некорректным ростом:
```java
IllegalArgumentException: Рост не может быть отрицательным, нулевым и >500
```
## Связь с классом Name
Класс Human использует сущность Name как обязательный компонент:
```java
private final Name name;
```
Это обеспечивает:

- разделение ответственности
- повторное использование кода
- строгую объектную модель
- удобное расширение логики работы с ФИО
---

# Задание 2 (№5):

**Формулировка:**  
```
Необходимо реализовать сущность Маршрут, которая:
- хранит начало и конец маршрута
- не допускает null значений
- может возвращать путь в виде массива строк
- может быть приведена к строковому виду
- корректно обрабатывает случай, когда начало и конец совпадают
- сообщает, если маршрут неизвестен
```

## Пакет `Route` 

Для логического объединения классов используем пакет `Route`. 


## Проектирование сущности

В классе используются следующие поля:
```java
private String from;
private String to;
```
from — начальная точка маршрута

to — конечная точка маршрута

---

## Конструктор класса
```java
public Route(String from, String to) {
    if (from == null || to == null) {
        throw new IllegalArgumentException("Начало и конец маршрута не могут быть null");
    }
    this.from = from;
    this.to = to;
}
```

В конструкторе реализована проверка:

- начало маршрута не может быть null
- конец маршрута не может быть null

**При нарушении выбрасывается IllegalArgumentException.**


## Сеттеры
```java
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
```

Методы позволяют изменять маршрут, сохраняя защиту от некорректных данных.

---
## Геттеры 
```java
public String getFrom() {
    return from;
}

public String getTo() {
    return to;
}
```
Используются для получения текущих значений маршрута.

---

## Метод `getPath()`
```java
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
```
Метод возвращает массив строк, представляющий маршрут.

**Реализована логика:**
- если начало и конец совпадают — путь состоит из одной точки
- если маршрут заранее известен — возвращается фиксированный путь
- если маршрут неизвестен — возвращается пустой массив

## Переопределение метода `toString()`
```java
@Override
public String toString() {
    String[] path = getPath();
    if (path.length == 0) {
        return "Маршрут не найден";
    }
    return String.join(" -> ", path);
}
```
Метод:

- запрашивает путь через getPath()
- если путь не найден — сообщает об этом
- если найден — формирует строку вида:
```
F -> B -> C -> D
```
## Реализация тестирования
Для проверки работы реализован метод `test()`:
```java
public static void test() {

    Route route = new Route("F", "D");

    System.out.println(route);
    System.out.println(Arrays.toString(route.getPath()));

    route.setFrom("A");
    route.setTo("A");

    System.out.println(route);
}
```

Здесь:

- создаётся маршрут F → D
- выводится строковое представление
- выводится массив пути
- затем маршрут изменяется на A → A
- демонстрируется обработка случая, когда начало и конец совпадают

## Тесты
```
Ожидаемый вывод:
F -> B -> C -> D
[F, B, C, D]
A
```
---
# Задание 3 (№5):

**Формулировка:**  
```
Трехмерная точка.
Создайте такой подвид сущности Точка из задачи 1.1.1, которая будет иметь не две, а три
координаты на плоскости: X,Y,Z.
```

## Пакет `Points` 

Для логического объединения классов используем пакет `Points`. 

## Проектирование сущности

В классе используются следующие поля:
```java
private double x;
private double y;
private double z;
```
```
x — координата по оси X
y — координата по оси Y
z — координата по оси Z
```
---

## Конструктор класса
```java
public Point(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
}
```

Конструктор инициализирует точку в трёхмерном пространстве.

## Переопределение метода `toString()`
```java
@Override
public String toString() {
    return "{" + x + " ; " + y + " ; " + z + "}";
}
```
Метод возвращает координаты точки в формате:
```
{x ; y ; z}
```

Это делает вывод удобным для чтения и отладки.

## Реализация тестирования
Для демонстрации работы класса реализован метод `test()`:
```java
public static void test() {
    Point p1  = new Point(1, 2, 3);
    Point p2 = new Point(-1, 0, 5);
    Point p3 = new Point(0, 0, 0);

    System.out.println(p1);
    System.out.println(p2);
    System.out.println(p3);
}
```
Создаются три точки с разными координатами и выводятся в консоль.

## Тесты
Ожидаемый вывод программы:
```
{1.0 ; 2.0 ; 3.0}
{-1.0 ; 0.0 ; 5.0}
{0.0 ; 0.0 ; 0.0}
```
---
# Задание 4 (№3):

**Формулировка:**  
```
Необходимо создать сущность Птица, которая является корнем иерархии.
На её основе реализовать:
Воробья — поёт «чырык»
Кукушку — поёт «ку-ку» случайное количество раз (от 1 до 10)
Попугая — поёт текст, заданный при создании, выводя случайное количество первых символов
```

## Структура проекта
```
shurmanov.birds
│
├── Birds.java        (абстрактный класс)
├── Sparrow.java     (воробей)
├── Cuckoo.java      (кукушка)
├── Parrot.java      (попугай)
└── BirdsTest.java   (тестирование)
```
## Абстрактный класс Birds
```java
abstract class Birds {
    public abstract void sing();
}
```
**Класс Birds:**
- является корнем иерархии
- содержит абстрактный метод sing()
- определяет общее поведение для всех птиц
- Каждая конкретная птица обязана реализовать метод `sing()`.

**Класс Sparrow (Воробей)**
```java
class Sparrow extends Birds {
    @Override
    public void sing() {
        System.out.println("чырык");
    }
}
```
Особенности:

- наследуется от Birds
- при пении всегда выводит:
```
чырык
```

**Класс Cuckoo (Кукушка)**
```java
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
```

Особенности:

- количество повторений выбирается случайно (от 1 до 10)
- используется класс Random
- выводит, например:
```
ку-ку ку-ку ку-ку ку-ку
```

**Класс Parrot (Попугай)**
```java
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
```

Особенности:

- текст задаётся при создании объекта
- при пении выводится случайное количество первых символов строки
- минимум 1 символ, максимум — весь текст

Пример вывода:
```
При
Привет
П
Прив
```

## Полиморфизм
Все классы объединены общим типом `Birds`, что позволяет работать с ними одинаково:
```java
Birds bird = new Sparrow();
bird.sing();
```

При этом будет вызвана реализация конкретного класса.

## Тестирование (`BirdsTest`)

В тестовом классе создаются объекты разных птиц и вызывается метод `sing()`.

Пример:
```
Birds sparrow = new Sparrow();
Birds cuckoo = new Cuckoo();
Birds parrot = new Parrot("Привет, я попугай");

sparrow.sing();
cuckoo.sing();
parrot.sing();
```
---

# Задание 5 (№2):

**Формулировка:**  
```
Необходимо изменить сущность «Точка» таким образом, чтобы:
- две точки считались равными, если их координаты совпадают
- был переопределён метод equals()
- был переопределён метод hashCode()
- объект можно было клонировать
```

## Проектирование сущности
В классе используются поля:
```java
private final int x;
private final int y;
```
```
x — координата по оси X
y — координата по оси Y
```
поля сделаны final, так как состояние точки не должно изменяться

## Реализация интерфейса `Cloneable`
```java
public class Point2 implements Cloneable
```

Интерфейс `Cloneable` указывает, что объект можно клонировать.

## Полиморфизм
Все классы объединены общим типом `Birds`, что позволяет работать с ними одинаково:
```java
Birds bird = new Sparrow();
bird.sing();
```

## Конструктор
```java
public Point2(int x, int y) {
    this.x = x;
    this.y = y;
}
```

Создаёт точку с заданными координатами.

При этом будет вызвана реализация конкретного класса.

## Метод `clone()`
```java
@Override
public Point2 clone() {
    return new Point2(this.x, this.y);
}
```
Метод создаёт новый объект с теми же координатами.

**Таким образом:**
- возвращается новый объект
- координаты полностью копируются
- изменение одного объекта не влияет на другой


## Переопределение `toString()`
```java
@Override
public String toString() {
    return "(" + x + "," + y + ")";
}
```

Формирует строковое представление точки:
```
(3,5)
```

## Переопределение `equals()`
```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;

    Point2 other = (Point2) obj;
    return x == other.x && y == other.y;
}
```

Точки считаются равными, если:
- объект не null
- принадлежит тому же классу
- их координаты x и y совпадают

Сравнение происходит по состоянию объекта, а не по ссылке.

## Переопределение `hashCode()`
```java
@Override
public int hashCode() {
    return 31 * x + y;
}
```
Метод реализован в соответствии с `equals()`, что обеспечивает:

- корректную работу в HashSet, HashMap и других коллекциях
- соблюдение контракта equals/hashCode

## Тестирование
```java
public static void test() {
    Point2 p1 = new Point2(3, 5);
    Point2 p2 = new Point2(25, 6);
    Point2 p3 = new Point2(7, 8);
    Point2 p4 = new Point2(3, 5);

    System.out.println(p1);
    System.out.println(p2);
    System.out.println(p3);

    System.out.println("p1 == p4 : " + (p1 == p4));
    System.out.println("p1 equals p4 : " + p1.equals(p4));
}
```

## Результат работы
**Пример вывода:**
```
(3,5)
(25,6)
(7,8)
p1 == p4 : false
p1 equals p4 : true
```
Пояснение:

- == сравнивает ссылки → объекты разные
- `equals()` сравнивает координаты → точки равны

---








