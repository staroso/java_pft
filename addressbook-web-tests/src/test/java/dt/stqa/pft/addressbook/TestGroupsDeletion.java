package dt.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class TestGroupsDeletion extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroup();
    returntoGroupPage();
    logout();
  }

}
