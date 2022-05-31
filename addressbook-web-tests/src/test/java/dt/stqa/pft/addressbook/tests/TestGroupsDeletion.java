package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class TestGroupsDeletion extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
      app.goTo().GroupPage();
      if (app.group().all().size() ==0) {
        app.group().create(new GroupData().withName("test2"));
      }
    }
    @Test
    public void testGroupDeletion() throws Exception {
      Set<GroupData> before = app.group().all();
      GroupData deletedGroup = before.iterator().next();
      app.group().delete(deletedGroup);
      Set<GroupData> after = app.group().all();
      assertEquals(after.size(), before.size() - 1);
      before.remove(deletedGroup);
      Assert.assertEquals(before, after);
      app.logout();
    }
  }
