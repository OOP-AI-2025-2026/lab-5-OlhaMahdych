package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener {

    public MainFrame(String title) throws HeadlessException {
        super(title);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        JButton rockButton = new JButton("Камінь");
        rockButton.addActionListener(this);
        rockButton.setActionCommand("rock");

        JButton paperButton = new JButton("Папір");
        paperButton.addActionListener(this);
        paperButton.setActionCommand("paper");

        JButton scissorsButton = new JButton("Ножиці");
        scissorsButton.addActionListener(this);
        scissorsButton.setActionCommand("scissors");

        this.add(rockButton);
        this.add(paperButton);
        this.add(scissorsButton);

        this.pack();
        this.setVisible(true);
    }

    /**
     * Метод generateShape() повертає випадкову фігуру (камінь, папір або ножиці)
     */
    private GameShape generateShape() {
        int random = new Random().nextInt(3); // 0, 1 або 2

        switch (random) {
            case 0:
                return new Rock();
            case 1:
                return new Paper();
            case 2:
                return new Scissors();
            default:
                return new Rock();
        }
    }

    /**
     * Метод checkWinner() порівнює фігури гравця та комп’ютера
     */
    private int checkWinner(GameShape player, GameShape computer) {
        if (player.getClass() == computer.getClass()) {
            return 0; // нічия
        }

        if (player instanceof Rock && computer instanceof Scissors
                || player instanceof Scissors && computer instanceof Paper
                || player instanceof Paper && computer instanceof Rock) {
            return 1; // виграв гравець
        } else {
            return -1; // виграв комп’ютер
        }
    }

    /**
     * Обробка натискання кнопок
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Генерується хід комп'ютера
        GameShape computerShape = generateShape();

        GameShape playerShape = null; // створюємо змінну для фігури гравця

        // Визначаємо, яку кнопку натиснув користувач
        switch (e.getActionCommand()) {
            case "rock":
                playerShape = new Rock();
                break;
            case "paper":
                playerShape = new Paper();
                break;
            case "scissors":
                playerShape = new Scissors();
                break;
        }

        // Визначити результат гри
        int gameResult = checkWinner(playerShape, computerShape);

        // Формуємо повідомлення
        String message = "Гравець: " + playerShape + "\nКомп’ютер: " + computerShape + "\n";

        switch (gameResult) {
            case -1 -> message += "Виграв комп’ютер!";
            case 0 -> message += "Нічия!";
            case 1 -> message += "Виграв гравець!";
        }

        // Показуємо діалогове вікно з результатом
        JOptionPane.showMessageDialog(this, message);
    }
}
