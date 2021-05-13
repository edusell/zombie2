package gball;


import acm.graphics.GImage;
import acm.gui.IntField;
import acm.program.GraphicsProgram;

public class BouncingBallUsingThreads extends GraphicsProgram {


        public void init() {
            setSize(900,500);

            GImage fons =new GImage(".\\src\\gball\\fons.png");
            fons.setSize(900 ,500);
            add(fons,0,-10);
        }

        public void run() {
            try {
                while(true) {

                    IntField field = new IntField(10,2,200);
                    add(field, getWidth() / 2 - 50, getHeight() / 2 - 50);
                    field.setSize(100, 20);

                    GImage boto = new GImage(".\\src\\gball\\boto.png");
                    boto.setSize(200, 75);
                    add(boto, getWidth() / 2 - 100, getHeight() / 2);

                    waitForClick();

                    field.setVisible(false);
                    boto.setVisible(false);

                    int num = field.getValue();

                    RunnableGBall[] arr = new RunnableGBall[num];

                    arr[0] = new RunnableGBall(false);
                    arr[0].setEnclosureSize(getWidth() - 25, getHeight() - 25);
                    add(arr[0], posx(), posy());

                    for (int i = 1; i < arr.length; i++) {
                        arr[i] = new RunnableGBall(true);
                        arr[i].setEnclosureSize(getWidth() - 25, getHeight() - 25);
                        add(arr[i], posx(), posy());
                    }

                    for (int i = 0; i < arr.length; i++) {
                        new Thread(arr[i]).start();
                    }

                    boolean[] inf = new boolean[num];
                    inf[0] = true;
                    for (int i = 1; i < inf.length; i++) {
                        inf[i] = false;
                    }

                    int infect = 0;

                    while (infect != inf.length) {
                        infect = 0;
                        for (int i = 0; i < inf.length; i++) {
                            if (inf[i]) {
                                for (int o = 1; o < arr.length; o++) {
                                    if (arr[o].getBounds().intersects(arr[i].getBounds())) {
                                        if (!inf[o]) {
                                            inf[o] = true;
                                            arr[o].setzombie();

                                        }
                                    }
                                }
                            }
                        }
                        for (int i = 0; i < inf.length; i++) {
                            if (inf[i]) {
                                infect++;
                            }
                        }
                    }

                    for (int i = 0; i < arr.length; i++) {
                        arr[i].setVisible(false);
                        pause(5);
                    }

                    boto.setImage(".\\src\\gball\\boto1.png");
                    boto.setSize(200, 75);
                    boto.setVisible(true);
                    waitForClick();
                }
            }catch (Exception e){System.out.println(e);}

        }

        public static void main(String[] args) {

            new BouncingBallUsingThreads().start(args);
        }

        public static int posx(){
            return (int)(Math.random()*700 +50);
        }
        public static int posy(){
            return (int)(Math.random()*300 +50 );
        }
    }

