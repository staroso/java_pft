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
    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
    }
    @Test
    public void testGroupDeletion() throws Exception {
      Groups before = app.db().groups();
      GroupData deletedGroup = (GroupData) before.iterator().next();
      app.group().delete(deletedGroup);
      assertThat(app.group().count(), equalTo(before.size() - 1));
      Groups after = app.db().groups();
      assertThat(after, equalTo(before.without(deletedGroup)));
      app.logout();
      verifyGroupListInUI();
    }
  }
