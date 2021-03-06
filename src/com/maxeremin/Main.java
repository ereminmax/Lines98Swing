package com.maxeremin;

import javax.swing.*;

public class Main extends JFrame {

    private Main() {
        int width = Game.widthSize* Render.SCALE;
        int height= Game.heightSize* Render.SCALE;
        Game game = new Game();
        add(new Render(game, width, height));

        setTitle("Lines");
        setSize(width+18, height+38);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main ms = new Main();
                ms.setVisible(true);
            }
        });
    }
}