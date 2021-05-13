package gball;

/*
 * File: GBall.java
 * ----------------
 * This file defines a GObject class that represents a ball.
 */

import acm.graphics.*;

/**
 * This class defines a GObject subclass that represents a ball
 * whose reference point is the center rather than the upper
 * left corner.
 */
public class GBall extends GCompound {

    /** Creates a new ball with radius r centered at the origin */
    public GImage GBall(boolean huma) {
        GImage jug;
        if (huma) {
            switch (rand()){
                case 1:
                    jug = new GImage(".\\src\\gball\\emoji1.png");
                    break;

                case 2:
                    jug = new GImage(".\\src\\gball\\emoji2.png");
                    break;

                case 3:
                    jug = new GImage(".\\src\\gball\\emoji3.png");
                    break;

                case 4:
                    jug = new GImage(".\\src\\gball\\emoji4.png");
                    break;

                case 5:
                    jug = new GImage(".\\src\\gball\\emoji5.png");
                    break;
                default:
                    jug = new GImage(".\\src\\gball\\emoji1.png");
                    break;
            }
        } else {
        
            jug = new GImage(".\\src\\gball\\zombie.png");
        }
        jug.setSize(50,50);
        return jug;
    }
    public static int rand(){
        return (int)(Math.random()*5 +1);
    }

}
