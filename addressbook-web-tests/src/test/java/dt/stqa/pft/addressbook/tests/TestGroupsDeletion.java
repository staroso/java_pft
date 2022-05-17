package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestGroupsDeletion extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupsHelper().isThereAGroup()) {
      app.getGroupsHelper().createGroup(new GroupData("test4", "test4", "test4"));
    }
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupsHelper().getGroupList();
    app.getGroupsHelper().selectGroup(before.size() - 1);
    app.getGroupsHelper().deleteSelectedGroup();
    app.getGroupsHelper().returntoGroupPage();
    List<GroupData> after = app.getGroupsHelper().getGroupList();
    assertEquals(after.size(), before.size() - 1);
    app.logout();
  }

}
