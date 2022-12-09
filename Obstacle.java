public class Obstacle {

  public int[] positionXY;
  public int id;

  public Obstacle(int[] positionXY, int id) {
    this.positionXY = positionXY;
    this.id = id;
  }

  public void printStatus(){
    System.out.println(" Obstacle "+id+" is in {x:"+positionXY[0]+" y:"+positionXY[1]+"}");
  }
}