package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;
public class TestGroupsCreation extends TestBase {
  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupsHelper().getGroupList();
    GroupData group = new GroupData("test22", null, null);
    app.getGroupsHelper().initGroupCreation();
    app.getGroupsHelper().fillGroupForm(group);
    app.getGroupsHelper().submitGroupCreation();
    app.getGroupsHelper().returntoGroupPage();
    List<GroupData> after = app.getGroupsHelper().getGroupList();
    assertEquals(after.size(), before.size() + 1);
    before.add(group);
    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    before.sort(byId);
    after.sort(byId);
    assertEquals(before, after);
    app.logout();
  }

}
