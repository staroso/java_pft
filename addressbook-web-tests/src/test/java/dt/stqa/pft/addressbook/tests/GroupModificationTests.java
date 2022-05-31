package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.group().all().size() ==0) {
      GroupData group = new GroupData().withName("test1");
    }
  }
  @Test(enabled = true)
  public void testGroupModification () {
    app.goTo().GroupPage();
    Set<GroupData> before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    assertEquals(after.size(), before.size());
    before.remove (modifiedGroup);
    before.add(group);
    assertEquals(before, after);
  }


}
