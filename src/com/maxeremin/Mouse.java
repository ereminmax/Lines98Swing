package com.maxeremin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

    private int x;
    private int y;
    Game game;

    public Mouse(Game game){
        this.game = game;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        // Get coordinates of selected cell
        x = e.getX()/Render.SCALE;
        y = e.getY()/Render.SCALE;
        // Make a ball active if the cell contains the ball
        game.cellSelected(x,y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        // Get coordinates of selected cell
        x = e.getX()/Render.SCALE;
        y = e.getY()/Render.SCALE;
        // Make a ball active and move it to the destination
        game.makeMoveOrSelect(x, y);
    }

}
