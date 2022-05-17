package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestGroupsCreation extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupsHelper().getGroupList();
    app.getGroupsHelper().initGroupCreation();
    app.getGroupsHelper().fillGroupForm(new GroupData("test4", "test4", "test4"));
    app.getGroupsHelper().submitGroupCreation();
    app.getGroupsHelper().returntoGroupPage();
    List<GroupData> after = app.getGroupsHelper().getGroupList();
    assertEquals(after.size(), before.size() + 1);
    app.logout();
  }

}
