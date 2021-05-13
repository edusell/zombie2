package gball;

/*
 * File: RunnableGBall.java
 * ------------------------
 * This file defines an extension to the GBall class that is
 * designed to run as a separate thread of control.
 */

import acm.graphics.GImage;

public class RunnableGBall extends GBall implements Runnable {

    private GImage emoji;

    /** Creates a new ball with radius r centered at the origin */
    public RunnableGBall(boolean huma) {
        emoji = GBall(huma);
        emoji.setSize(50,50);
        add(emoji,-20,-20);
        
    }


    /** Sets the size of the enclosure */
    public void setEnclosureSize(double width, double height) {
        enclosureWidth = width;
        enclosureHeight = height;
        dx = vel();
        dy = vel();

    }

    /** Run forever bouncing the ball */
    public void run() {
        while (true) {
            advanceOneTimeStep();
            pause(PAUSE_TIME);
        }
    }

    /** Check for bounces and advance the ball */
    private void advanceOneTimeStep() {
        double bx = getX();
        double by = getY();
        double r = getWidth() / 2;
        if (bx < r || bx > enclosureWidth - r) dx = -dx;
        if (by < r || by > enclosureHeight - r) dy = -dy;
        move(dx, dy);

     }

     public void setzombie(){
        emoji.setImage(".\\src\\gball\\zombie.png");
        emoji.setSize(50,50);
    }

    public static int vel(){
        int num=0;
        while(num ==0) {
            num = (int) (Math.random() * 10 - 5);
        }
        return num;
    }

    /* Private constants */
    private static final int PAUSE_TIME = 50;

    /* Private instance variables */
    private double enclosureWidth;
    private double enclosureHeight;
    private double dx;
    private double dy;

}
