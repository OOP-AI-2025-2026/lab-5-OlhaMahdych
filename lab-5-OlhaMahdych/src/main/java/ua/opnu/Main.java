package ua.opnu;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Перевантаження методів (TimeSpan) =====");
        TimeSpan t1 = new TimeSpan(1, 30);
        TimeSpan t2 = new TimeSpan(45);
        TimeSpan t3 = new TimeSpan(t1);

        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
        System.out.println("t3 = " + t3);

        t1.add(0, 40);
        System.out.println("t1 + 40 хв = " + t1);

        t1.subtract(t2);
        System.out.println("t1 - t2 = " + t1);

        System.out.println("\n===== Ланцюжок успадкування =====");
        Person[] people = {
                new Person("Петренко", "Іван", 40),
                new Student("Іваненко", "Марія", 20, "КН-23", "12345"),
                new Lecturer("Сидоренко", "Олег", 50, "Комп’ютерних наук", 25000)
        };

        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}
