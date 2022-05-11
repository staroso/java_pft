package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class TestGroupsDeletion extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupsHelper().isThereAGroup()) {
      app.getGroupsHelper().createGroup(new GroupData("test4", "test4", "test4"));
    }
    app.selectGroup();
    app.getGroupsHelper().deleteSelectedGroup();
    app.getGroupsHelper().returntoGroupPage();
    app.logout();
  }

}
