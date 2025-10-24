package ua.opnu;

import ua.opnu.view.DrawFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new DrawFrame("Програма Draw"));
    }
}