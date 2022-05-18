package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestGroupsCreation extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupsHelper().getGroupList();
    GroupData group = new GroupData("test1", null, null);
    app.getGroupsHelper().initGroupCreation();
    app.getGroupsHelper().fillGroupForm(group);
    app.getGroupsHelper().submitGroupCreation();
    app.getGroupsHelper().returntoGroupPage();
    List<GroupData> after = app.getGroupsHelper().getGroupList();
    assertEquals(after.size(), before.size() + 1);
    before.add(group);
    int max = 0;
    for (GroupData g :after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    group.setId(max);
    assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    app.logout();
  }

}
