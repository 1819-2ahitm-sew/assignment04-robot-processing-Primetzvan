package at.htl.robot.model;

public class Robot {

    private int x = 50;
    private int y = 150;
    private Direction direction = Direction.SOUTH;

    //region Getter and Setter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    //endregion

    public void stepForward() {
        switch (getDirection()){
            case EAST:
                setX(getX() + 100);
                break;
            case WEST:
                setX(getX() - 100);
                break;
            case NORTH:
                setY(getY() - 100);
                break;
            case SOUTH:
                setY(getY() + 100);
        }
    }

    public void rotateLeft(){
        switch (getDirection()){
            case NORTH:
                setDirection(Direction.WEST);
                break;
            case EAST:
                setDirection(Direction.NORTH);
                break;
            case SOUTH:
                setDirection(Direction.EAST);
                break;
            case WEST:
                setDirection(Direction.SOUTH);
                break;


        }
    }

}
