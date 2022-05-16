package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestGroupsCreation extends TestBase {

  @Test
  public void testGroupCreation() {
    int before = app.getGroupsHelper().getGroupCount();
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupsHelper().initGroupCreation();
    app.getGroupsHelper().fillGroupForm(new GroupData("test4", "test4", "test4"));
    app.getGroupsHelper().submitGroupCreation();
    int after = app.getGroupsHelper().getGroupCount();
    assertEquals(after, before + 1);
    app.getGroupsHelper().returntoGroupPage();
    app.logout();
  }

}
