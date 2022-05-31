package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;
public class TestGroupsCreation extends TestBase {
  @Test
  public void testGroupCreation() {
    app.goTo().GroupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    assertEquals(after.size(), before.size() + 1);
    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    assertEquals(before, after);
    app.logout();
  }

}
