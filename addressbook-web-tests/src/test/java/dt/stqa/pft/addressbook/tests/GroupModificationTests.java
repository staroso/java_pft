package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.group().list().size() ==0) {
      GroupData group = new GroupData().withName("test1");
    }
  }
  @Test
  public void testGroupModification () {
    app.goTo().GroupPage();
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group = new GroupData()
            .withId(before.get(index).getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    assertEquals(after.size(), before.size());
    before.remove (index);
    before.add(group);
    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    before.sort(byId);
    after.sort(byId);
    assertEquals(before, after);
  }


}
