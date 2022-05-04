package dt.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class TestGroupsDeletion extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.selectGroup();
    app.getGroupsHelper().deleteSelectedGroup();
    app.getGroupsHelper().returntoGroupPage();
    app.logout();
  }

}
