package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification () {
    int before = app.getGroupsHelper().getGroupCount();
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupsHelper().isThereAGroup()) {
      app.getGroupsHelper().createGroup(new GroupData("test4", "test4", "test4"));
    }
    app.selectGroup();
    app.getGroupsHelper().initGroupModification();
    app.getGroupsHelper().fillGroupForm(new GroupData("test4", null, "test4"));
    app.getGroupsHelper().submitGroupModification();
    app.getGroupsHelper().returntoGroupPage();
    int after = app.getGroupsHelper().getGroupCount();
    assertEquals(after, before);
  }
}
