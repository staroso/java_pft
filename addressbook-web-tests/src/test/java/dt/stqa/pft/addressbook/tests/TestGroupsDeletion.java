package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestGroupsDeletion extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    int before = app.getGroupsHelper().getGroupCount();
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupsHelper().isThereAGroup()) {
      app.getGroupsHelper().createGroup(new GroupData("test4", "test4", "test4"));
    }
    app.getGroupsHelper().selectGroup(before - 1);
    app.getGroupsHelper().deleteSelectedGroup();
    app.getGroupsHelper().returntoGroupPage();
    int after = app.getGroupsHelper().getGroupCount();
    assertEquals(after, before - 1);
    app.logout();
  }

}
