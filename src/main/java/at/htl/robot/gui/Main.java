package at.htl.robot.gui;

import at.htl.robot.model.Robot;
import processing.core.PApplet;


public class Main extends PApplet {

    // Hier die Member-Attribute eintragen
    Robot robot = new Robot();
    private final int MAXROW = 7;
    private final int MAXCOL = 8;
    private final int SCALE = 100;
    private char [][] field = new char[MAXROW][MAXCOL];
    private String s = "Susi - the little robot";
    private String a = "<F> ... 1 Schritte vorwärts, <L> ... Drehe nach links";


    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(209); //https://processing.org/tutorials/color/
        fill(0, 102, 153);
    }

    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */
    public void draw() {

        deleteAll();

        text(s,10,40);
        text(a,10,60);

        drawGride();

        drawRobot(robot);

        delay(150);

        if (keyPressed){
            ifkeyPressed();
        }




    }

    private void drawGride() {
        // Horizontale Linien zeichnen
        for (int r = 1; r < MAXROW; r++) {
            line(1, r * SCALE - 1 + 100, MAXCOL * SCALE - 1, r * SCALE - 1 + 100);
        }

        // Vertikale Linien zeichnen
        for (int c = 1; c < MAXCOL; c++) {
            line(c * SCALE - 1, + 100, c * SCALE - 1, MAXROW * SCALE - 1 + 100);
        }

    }


    /**
     * Erstellen Sie eine eigene Methode, mittels der der Roboter am Bildschirm gezeichnet wird
     * Die Angabe zu Position des Roboters am Spielfeld erhalten Sie aus dem Roboter-Objekt, welches
     * als Parameter übergeben wird.
     *
     * @param robot Objekt des zu zeichnenden Roboters
     */
    public void drawRobot(Robot robot) {

        ellipse(robot.getX()*SCALE + 50, robot.getY()*SCALE + 150, SCALE-5, SCALE-5);

    }

    /**
     * Erstellen Sie eine eigene Methode zum Löschen des Bildschirms
     */
    public void deleteAll() {
        background(255);
    }

    /**
     * In dieser Methode reagieren Sie auf die Tasten
     */
    public void ifkeyPressed() {
        println("pressed " + key + " " + keyCode);

        if (key == 'f' || key == 'F') {
            robot.stepForward();
            System.out.println();

        } else if (key == 'l' || key == 'L') {
            robot.rotateLeft();
        }

    }

//    public void keyTyped() {
//        println("typed " + key + " " + keyCode);
//    }
//
//    public void keyReleased() {
//        println("released " + key + " " + keyCode);
//    }

}
