package ua.opnu;

/**
 * Допоміжні методи для гри
 */
public class GameUtils {

    /**
     * Повертає:
     *  1  - якщо виграв player
     *  0  - нічия
     * -1  - якщо виграв computer
     */
    public static int checkWinner(GameShape player, GameShape computer) {
        if (player == null || computer == null) throw new IllegalArgumentException("Shapes can't be null");

        if (player.getClass() == computer.getClass()) return 0;

        if (player instanceof Rock && computer instanceof Scissors
                || player instanceof Scissors && computer instanceof Paper
                || player instanceof Paper && computer instanceof Rock) {
            return 1;
        } else {
            return -1;
        }
    }
}
