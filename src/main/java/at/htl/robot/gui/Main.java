package at.htl.robot.gui;

import at.htl.robot.model.Robot;
import processing.core.PApplet;


public class Main extends PApplet {

    // Hier die Member-Attribute eintragen
    Robot robot = new Robot();

    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(209); //https://processing.org/tutorials/color/


    }

    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */
    public void draw() {

        deleteAll();
        for (int i = 100; i < width; i+= 100) {
                line( 0, i, 800, i);
                line(i, 100, i, 800);
            }

        drawRobot(robot);

        delay(1000);

        if (keyPressed){
            keyPressed();
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
        ellipse(robot.getX(), robot.getY(), 100, 100);

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
    public void keyPressed() {
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
