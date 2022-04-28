package dt.stqa.pft.sanbox;

public class PointDistance {

  public static void main(String[] args)
  {

    double x1 = 2;
    double x2 = 3;
    double y1 = 4;
    double y2 = 5;

    System.out.println("Расстояние между точками  = " + distance(x1, x2, y1, y2));
  }

  public static double distance(double x1, double x2, double y1, double y2) {
    return Math.sqrt((y1 - x1) *  (y1 - x1) + (y2 - x2) *  (y2 - x2));
  }

}