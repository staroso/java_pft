package dt.stqa.pft.sandbox;

import dt.stqa.pft.sanbox.Point;
import org.testng.Assert;
import org.testng.annotations.Test;
public class PointTests {
  @Test
  public void testDistance1() {
    Point p1 = new Point(2, 3);
    Point p2 = new Point(3, 4);
    Assert.assertEquals(p1.distance(p1, p2), 1.4142135623730951);

  }

  @Test
  public void testDistance2() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 0);
    Assert.assertEquals(p1.distance(p1, p2), 0);
  }

  @Test
  public void testDistance3() {
    Point p1 = new Point(-2, -3);
    Point p2 = new Point(-4, -5);
    Assert.assertEquals(p1.distance(p1, p2), 2.8284271247461903);
  }
}
