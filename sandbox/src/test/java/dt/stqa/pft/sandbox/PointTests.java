package dt.stqa.pft.sandbox;

import dt.stqa.pft.sanbox.Point;
import org.testng.Assert;
import org.testng.annotations.Test;
public class PointTests {
  @Test
  public void testArea() {
    Point p1 = new Point(2, 3);
    Point p2 = new Point(3, 4);
    Assert.assertEquals(p1.distance(p1, p2), 1.4142135623730951);
  }
}
