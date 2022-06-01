package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.GroupData;
import dt.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestGroupsDeletion extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
      app.goTo().GroupPage();
      if (app.group().all().size() ==0) {
        app.group().create(new GroupData().withName("test1"));
      }
    }
    @Test
    public void testGroupDeletion() throws Exception {
      Groups before = app.group().all();
      GroupData deletedGroup = (GroupData) before.iterator().next();
      app.group().delete(deletedGroup);
      Groups after = app.group().all();
      assertThat(after.size(), equalTo(before.size() - 1));

      assertThat(after, equalTo(before.without(deletedGroup)));
      app.logout();
    }
  }
