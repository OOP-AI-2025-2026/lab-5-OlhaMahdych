package ua.opnu;

import java.util.Random;

public class ShapeFactory {
    private static final Random RANDOM = new Random();

    public static GameShape generateShape() {
        int r = RANDOM.nextInt(3);
        return switch (r) {
            case 0 -> new Rock();
            case 1 -> new Paper();
            default -> new Scissors();
        };
    }
}
