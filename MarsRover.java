import java.util.ArrayList;
import java.util.Arrays;

public class MarsRover {

  //Attributes of the rover
  public int[] positionXY;
  public char direction;

  public MarsRover(int[] positionXY, char direction) {
    this.positionXY = positionXY;
    this.direction = direction;
  }

  public void printStatus() {
    System.out.println("*** Perseverance is in {x:"+positionXY[0]+" y:"+positionXY[1]+"} - {Direction:"+direction+"}");
  }

  //When turn, update direction
  public void turn(char turn) {
    //If North
    if(direction=='N' && turn=='L') {
      direction = 'W';
    }
    else if(direction=='N' && turn=='R') {
      direction = 'E';
    }

    //If South
    else if(direction=='S' && turn=='L') {
      direction = 'E';
    }
    else if(direction=='S' && turn=='R') {
      direction = 'W';
    }

    //If Est
    else if(direction=='E' && turn=='L') {
      direction = 'N';
    }
    else if(direction=='E' && turn=='R') {
      direction = 'S';
    }

    //If West
    else if(direction=='W' && turn=='L') {
      direction = 'S';
    }
    else if(direction=='W' && turn=='R') {
      direction = 'N';
    }
  }

  //Compute the shift
  public Obstacle move(char move, ArrayList<Obstacle> obstacles) {
    int[] nextPositionXY = Arrays.copyOf(positionXY, 2);

    int increment = 1;
    //If move down or left decrement
    if(((direction=='S' || direction=='W') && move=='F')
    || ((direction=='N' || direction=='E') && move=='B')) {
      increment = -1;
    }

    int positionToChange = 0;  //Change x (pos[0])
    //If shift along y
    if(direction=='S' || direction=='N') {
      positionToChange = 1;  //Change y (pos[1])
    }

    nextPositionXY[positionToChange] += increment;
    //Handle of out of space
    if(nextPositionXY[0]<0) {
      nextPositionXY[0] = Config.length;
    }
    else if(nextPositionXY[0] > Config.length) {
      nextPositionXY[0] = 0;
    }

    if(nextPositionXY[1]<0) {
      nextPositionXY[1] = Config.width;
    }
    else if(nextPositionXY[1] > Config.width) {
      nextPositionXY[1] = 0;
    }

    //Control obstacles
    Obstacle obstacle = Utils.getObstacleIntoPositionXY(obstacles, nextPositionXY);
    if(obstacle != null) {
      return obstacle;
    }
    positionXY = nextPositionXY;
    return null;
  } //End move
  
}