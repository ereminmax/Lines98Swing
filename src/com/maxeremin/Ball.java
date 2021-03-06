package com.maxeremin;

import java.awt.*;
import java.util.Random;

public class Ball {
    Random random = new Random();

    public static final int EMPTY = 0;
    public static final int FUTURE_BALL = 1;
    public static final int NEW_BALL = 2;
    public static final int INACTIVE_BALL = 3;
    public static final int ACTIVE_BALL = 4;
    public static final int MARKED_FOR_REMOVE = 5;
    public static final int REMOVING = 6;

    public static final Color [] colArr = {
            new Color(255, 0, 0),   new Color(0, 255, 0),
            new Color(0, 100, 255), new Color(255, 255, 0),
            new Color(255, 0, 255), new Color(0, 255, 255)
    };

    private int ballColor;
    int ballState;
    int ballSize;

    private int animationStep=0;
    private int dir=1;

    Ball (int state, int color){
        this.ballState=state;
        this.ballColor=color;
    }

    public Ball() {
    }

    public Ball(int state) {
        this.ballState=state;
        this.ballColor = random.nextInt(colArr.length);
    }

    public boolean isBallExist() {
            return ( ballState == NEW_BALL
                    | ballState == ACTIVE_BALL
                    | ballState == INACTIVE_BALL
                    | ballState == MARKED_FOR_REMOVE);
    }


    public int getColor(){
        return ballColor;
    }

    public Color getBallColor(){
        return colArr[getColor()];
    }


    public void porcessBalls(){

        switch(ballState){

            case FUTURE_BALL:
                ballSize=30;
                break;

            case NEW_BALL:
                ballSize++;

                if (ballSize == 100) ballState = INACTIVE_BALL;
                break;

            case MARKED_FOR_REMOVE:
                ballState = REMOVING;
                break;

            case REMOVING:
                if (ballSize > 0) ballSize--;
                else if (ballSize == 0) ballState = EMPTY;
                break;

            case ACTIVE_BALL:
                if (animationStep>15) {
                    dir=-1;
                } else if (animationStep<-15) {
                    dir=1;
                }
                animationStep+=dir;
                ballSize = 100 +animationStep;
                break;

            case INACTIVE_BALL:
                if (ballSize>100) ballSize--;
                if (ballSize<100) ballSize++;
                break;

            default:
                ballSize=100;
        }
    }
}
