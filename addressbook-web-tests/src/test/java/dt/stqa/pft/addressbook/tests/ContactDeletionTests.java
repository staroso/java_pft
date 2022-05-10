package dt.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
public class ContactDeletionTests extends TestBase {
  @Test
  public void testDeleteContact() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().goToHomePage();
  }
}

