package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    // Конструктор без аргументів
    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    // Конструктор з 1 аргументом (хвилини)
    public TimeSpan(int minutes) {
        this.hours = minutes / 60;
        this.minutes = minutes % 60;
        normalize();
    }

    // Конструктор з 2 аргументами (години і хвилини)
    public TimeSpan(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        normalize();
    }

    // Конструктор копіювання
    public TimeSpan(TimeSpan other) {
        if (other == null) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = other.hours;
            this.minutes = other.minutes;
        }
    }

    // Гетери/сетери
    public int getHours() { return hours; }
    public int getMinutes() { return minutes; }
    public void setHours(int hours) { this.hours = hours; }
    public void setMinutes(int minutes) { this.minutes = minutes; normalize(); }

    // Додавання: хвилини
    public void add(int minutes) {
        this.minutes += minutes;
        normalize();
    }

    // Додавання: години і хвилини
    public void add(int hours, int minutes) {
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    // Додавання: TimeSpan
    public void add(TimeSpan other) {
        if (other == null) return;
        this.hours += other.hours;
        this.minutes += other.minutes;
        normalize();
    }

    // Віднімання: хвилини
    public void subtract(int minutes) {
        this.minutes -= minutes;
        normalize();
    }

    // Віднімання: години і хвилини
    public void subtract(int hours, int minutes) {
        this.hours -= hours;
        this.minutes -= minutes;
        normalize();
    }

    // Віднімання: TimeSpan
    public void subtract(TimeSpan other) {
        if (other == null) return;
        this.hours -= other.hours;
        this.minutes -= other.minutes;
        normalize();
    }

    // Нормалізація (minutes в межах 0..59). Якщо hours стає від'ємним — залишаємо 0:0
    private void normalize() {
        // Коректуємо хвилини, якщо >=60 або <0
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        } else if (minutes < 0) {
            int borrow = (Math.abs(minutes) + 59) / 60;
            hours -= borrow;
            minutes += borrow * 60;
        }
        if (hours < 0) { // не даємо від'ємного інтервалу
            hours = 0;
            minutes = 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%d год %d хв", hours, minutes);
    }
}
