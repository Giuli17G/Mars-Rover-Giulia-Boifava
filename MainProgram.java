import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {
  public static void main(String args[]) {

    ArrayList<Obstacle> obstacles = Utils.generateObstacles();
    MarsRover mr = Utils.generateMarsRover(obstacles);
    startCommandListener(obstacles, mr);
  }

  public static void startCommandListener(ArrayList<Obstacle> obstacles, MarsRover mr) {
    mr.printStatus();
    for(Obstacle obstacle : obstacles) {
      obstacle.printStatus();
    }
    System.out.println("\n Mars Rover Perseverance is ready. Waiting for instructions sequence from Washington...");
    System.out.println("  F: Foreward\n  B: Backward\n  L: Left\n  R: Right\n  Q: Quit");

    Scanner input = new Scanner(System.in);

    //Go!
    while(true) {      
      System.out.print("\nHere Washington: ");
      String sequenceInputString = (input.nextLine()).toUpperCase();
      char[] sequenceInput = sequenceInputString.toCharArray();
      for(char command : sequenceInput) {
        if(command=='Q') {
          input.close();
          return;
        }
        if(command == 'F' || command == 'B'){
          Obstacle obstacleFound = mr.move(command, obstacles);
          if (obstacleFound != null){
            System.out.println("Found obstacle "+obstacleFound.id+" in {x:"+obstacleFound.positionXY[0]+" y:"+obstacleFound.positionXY[1]+"}.\n    SEQUENCE INTERRUPTED..");
            break;
          }
        } else if (command == 'R' || command == 'L'){
          mr.turn(command);
        } else {
          System.out.println("Invalid input: ["+command+"].\n    SEQUENCE INTERRUPTED..");
          break;
        }
        mr.printStatus();
      }
    }
  }

}