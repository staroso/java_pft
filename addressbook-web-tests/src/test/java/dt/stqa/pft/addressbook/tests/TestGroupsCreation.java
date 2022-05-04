package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class TestGroupsCreation extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupsHelper().initGroupCreation();
    app.getGroupsHelper().fillGroupForm(new GroupData("test4", "test4", "test4"));
    app.getGroupsHelper().submitGroupCreation();
    app.getGroupsHelper().returntoGroupPage();
    app.logout();
  }

}
