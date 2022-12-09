import java.util.ArrayList;
import java.util.Random;

public final class Utils {

  public static ArrayList<Obstacle> generateObstacles() {
    ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    for(int i=0; i<Config.obstaclesCounter; i++){      
      int[] positionXY = generateRandomAndAvailablePositionXY(obstacles);
      obstacles.add(new Obstacle(positionXY, i+1));
    }
    return obstacles;
  }

  public static MarsRover generateMarsRover(ArrayList<Obstacle> obstacles){
    char direction = generateRandomDirection();
    int[] positionXY = generateRandomAndAvailablePositionXY(obstacles);
    return new MarsRover(positionXY, direction);
  }

  public static int[] generateRandomAndAvailablePositionXY(ArrayList<Obstacle> obstacles){
    int[] positionXY;
    do {
      positionXY = generateRandomPositionXY();
    }
    while(getObstacleIntoPositionXY(obstacles, positionXY)!=null);
      return positionXY;
    }

  public static int[] generateRandomPositionXY() {
    int[] randomXY = new int[2];
    Random random = new Random();
    randomXY[0] = random.nextInt(Config.length);
    randomXY[1] = random.nextInt(Config.width);
    return randomXY;
  }

  public static char generateRandomDirection() {
    char[] randomDirection = {'N', 'S', 'E', 'W'};
    Random random = new Random();
    int ranDir = random.nextInt(4);
    return randomDirection[ranDir];
  }

  public static Obstacle getObstacleIntoPositionXY(ArrayList<Obstacle> obstacles, int[] positionXY) {
    for(Obstacle obstacle : obstacles) {
      if(obstacle.positionXY[0] == positionXY[0] && obstacle.positionXY[1] == positionXY[1]){
        //Print position of obstacle
        return obstacle;
      }
    }
    return null;
  }

}