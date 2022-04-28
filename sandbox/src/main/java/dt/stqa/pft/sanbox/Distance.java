package dt.stqa.pft.sanbox;

public class Distance{

  public static void main(String[] args) {

    Point P = new Point(2, 3, 4, 5);
    System.out.println("Расстояние между точками  = " + distance(P));
  }
  public static double distance (Point P){
    return Math.sqrt((P.y1-P.x1)*(P.y1-P.x1)+(P.y2-P.x2)*(P.y2-P.x2));
  }
}