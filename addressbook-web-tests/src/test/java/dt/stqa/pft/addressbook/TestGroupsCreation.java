package dt.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class TestGroupsCreation extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test4", "test4", "test4"));
    submitGroupCreation();
    returntoGroupPage();
    logout();
  }

}
