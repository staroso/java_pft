package dt.stqa.pft.addressbook.tests;
import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class TestGroupsDeletion extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
      app.goTo().GroupPage();
      if (app.group().list().size() ==0) {
        app.group().create(new GroupData().withName("test2"));
      }
    }
    @Test
    public void testGroupDeletion() throws Exception {
      List<GroupData> before = app.group().list();
      int index = before.size() - 1;
      app.group().delete(index);
      List<GroupData> after = app.group().list();
      assertEquals(after.size(), before.size() - 1);
      before.remove(index);
      Assert.assertEquals(before, after);
      app.logout();
    }
  }
